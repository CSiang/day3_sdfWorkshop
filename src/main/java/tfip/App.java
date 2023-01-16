package tfip;

import java.io.Console;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    private App() {
    }



    public static void main(String[] args) {

        String dirPath = "\\data2";
        String filename = "";

        File newDirectory = new File(dirPath);
        if(newDirectory.exists()) {
            System.out.println("Directory already exists.");
        } else {
            newDirectory.mkdir();
        }

        System.out.println("Welcome to my shopping cart.");

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
                    if ( cartItems.size() >0) {
                        for (String item: cartItems) {
                            System.out.printf(item);
                            System.out.println();
                        }
                    } else {
                        displayMessage("Your cart is empty.");
                    }
                    break;

                case "users":
                    break;

                default:



            }// end of switch

        if (input.startsWith("add")) {
            input.replace(",", " ");

            String strValue = "";
            Scanner scanner = new Scanner(input.substring(4)); // with substring, the scan will start from index 4.

            while(scanner.hasNext()) {
                strValue = scanner.next(); // https://www.javatpoint.com/post/java-scanner-next-method
                cartItems.add(strValue);

            }

        }// end of if for add.

        } // end of while loop




    }

        public static void displayMessage(String message) {
        System.out.println(message);
    }
}
