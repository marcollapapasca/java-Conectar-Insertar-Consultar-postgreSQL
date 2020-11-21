package com.example.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class PostgreSQL {
    final ResourceBundle bundle = PropertyResourceBundle.getBundle("PostgreSQL");

    public Connection connectDatabase() {
        Connection connection = null;

        String host = bundle.getString("host");
        String port = bundle.getString("port");
        String database = bundle.getString("database");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        connection = cnx(host, port, database, user, password);

        return connection;
    }

    private Connection cnx(String host, String port, String database,
                           String user, String password) {
        String url = "";
        try {
            // Registrar el driver de PostgresSQL
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
            }
            Connection connection = null;
            url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
            // Conectar con la base de datos de PostgreSQL
            connection = DriverManager.getConnection(url, user, password);
            boolean valid = connection.isValid(50000);
            System.out.println(valid ? "Success" : "Fail");
            return connection;
        } catch (java.sql.SQLException ex) {
            System.out.println("Error al conectar con la base de datos de PostgreSQL (" + url + "): " + ex);
        }
        return null;
    }
}
