package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private Connection connection;

    public Connection getConnection() throws ClassNotFoundException,
            SQLException, IOException {
        Class.forName("org.postgresql.Driver");

        FileInputStream in = new
                FileInputStream("database.properties");
        Properties properties = new Properties();
        properties.load(in);
        //TODO: trocar para StringBuilder
        connection = DriverManager.getConnection(
                "jdbc:postgresql://"+properties.get("host")+":"+
                        properties.get("port")+"/"+
                        properties.get("database"),
                ""+properties.get("user"),
                ""+properties.get("password")
        );

        return connection;
    }

}
