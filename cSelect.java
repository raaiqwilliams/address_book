import java.sql.*;
import java.util.Scanner;

public class cSelect extends AddressBook{
    static void contactSelect(){
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/address_book?useSSL=false",
                "myuser", "12345678"); Statement statement = conn.createStatement();) {
            // Requesting user input to specify column which they'd like to search
            System.out.print("Which field you would like to select: ");
            String input = userInput();
            // Requesting user input for search parameters
            System.out.print("Your search parameter: ");
            String parameter = userInput();
            // Establish strSelect variable
            String strSelect;

            // Setting strSelect to a value depending on the user selected ID or not (as int
            // value would not require inverted commas)
            if (input == "ID") {
                strSelect = "select * from address_book where " + input + " = " + parameter;
            } else {
                strSelect = "select * from address_book where " + input + " = '" + parameter + "'";
            }
            // Printing SQL query
            System.out.println("===========================================================");
            System.out.println("The SQL search query is: " + strSelect);
            System.out.println("===========================================================");
            System.out.println();
            // Allocating ResultSet object to filter through records and establish rowcount
            // variable
            ResultSet rs = statement.executeQuery(strSelect);
            System.out.println("The record(s) found are:");
            int rowCount = 0;
            // Printing headers of columns for clarity purposes
            System.out.println("========================================================================");
            System.out.println("ID  First_Name     Last_Name       Contact_Number      Email_Address");
            System.out.println("========================================================================");
            // While loop to "search" through records containing desired parameters
            while (rs.next()) {
                int id = rs.getInt("id");
                String fName = rs.getString("first_name");
                String lName = rs.getString("last_name");
                String contact = rs.getString("contact_number");
                String email = rs.getString("email_address");
                System.out.println(
                        id + "   " + fName + "             " + lName + "           " + contact + "         " + email);
            //Incrementing rowCount variable to allow for multiple loops
                ++rowCount;
            }
            //Printing rowCount variable to show number of records found
            System.out.println();
            System.out.println("Total number of records = " + rowCount);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static String userInput() {
        Scanner s = new Scanner(System.in);
        String userValue;
        userValue = s.next();
        return userValue;
    }
}