package Console;

import java.util.Scanner;

/**
         * Created by adam on 30/10/2016.
 */
public class StockMenu {
    public StockMenu() {
        String input, pattern = "[1-2]", outputMessage = "Choose an option(please enter in the format of 1-2)\n1. View Stock\n2. Update Stock";
        boolean checker = true;
        int option;
        while(checker) {
            Print.print(outputMessage, true);
            Scanner in = new Scanner(System.in);
            input = in.nextLine();
            if (!input.matches(pattern))
                Print.print("Input was incorrect. Please try again", true);
            else {
                option = Integer.parseInt(input);
                switch (option) {
                    case 1:
                        Print.print("view stock", true);
                        checker = false;
                        break;
                    case 2:
                        Print.print("update stock", true);
                        checker = false;
                        break;
                }
            }
        }
    }
}