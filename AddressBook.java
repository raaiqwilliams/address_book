//AddressBook by Mogamad Raa-iq Williams
//This is a minor implementation of a web application that allows a user to perform a number of operations on an address book.
//PLEASE NOTE: This implementation is extremely basic due to time constraints, logical errors may be present throughout the program.

import java.util.Scanner;

public class AddressBook{

    public static void main(String[] args){

        //Printing menu, establishing variables to be used in switch-case statement, and initializing Scanner object
        printMenu();
        int input;
        Scanner s = new Scanner(System.in);
        System.out.print("Please select a choice from the menu using numbers 1-5 (0 to exit): ");
        input = s.nextInt();
        //While loop containing switch-case statement to allow for user to repeatedly select all possible options
        while (input != 0){
        switch (input) {
            case 1:
                System.out.println("You have chosen to display all contacts.");
                cDisplay.contactDisplay();
                break;
            case 2:
                System.out.println("You have chosen to create a new contact.");
                cCreate.contactCreate();
                break;
            case 3:
                System.out.println("You have chose to search existing contacts.");
                cSelect.contactSelect();
                break;
            case 4:
                System.out.println("You have chosen to update an existing contact.");
                cUpdate.contactUpdate();
                break;
            case 5:
                System.out.println("You have chosen to delete an existing contact.");
                cDelete.contactDelete();
                break;
            case 0:
                System.out.println("Thank you for using the address book!");
                System.exit(0);
            }
        //Printing menu and adjusting value of variable "input" once initial choice is performed
        printMenu();
        input = s.nextInt();
        }
        
        s.close();
    }
    //Method to print menu
    private static void printMenu() {
        System.out.println();
        System.out.println("=====================");
        System.out.println("Address Book Options");
        System.out.println("=====================");
        System.out.println("1. Display all current contacts.");
        System.out.println("2. Create a new contact.");
        System.out.println("3. Search for an existing contact.");
        System.out.println("4. Update an existing contact.");
        System.out.println("5. Delete an existing contact.");
        System.out.println("0. Exit");
        System.out.println("=====================");
        System.out.println();
    }
}