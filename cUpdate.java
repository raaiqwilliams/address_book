import java.sql.*;
import java.util.Scanner;

public class cUpdate extends AddressBook{

    static void contactUpdate(){
        //Connection and Statement objects allocated.
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/address_book?useSSL=false",
                "myuser", "12345678"); Statement statement = conn.createStatement();) {
            //Establishing Scanner object "s".
            Scanner s = new Scanner(System.in);
            //Receiving user input to adjust SQL Query as needed.
            System.out.print("Which column would you like to update: ");
            String field = s.next();
            System.out.println("Enter new value: ");
            String update = s.next();

            //User input to adjust SQL Query relative to which field is used as conditional.
            System.out.println("Parameters for update: ");
            System.out.print("Column: ");
            String parameterC = s.next();
            System.out.print("Value: ");
            String parameterV = s.next();
            
            //Creating String "sqlQuery" by concatenation, printing out the SQL query and executing.
            String sqlQuery = "update address_book set " + field + " = " + update + " where " + parameterC + " = "
                    + parameterV;
            System.out.println("Your SQL Query is " + sqlQuery);
            statement.executeUpdate(sqlQuery);
            
            s.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}