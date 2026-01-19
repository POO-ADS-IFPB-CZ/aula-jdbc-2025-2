package view;

import database.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        try {
            Connection connection = connectionFactory.getConnection();
            if (connection != null){
                System.out.println("Conectado ao banco");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
