package org.example.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class IncidentDAO {

    public void viewIncidents(Connection con) {
        String query = "SELECT i.incident_id, i.incident, i.status, u.username " +
                "FROM incidents i JOIN users u ON i.user_id = u.id ORDER BY i.incident_id";

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);


            System.out.printf("\n%-5s %-30s %-15s %-10s\n", "ID", "Incident", "Status", "User");
            System.out.println("-------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-5d %-30s %-15s %-10s\n",
                        rs.getInt("incident_id"),
                        rs.getString("incident"),
                        rs.getString("status"),
                        rs.getString("username"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void addIncidents(Connection con, Scanner scanner) {


    }
}
