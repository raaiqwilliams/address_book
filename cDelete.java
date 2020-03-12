import java.sql.*;
import java.util.Scanner;

public class cDelete extends AddressBook{
    static void contactDelete(){
        // Connection and Statement objects allocated.
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/address_book?useSSL=false",
                "myuser", "12345678"); Statement statement = conn.createStatement();) {

            Scanner s = new Scanner(System.in);
            //Requesting user for input to adjust SQL query as needed        
            System.out.println("Which column would you like to delete?");
            String field = s.next();
            //Once more requesting user input to determine conditional of delete clause
            System.out.println("Parameters for deletion: ");
            String parameter = s.next();
            //Concatenating String "sqlQuery", printing and execution.
            String sqlQuery = "delete from address_book where " + field + "=" + parameter;
            System.out.println("Your sqlQuery is " + sqlQuery);
            statement.executeUpdate(sqlQuery);
            
            System.out.println("Deletion successful!");
            s.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}