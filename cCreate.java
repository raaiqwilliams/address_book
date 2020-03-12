import java.sql.*;
import java.util.Scanner;

public class cCreate extends AddressBook{
    static void contactCreate(){
        //Connection and Statement objects allocated.
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/address_book?useSSL=false",
                "myuser", "12345678"); Statement statement = conn.createStatement();) {
            //Establishing Scanner object
            Scanner s = new Scanner(System.in);
            //Concatenating String "sqlQuery", along with execution.
            String sqlQuery = "insert into address_book values(" + query(s) + ")";
            statement.executeUpdate(sqlQuery);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Method to receive all details regarding new addition to contact list.
    //NB: This method assumes that all fields are being entered without any NULL values.
    private static String query(Scanner s) {
        System.out.print("New Contact ID: ");
        int id = s.nextInt();
        System.out.print("New Contact First Name: ");
        String fName = "'" + s.next() + "'";
        System.out.print("New Contact Last Name: ");
        String lName = "'" + s.next() + "'" ;
        System.out.print("New Contact Phone Number: ");
        String num = "'" + s.next() + "'";
        System.out.print("New Contact Email Address: ");
        String email = "'" + s.next() + "'";

        String query = id + "," + fName + "," + lName + "," + num + "," + email;
        return query;
    }
}