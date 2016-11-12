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
        jDisplay = new JTextArea();
        scroll = new JScrollPane(jDisplay);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setMinimumSize(new Dimension (480,410));
        scroll.setPreferredSize(new Dimension (480,410));
        panel = new JPanel();
        back = new JButton("back");
        back.addActionListener(this);
        dr = new DataReader();
        if (checker) {
            jDisplay.setEditable(false);
            String displayText = "";
            for (Stock s : dr.stock) {
                jDisplay.append("ID: " + s.getStockNum() + ", Name: " + s.getName() + ", Quantity: " + s.getQuantity() + ", Price: " + s.getPrice() + "\n");
            }


            panel.add(scroll);
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
            jDisplay.setEditable(false);
            panel.add(title);
            panel.add(input);
            panel.add(submit);
            panel.add(back);
            panel.add(lMessage);
            panel.add(scroll);
        }
        this.add(panel, BorderLayout.CENTER);
        this.setSize(500,500);

        this.setVisible(true);
        this.setResizable(false);
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
            lMessage.setText("");
            if (userInput.matches("[0-9]+")) {
                try {
                    int inputNum = Integer.parseInt(userInput);
                    for (Stock s : dr.stock) {
                        if (s.getStockNum() == inputNum) {
                            jDisplay.append("Name: " + s.getName() + ", Quantity: " + s.getQuantity() + ", Price: " + s.getPrice() + "\n");
                            found = true;
                        }
                    }
                } catch (NumberFormatException exc) {
                    lMessage.setText("Failed to convert input to a number.");
                }
            } else {
                for (Stock s : dr.stock) {
                    if (s.getName() == userInput) {
                        jDisplay.append("Name: " + s.getName() + ", Quantity: " + s.getQuantity() + ", Price: " + s.getPrice());
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
