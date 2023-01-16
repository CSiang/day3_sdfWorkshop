package tfip;

import java.io.Console;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        String dirPath = "\\data2";
        String filename = "";


        // Instantiate a file/directopry object.
        File newDirectory = new File(dirPath);

        // if directroy exists, print to console "directory exist" message
        // else create the directory
        if(newDirectory.exists()) {
            System.out.println("Directory already exists.");
        } else {
            newDirectory.mkdir();
        }

        System.out.println("Welcome to my shopping cart.");

        // to store user's cart items.
        String strValue = "";
        List<String> cartItems = new ArrayList<String> ();

        Console con = System.console();
        String input="";

        while(!input.equals("quit")) {
            input = con.readLine("What do you want to perform? (Type 'quit' to exit program.)");

            switch(input) {
                case "help":
                    displayMessage("'list' to shows a list of items in shopping cart.");
                    displayMessage("'login <name>' to access to your shopping cart info.");
                    displayMessage("'add <item>' to add item into your shopping cart.");
                    displayMessage("'delete <item#>' to shows a list of items in shopping cart.");
                    displayMessage("'quit' to exit the program.");
                    break;

                case "list":
                    listCart(cartItems);
                    break;

                case "users":
                    break;

                default:

            }// end of switch

        if (input.startsWith("add")) {
            input.replace(",", " ");

            Scanner scanner = new Scanner(input.substring(4)); // with substring, the scan will start from index 4.

            while(scanner.hasNext()) {
                strValue = scanner.next(); // https://www.javatpoint.com/post/java-scanner-next-method
                cartItems.add(strValue);
            }
            }// end of if for add.
        
        if (input.startsWith("delete")) {
            
            deleteItem( cartItems, input);

        } // end of if for delete

        } // end of while loop


    }// End of main.

    public static List<String> deleteItem(List<String> cartItems, String input) {

        input.replace(","," ");
        Scanner scanner = new Scanner(input.substring(6)); // with substring, the scan will start from index 6.

        String strValue = "";

        while(scanner.hasNext()) {
            strValue = scanner.next(); 
            int listItemIndex = Integer.parseInt(strValue);

            if (listItemIndex < cartItems.size()) {
                cartItems.remove(listItemIndex);
            } else {displayMessage("Incorrect item index.");}
        }
        return cartItems;
    }


    public static void listCart (List<String> cartItems) {
            if ( cartItems.size() >0) {
                for(int i=0; i<cartItems.size(); i++) {
                    System.out.printf("%d. %s\n", i, cartItems.get(i));
                }
                
                // for (String item: cartItems) {
                //     System.out.printf(item);
                //     System.out.println();
                // }
            } else {
                displayMessage("Your cart is empty.");
            }
        }

        public static void displayMessage(String message) {
        System.out.println(message);
    }




}