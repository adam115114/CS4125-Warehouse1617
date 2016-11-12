package Console;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Database_Manager.DataReader;
import objects.Stock;

/**
 * Created by adam on 11/11/2016.
 */

public class ViewStock extends JFrame implements ActionListener {
    private JTextArea jDisplay;
    private JButton submit, back;
    private JTextField input;
    private JLabel lMessage, title;
    private JScrollPane scroll;
    private JPanel panel;
    private DataReader dr;

    public ViewStock(Boolean checker) throws IOException {
        panel = new JPanel();
        back = new JButton("back");
        back.addActionListener(this);
        dr = new DataReader();
        if (checker) {
            jDisplay = new JTextArea(20, 40);
            jDisplay.setEditable(false);
            String displayText = "";
            for (Stock s : dr.stock) {
                String str = "ID: " + s.getStockNum() + ", Name: " + s.getName() + ", Quantity: " + s.getQuantity() + ", Price: " + s.getPrice();
                displayText += str + "\n";
            }
            jDisplay.setText(displayText);
            scroll = new JScrollPane(jDisplay);
            scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            panel.add(jDisplay);
            panel.add(back);
        } else {
            title = new JLabel("Enter Item ID");
            submit = new JButton("submit");
            submit.addActionListener(this);
            input = new JTextField(20);
            lMessage = new JLabel("");
            /**
             *lMessage is what you use to print errors the person has made e.g if item ID doesn't exist
             */
            jDisplay = new JTextArea(400, 100);
            jDisplay.setEditable(false);
            panel.add(title);
            panel.add(input);
            panel.add(submit);
            panel.add(lMessage);                                
            panel.add(back);
            panel.add(jDisplay);
        }
        this.add(panel);
        this.setSize(400, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            this.dispose();
            try {
                menu a = new menu();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == submit) {
            String userInput = input.getText();
            input.setText("");
            boolean found = false;
            if (userInput.matches("[0-9]+")) {
                try {
                    int inputNum = Integer.parseInt(userInput);
                    for (Stock s : dr.stock) {
                        if (s.getStockNum() == inputNum) {
                            jDisplay.setText("Name: " + s.getName() + ", Quantity: " + s.getQuantity() + ", Price: " + s.getPrice());
                            found = true;
                        }
                    }
                } catch (NumberFormatException exc) {
                    lMessage.setText("Failed to convert input to a number.");
                }
            } else {
                for (Stock s : dr.stock) {
                    if (s.getName() == userInput) {
                        jDisplay.setText("Name: " + s.getName() + ", Quantity: " + s.getQuantity() + ", Price: " + s.getPrice());
                        found = true;
                    }
                }
            }
            if (!found)
                lMessage.setText("Could not find an item with: " + userInput);
            /**
             * here is where you add the code to look for the item and return it to jDisplay or if it doesn't exists
             * then print a error message to lMessage
             * jDisplay would be filled with the item the customer has searched
             */
        }
    }
}
