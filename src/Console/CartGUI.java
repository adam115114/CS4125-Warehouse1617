package Console;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Tadhg on 01/11/2016.
 */
public class CartGUI extends JFrame implements Cinter, ActionListener {

    private JTextField sName, quan;
    private JButton addToCart, checkout, remove, cancel;
    private JLabel lMessage, euro, runningTotal, stock, quantity;
    private JPanel panel, cartPanel, messagePanel;
    private JTextArea shoppinglist;

    public CartGUI() {
        makeWindow();
    }

    public void makeWindow() {
        shoppinglist = new JTextArea();
        shoppinglist.setEditable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(200, 400);
        panel = new JPanel();
        sName = new JTextField();
        quan = new JTextField();
        stock = new JLabel("Please enter stock Item");
        quantity = new JLabel("Enter Quantity");
        lMessage = new JLabel();
        euro = new JLabel("euro: ");
        runningTotal = new JLabel("N/A");
        addToCart = new JButton("Add To Cart");
        checkout = new JButton("Check Out");
        remove = new JButton("Remove Item from cart");
        cancel = new JButton("Cancel");
        addToCart.addActionListener(this);
        checkout.addActionListener(this);
        remove.addActionListener(this);
        cancel.addActionListener(this);


        this.setResizable(false);
        this.setVisible(true);
        this.add(panel);


    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addToCart){
            //Add shit to cart
        }
        if (e.getSource() == checkout){
            // Goes to checkout
        }
        if (e.getSource() == remove){
            //remove things from the text area
        }
        if (e.getSource() == cancel){
            // cancel back to the main menu
            this.setVisible(false);
            try {
                menu a = new menu();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
