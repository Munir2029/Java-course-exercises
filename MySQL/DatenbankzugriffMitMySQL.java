

package MySQL;

import java.sql.*;
import java.util.Scanner;

public class DatenbankzugriffMitMySQL {

    static String dbUrl = "jdbc:mysql://localhost:3306/datenbank_zugriff_java";
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

            int choice = 0;
            do {

                System.out.println("------------------------");
                if (loggedInAs.length() > 0) {
                    System.out.println("Logged in as: " + loggedInAs);
                } else {
                    System.out.println("Not logged in yet");
                }
                System.out.println("------------------------");
                if (loggedInAs.length() == 0) {
                    System.out.println("1. Login");
                } else {
                    System.out.println("2. Alle User anzeigen");
                    System.out.println("3. Neuen User anlegen");
                    System.out.println("4. PW ändern");
                    System.out.println("5. User löschen");
                    System.out.println("6. Logout");
                }
                System.out.println("------------------------");

                System.out.println("Was willst du tun?");
                choice = sc.nextInt();

                if (loggedInAs.length() == 0 && choice == 1) {
                    login();
                } else {
                    switch (choice) {
                        case 2:
                            selectAllUsers();
                            break;
                        case 3:
                            insertNewUser();
                            break;
                        case 4:
                            updateUser();
                            break;
                        case 5:
                            deleteUser();
                            break;
                        case 6:
                            logout();
                            break;
                    }
                }
            } while (choice != 0);


            // Always close the connection when you are done
            connection.close();
            System.out.println("Connection closed.");

        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void updateUser() {
        try {
            connection = DriverManager.getConnection(dbUrl, username, password);
            String sqlInsert = "UPDATE users SET PW = ? WHERE Username = ? AND PW = ?";

            preparedStatement = connection.prepareStatement(sqlInsert);

            System.out.println("Geben Sie bitte die altes Passwort");
            String altesPasswort = sc.next();
            System.out.println("Geben Sie bitte die neues Passwort ");
            String neuesPasswort =sc.next();
            preparedStatement.setString(1,neuesPasswort);
            preparedStatement.setString(2,loggedInAs);
            preparedStatement.setString(3,altesPasswort);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println(" das Passwort von '" + loggedInAs+ "' es wurde gäendert");
            }else {
                System.out.println("ungültiger Passwort");
            }

        } catch (SQLException e) {

e.printStackTrace();
        }
        finally {
            // Close resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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
                String uname = resultSet.getString("username");
                System.out.println("User " + uname + " logged in successfully");
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
        loggedInAs = "";
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

            String sqlInsert = "DELETE FROM users WHERE Username = ? AND PW = ?";

            // Create a PreparedStatement object
            preparedStatement = connection.prepareStatement(sqlInsert);

            // Set the values for the placeholders
            System.out.println("Welche UserName willst löschen :");
            String newUsername = sc.next();
            System.out.println("Aber du braucht die Richtige Passwort eintippen:");
            String newPassword = sc.next();

            // Set the parameters for the query
            preparedStatement.setString(1, newUsername); // First '?'
            preparedStatement.setString(2, newPassword); // Second '?'

            // Execute the update
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User '" + newUsername + "' DELETE successfully!");
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
}
