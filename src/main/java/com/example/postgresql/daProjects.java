package com.example.postgresql;

import java.sql.*;

public class daProjects {

    void insert(Projects projects) {
        PostgreSQL postgreSQL = new PostgreSQL();
        String query = String.format("INSERT INTO developer.projects(name,description) VALUES('%s','%s')",
                projects.getName(), projects.getDescription());

        try {
            Connection con = postgreSQL.connectDatabase();
            Statement stmnt = null;
            stmnt = con.createStatement();
            stmnt.executeUpdate(query);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    void select() {
        PostgreSQL postgreSQL = new PostgreSQL();
        String query = "SELECT * FROM developer.projects";

        try (Connection con = postgreSQL.connectDatabase();
             PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {

                System.out.print("project_id: " + rs.getString(1));
                System.out.print(" | ");
                System.out.print("name: " + rs.getString(2));
                System.out.print(" | ");
                System.out.println("created_at: " + rs.getString(4));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
