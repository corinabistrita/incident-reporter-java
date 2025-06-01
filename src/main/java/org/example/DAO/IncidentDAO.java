package org.example.DAO;

import org.example.Database.IncidentDB;
import org.example.Model.Incident;

import java.awt.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class IncidentDAO {

    public void viewIncidents(Connection con) {
        String query = "SELECT incident_id, incident, status,description, priority, created_at, user_id " +
                "FROM incidents";

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);


            System.out.printf("\n%-5s %-25s %-15s %-12s %-18s %-5s\n",
                    "ID", "Incident Title", "Status", "Priority", "Created At", "USER");
            System.out.println("-------------------------------------------------------------------------------");

            while (rs.next()) {
                Incident incident = new Incident(
                        rs.getInt("incident_id"),
                        rs.getString("incident"),
                        rs.getString("status"),
                        rs.getString("description"),
                        rs.getString("priority"),
                        rs.getTimestamp("created_at").toLocalDateTime().toLocalDate(),
                        rs.getString("user_id"));
                System.out.println(incident);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void addIncidents(Connection con, Scanner scanner) throws SQLException {
        System.out.println("----------------ADD NEW INCIDENT----------------");

        System.out.println("Insert your incident title: ");
        String title = scanner.nextLine().trim();

        System.out.println("Insert description: ");
        String description = scanner.nextLine().trim();

        System.out.println("Insert your status: ");
        String status = scanner.nextLine().trim();

        System.out.println("Insert priority (Low, Medium, High, Extreme) [default: Medium]: ");
        String priority = scanner.nextLine().trim();

        if (priority.isEmpty()){
            priority = "Medium";
        }

        System.out.print("Enter your User ID (e.g. 2 for user1): ");
        int userId;
        try {
            userId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid User ID. Aborting insert.");
            return;
        }

        LocalDate created_at = LocalDate.now();

        Incident incident = new Incident(title,status,description,priority,created_at,userId);

        String insertsql = "INSERT INTO incidents (title, status, description, priority, created_at, userId) " +
                "VALUES (?, ?, ?, ?, ?, ?); ";

        PreparedStatement stmt = con.prepareStatement(insertsql);
        stmt.setString(1, incident.getIncident());
        stmt.setString(2, incident.getStatus());
        stmt.setString(3, incident.getDescription());
        stmt.setString(4, incident.getPriority());
        stmt.setDate(5,Date.valueOf(incident.getCreated_at()));
        stmt.setString(6, incident.getUser_id());

        int rows_affected = stmt.executeUpdate();
            if(rows_affected>0)
                System.out.println("Data added successfully.");
    }
}
