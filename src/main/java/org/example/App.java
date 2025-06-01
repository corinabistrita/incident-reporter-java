package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import org.example.DAO.IncidentDAO;
import org.example.Database.IncidentDB;

public class App
{

    public static void main( String[] args ) throws SQLException {

        Connection con = IncidentDB.getConnection();

        Scanner scanner = new Scanner(System.in);
        IncidentDAO incid = new IncidentDAO();

        while(true){
            System.out.println("<----------------Incident reporter menu--------------->");
            System.out.println("1.View Incident.\n2.Add Incident.\n3.Exit.");
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    incid.viewIncidents(con);
                    break;
                case 2:
                    incid.addIncidents(con,scanner);
                    break;
                case 3:
                    System.out.println("Closing");
                    scanner.close();
                    return;
                default:
                    System.out.println("INVALID CHOICE TRY AGAIN :");
            }
        }
    }
}
