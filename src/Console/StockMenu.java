package Console;

import Manage_Stock.Stock_Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by adam on 30/10/2016.
 */

public class StockMenu implements Cinter {

    public JButton option1, option2, option3;
    JPanel panel;
    JLabel lMessage;

    public StockMenu() throws IOException { // Adam's work Still in first iteration and will be updated to GUI's
        String input, pattern = "[1-2]", outputMessage = "Choose an option(please enter in the format of 1-2)\n1. View Stock\n2. Update Stock";
        boolean checker = true;
        int option;
        while (checker) {
            Print.print(outputMessage, true);
            Scanner in = new Scanner(System.in);
            input = in.nextLine();
            if (!input.matches(pattern))
                Print.print("Input was incorrect. Please try again", true);
            else {
                option = Integer.parseInt(input);
                switch (option) {
                    case 1:
                        Stock_Manager s = new Stock_Manager();
                        s.checkStock();
                        checker = false;
                        break;
                    case 2:
                        Stock_Manager v = new Stock_Manager();
                        v.addStock();
                        checker = false;
                        break;
                }
            }
        }
    }

    public void makeWindow() {

    }
}