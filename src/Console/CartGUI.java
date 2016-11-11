package Console;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Tadhg on 01/11/2016.
 */
public class CartGUI extends JFrame implements Cinter, ActionListener
{

    private JTextField sName, quan;
    private GridBagLayout layout;
    private GridBagConstraints gbc;
    private JButton addToCart, checkout, remove, cancel;
    private JLabel lMessage, euro, runningTotal, stock, quantity;
    private JPanel panel , panel1;
    private JTextArea shoppinglist;

    public void makeWindow()
    {

        stock = new JLabel("Please enter stock Item: ");
        stock.setFont(new Font("", Font.PLAIN, 12));

    }

    public CartGUI() {
        makeWindow();
    }
    public static void main(String [] args){  CartGUI a = new CartGUI();}

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

