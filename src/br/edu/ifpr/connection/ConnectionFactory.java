package br.edu.ifpr.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() {

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection("jdbc:mysql://localhost/agenda", "root", "root");

        } catch (ClassNotFoundException | SQLException e){
            e.getMessage();
        }

        return connection;
    }

}
