package Console;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by adam on 11/11/2016.
 */
public class ViewStock extends JFrame implements ActionListener {
    private JTextArea jDisplay;
    private JButton submit ,back;
    private JTextField input;
    private JLabel lMessage, title;
    private JScrollPane scroll;
    private JPanel panel;
    public ViewStock(Boolean checker) {
        panel = new JPanel();
        back = new JButton("back");
        back.addActionListener(this);
        if (checker) {
            jDisplay = new JTextArea(400, 300);
            jDisplay.setEditable(false);
            /**
             * insert code to fill text area with all Stock items
             */
            scroll = new JScrollPane(jDisplay);
            scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            panel.setLayout(new GridLayout(2, 1));
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
        if (e.getSource() == back){
            this.dispose();
            try {
                menu a = new menu();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == submit){
            String userInput = input.getText();
            input.setText("");
            /**
             * here is where you add the code to look for the item and return it to jDisplay or if it doesn't exists
             * then print a error message to lMessage
             * jDisplay would be filled with the item the customer has searched
             */
        }
    }
}
