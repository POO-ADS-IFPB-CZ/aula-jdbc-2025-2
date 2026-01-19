package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private Connection connection;

    public Connection getConnection() throws ClassNotFoundException,
            SQLException {
        Class.forName("org.postgresql.Driver");

        //Jeito errado - não façam isso em casa
        String user = "postgres.sphgmydbqqijloubhavg";
        String password = "Mmp6mPNWXX2B9gHO";
        String host = "aws-1-us-east-2.pooler.supabase.com";
        int port = 5432;
        String database = "postgres";

        //TODO: trocar para StringBuilder
        connection = DriverManager.getConnection(
                "jdbc:postgresql://"+host+":"+port+"/"+database,
                user,
                password
        );

        return connection;
    }

}
