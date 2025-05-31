package org.example;

import java.util.Scanner;

public class App
{
    public static void main( String[] args ){
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("1.View Incident.\n 2.Add Incident.\n3.Exit.");
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
        }
    }
}
