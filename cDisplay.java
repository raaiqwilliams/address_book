//Class to display current list of contacts along with all details

import java.sql.*;

public class cDisplay extends AddressBook{
    static void contactDisplay(){
        //Connection and Statement objects allocated.
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/address_book?useSSL=false",
                "myuser", "12345678"); Statement statement = conn.createStatement();) {
            ResultSet rs = statement.executeQuery("SELECT * FROM address_book");
        //Setting up formatting for clarity
            System.out.println("========================================================================");
            System.out.println("ID  First_Name     Last_Name       Contact_Number      Email_Address");
            System.out.println("========================================================================");
        //Using ResultSet to select and store into variables
            while (rs.next()) {
                int id = rs.getInt("id");
                String fName = rs.getString("first_name");
                String lName = rs.getString("last_name");
                String contact = rs.getString("contact_number");
                String email = rs.getString("email_address");
        //Print variables
                System.out.println(
                        id + "   " + fName + "             " + lName + "           " + contact + "         " + email);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}