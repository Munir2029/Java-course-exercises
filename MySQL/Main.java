package MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {


    static String dbUrl="jdbc:mysql://localhost:3306/usertest";
    static String username="root"; // XAMPP default username
    static String password="";//XAMPP default password is an empty string

    static String loggedInaAs;


    static Statement statement=null;;
    static ResultSet resultSet=null;
    static Connection connection;
    static PreparedStatement preparedStatement=null;
    static Scanner sc;


    public static void main(String[] args) {


    }
}
