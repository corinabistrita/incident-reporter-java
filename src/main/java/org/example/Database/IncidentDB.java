package org.example.Database;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class IncidentDB {
    private final String URL = "jdbc:postgresql://localhost:5432/incident_reporter";
    private final String USER = "postgre";
    private final String PASSWORD = "root";

        Connection con;

    {
        try {
            con = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
