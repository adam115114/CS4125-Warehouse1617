package Console;

import Manage_Sales.Sales;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by adam on 30/10/2016.
 */
public class menu {
    public menu() throws IOException {
        String input, pattern = "[1-3]";
        int x;
        boolean checker = true;
        Scanner in = new Scanner(System.in);
        while (checker) {
            String menuMessage = "Choose an option(please enter in the format of 1-3):\n1: Update Stock\n2: Sales\n3: Logout";
            Print.print(menuMessage, true);
            input = in.nextLine();
            if (input.matches(pattern)) {
                x = Integer.parseInt(input);
                switch (x) {
                    case 1:
                        StockMenu c = new StockMenu();
                        checker = false;
                        break;
                    case 2:
                        Print.print("doSale();", true);
                        Sales s = new Sales();
                        s.sale();
                        checker = false;
                        break;
                    case 3:
                        logIn b = new logIn();
                        checker = false;
                        break;
                }
            } else
                Print.print("incorrect input", true);
        }


    }
}
