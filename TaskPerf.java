package TaskPerf6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TaskPerf {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Hello and Welcome!");
            System.out.println("Please, Select a number:");
            System.out.println("1. Log In");
            System.out.println("2. Create Account");

            int option = input.nextInt();
            input.nextLine(); // Consume newline character

            if (option == 1) {
                // Log In
                System.out.println("Enter Username:");
                String username = input.nextLine();
                System.out.println("Enter Password:");
                String password = input.nextLine();

                try {
                    BufferedReader reader = new BufferedReader(new FileReader("C:/Users/i/MichiroYamazaki/Documents/Database.txt"));
                    String line;
                    boolean found = false;

                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(",");
                        if (parts[0].equals(username) && parts[1].equals(password)) {
                            found = true;
                            break;
                        }
                    }
                    reader.close();

                    if (found) {
                        System.out.println("Successfully logged in!");
                    } else {
                        System.out.println("Incorrect username or password. Please try again.");
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred while accessing the file. Please check the file and try again.");
                }
            } else if (option == 2) {
                // Create Account
                System.out.println("Enter Username:");
                String username = input.nextLine();
                System.out.println("Enter Password:");
                String password = input.nextLine();
                System.out.println("Re-type Password:");
                String retypePassword = input.nextLine();

                if (username.matches("[a-zA-Z0-9]+$") && password.matches("[a-zA-Z0-9]+$")) {
                    while (!password.equals(retypePassword)) {
                        System.out.println("Passwords do not match. Please re-enter your password:");
                        password = input.nextLine();
                        System.out.println("Re-type Password:");
                        retypePassword = input.nextLine();
                    }

                    try {
                        BufferedReader reader = new BufferedReader(new FileReader("C:/Users/i/MichiroYamazaki/Documents/Database.txt"));
                        String line;
                        boolean usernameExists = false;

                        while ((line = reader.readLine()) != null) {
                            String[] parts = line.split(",");
                            if (parts[0].equals(username)) {
                                usernameExists = true;
                                break;
                            }
                        }
                        reader.close();

                        if (usernameExists) {
                            System.out.println("An account with that username already exists.");
                        } else {
                            FileWriter writer = new FileWriter("C:/Users/i/MichiroYamazaki/Documents/Database.txt", true);
                            writer.write(username + "," + password + "\n");
                            writer.close();
                            System.out.println("Successfully created an account!");
                        }
                    } catch (IOException e) {
                        System.out.println("An error occurred while accessing the file. Please check the file and try again.");
                    }
                } else {
                    System.out.println("Only alphanumeric characters are allowed for username and password.");
                }
            } else {
                System.out.println("Invalid input! Please try again.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred. Please try again.");
        }
    }
}
