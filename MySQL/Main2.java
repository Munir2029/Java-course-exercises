package MySQL;

import java.sql.*;
import java.util.Scanner;

public class Main2 {

    static String dbUrl = "jdbc:mysql://localhost:3306/usertest";
    static String username = "root"; // XAMPP default username
    static String password = ""; // XAMPP default password is an empty string

    static String loggedInAs = "";

    static Statement statement = null;
    static ResultSet resultSet = null;
    static Connection connection;
    static PreparedStatement preparedStatement = null;
    static Scanner sc;

    public static void main(String[] args) {
        // Database credentials


        sc = new Scanner(System.in);

        try {
            // Register the JDBC driver (optional for newer Java versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("Connection to the database was successful!");

            // Now you can execute SQL statements, etc.
            // ...
//            System.out.println("hhhhhhhhhhhh "+loggedInAs.length());
            int choice = 0;
            do {

                System.out.println("------------------------");
                if (loggedInAs.length() > 0) {
                    System.out.println("Logged in as: " + loggedInAs);
                } else {
                    System.out.println("Not logged in yet");
                }
                System.out.println("------------------------");
                System.out.println("1. Alle User anzeigen");
                System.out.println("2. Neuen User anlegen");
                System.out.println("3. PW ändern");
                System.out.println("4. User löschen");
                System.out.println("5. Login");
                System.out.println("6. Logout");
                System.out.println("------------------------");

                System.out.println("Was willst du tun?");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        selectAllUsers();
                        break;
                    case 2:
                        insertNewUser();
                        break;
                    case 3:
                        updateUser();
                        break;
                    case 4:
                        deleteUser();
                        break;
                    case 5:
                        login();
                        break;
                    case 6:
                        logout();
                        break;
                }
            } while (choice != 0);


            // Always close the connection when you are done
            connection.close();
            System.out.println("Connection closed.");

        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Database connection failed: ");
            //System.out.println(e.getMessage());
            System.out.println("------");
            //e.printStackTrace();
        }
    }

    public static void updateUser() {
        try {
            connection = DriverManager.getConnection(dbUrl, username, password);
            String sqlpdateUser = " UPDATE users set pw=? WHERE username=?";
            preparedStatement = connection.prepareStatement(sqlpdateUser);
            System.out.println("Wähle Username:");
            String derNameDessenPasswortGändertWird = sc.next();
            System.out.println("Wähle einen neuen PW:");
            String newPassword = sc.next();

            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, derNameDessenPasswortGändertWird);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User '" + derNameDessenPasswortGändertWird + "' Password has been changed");
            }
        }
            catch (Exception e) {
                e.printStackTrace();
            } finally {
                // Close resources
                try {
                    if (preparedStatement != null) preparedStatement.close();
                    if (connection != null) connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        // TODO: update machen
    }

    public static void insertNewUser() {
        // The SQL INSERT query with placeholders

        try {
            connection = DriverManager.getConnection(dbUrl, username, password);

            String sqlInsert = "INSERT INTO users (username, pw) VALUES (?, ?)";

            // Create a PreparedStatement object
            preparedStatement = connection.prepareStatement(sqlInsert);

            // Set the values for the placeholders
            System.out.println("Wähle Username:");
            String newUsername = sc.next();
            System.out.println("Wähle dein PW:");
            String newPassword = sc.next();

            // Set the parameters for the query
            preparedStatement.setString(1, newUsername); // First '?'
            preparedStatement.setString(2, newPassword); // Second '?'

            // Execute the update
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User '" + newUsername + "' inserted successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void login() {
        // Create a statement object to send SQL statements to the database
        try {
            connection = DriverManager.getConnection(dbUrl, username, password);

            // SQL query to select all data from a table named 'users'
            String sqlQuery = "SELECT * FROM users WHERE username = ? AND pw = ?";

            preparedStatement = connection.prepareStatement(sqlQuery);

            System.out.println("Username:");
            String username = sc.next();
            System.out.println("PW:");
            String pw = sc.next();

            preparedStatement.setString(1, username); // First '?'
            preparedStatement.setString(2, pw); // Second '?'

            // Execute the query and get the result set
            resultSet = preparedStatement.executeQuery();

            // Process the result set
            if (resultSet.next()) {
                System.out.println("User " + username + " logged in successfully");
                loggedInAs = username;
            } else {
                System.out.println("Login doesn't exist or PW is incorrect!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void logout() {
//        connection=DriverManager.getConnection(dbUrl, username, password);

        // TODO: machen!
    }

    public static void selectAllUsers() {
        // Create a statement object to send SQL statements to the database
        try {
            connection = DriverManager.getConnection(dbUrl, username, password);

            statement = connection.createStatement();

            // SQL query to select all data from a table named 'users'
            String sqlQuery = "SELECT id, username, pw FROM users";

            // Execute the query and get the result set
            resultSet = statement.executeQuery(sqlQuery);

            // Process the result set
            System.out.println("All users:");
            while (resultSet.next()) {
                // Retrieve data by column name or index
                int id = resultSet.getInt("id");
                String name = resultSet.getString("username");
                String pw = resultSet.getString("pw");

                // Print the data to the console
                System.out.println("ID: " + id + ", Name: " + name + ", PW: " + pw);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteUser() {
        try {
            connection = DriverManager.getConnection(dbUrl, username, password);
            String sqlDeleteUser1 = "DELETE FROM users WHERE username=? ";
            preparedStatement = connection.prepareStatement(sqlDeleteUser1);
            System.out.println("Wähle Username:");
            String derNameDerGeloschtWerdenSoll = sc.next();
            preparedStatement.setString(1, derNameDerGeloschtWerdenSoll);
            int rowsAffected = preparedStatement.executeUpdate();     //executeUpdate تعني كم صف row تاثر في عملية البحث

            if (rowsAffected > 0) {
                System.out.println("User '" + derNameDerGeloschtWerdenSoll + "' deleted successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // TODO: machen
    }
}
