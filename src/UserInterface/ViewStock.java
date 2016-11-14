package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import ManageStock.Stock_Manager;

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

    public ViewStock(Boolean checker) throws IOException {
        jDisplay = new JTextArea();
        scroll = new JScrollPane(jDisplay);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setMinimumSize(new Dimension (480,410));
        scroll.setPreferredSize(new Dimension (480,410));
        panel = new JPanel();
        back = new JButton("back");
        back.addActionListener(this);
        if (checker) {
            this.setTitle("View All Stock");
            jDisplay.setEditable(false);
            Stock_Manager sm = new Stock_Manager();
            jDisplay.setText(sm.getAllStock());
            panel.add(scroll);
            panel.add(back);
        } else {
            this.setTitle("View Certain Stock");
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
            lMessage.setText("");
            Stock_Manager sm = null;
            try {
                sm = new Stock_Manager();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            String str = sm.getStockItem(userInput);
            if (str.equals("ERROR"))
            {
                lMessage.setText("An error has occurred, The requested item may not exist.");
            } else
                jDisplay.append(str);
            /**
             * here is where you add the code to look for the item and return it to jDisplay or if it doesn't exists
             * then print a error message to lMessage
             * jDisplay would be filled with the item the customer has searched
             */
        }
    }
}
