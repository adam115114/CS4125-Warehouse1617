package Console;

import javax.swing.*;
import java.awt.*;
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
    private JPanel panel;
    private JTextArea shoppinglist;

    public CartGUI() {
        makeWindow();
    }

    public void makeWindow() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Cart");
        this.setSize(800, 600);
        panel = new JPanel(new GridBagLayout());
        //Creating constaints and setting anchor and weight
        GridBagConstraints gridBagCons = new GridBagConstraints();
        gridBagCons.anchor = GridBagConstraints.FIRST_LINE_START;
        gridBagCons.weightx = 0.5;
        gridBagCons.weighty = 0.5;
        stock = new JLabel("Please enter stock Item");
        stock.setFont(new Font("", Font.PLAIN, 22));
        sName = new JTextField(20);
        quantity = new JLabel("Enter Quantity");
        quantity.setFont(new Font("", Font.PLAIN, 22));
        quan = new JTextField(20);
        addToCart = new JButton("Add To Cart");
        addToCart.setFont(new Font("", Font.PLAIN, 22));
        checkout = new JButton("Check Out");
        checkout.setFont(new Font("", Font.PLAIN, 22));
        remove = new JButton("Remove Item from cart");
        remove.setFont(new Font("", Font.PLAIN, 22));
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("", Font.PLAIN, 22));
        lMessage = new JLabel("");
        euro = new JLabel("euro: ");
        runningTotal = new JLabel("N/A");
        shoppinglist = new JTextArea();
        shoppinglist.setEditable(false);
        //Add the stock label to panel
            gridBagCons.gridx = 0;
            gridBagCons.gridy = 0;
            panel.add(stock , gridBagCons);
        //Add the sName textfield to panel
            gridBagCons.gridx = 1;
            gridBagCons.gridy = 0;
            panel.add(sName , gridBagCons);
        //Add the quantity label to panel
            gridBagCons.gridx = 0;
            gridBagCons.gridy = 1;
            panel.add(quantity , gridBagCons);
        //Add the quan textfiend to panel
            gridBagCons.gridx = 1;
            gridBagCons.gridy = 1;
            panel.add(quan , gridBagCons);
        //Add the addToCart button to panel
            gridBagCons.gridx = 0;
            gridBagCons.gridy = 2;
            panel.add(addToCart , gridBagCons);
        //Add the checkout button to panel
            gridBagCons.gridx = 0;
            gridBagCons.gridy = 3;
            panel.add(checkout , gridBagCons);
        //Add the remove button to panel
            gridBagCons.gridx = 2;
            gridBagCons.gridy = 2;
            panel.add(remove , gridBagCons);
        //Add the cancel button to panel
            gridBagCons.gridx = 3;
            gridBagCons.gridy = 3;
            panel.add(cancel , gridBagCons);
        //Add the lMessage textfield to panel
            gridBagCons.gridx = 0;
            gridBagCons.gridy = 5;
            panel.add(lMessage , gridBagCons);
        //Add the euro textfield to panel
            gridBagCons.gridx = 4;
            gridBagCons.gridy = 5;
            panel.add(euro , gridBagCons);
        //Add the runningTotal textfiend to panel
            gridBagCons.gridx = 4;
            gridBagCons.gridy = 6;
            panel.add(runningTotal , gridBagCons);
        //Add the shoppingList textarea to panel
            gridBagCons.gridx = 4;
            gridBagCons.gridy = 0;
            panel.add(shoppinglist , gridBagCons);

        addToCart.addActionListener(this);
        checkout.addActionListener(this);
        remove.addActionListener(this);
        cancel.addActionListener(this);

        //Add panel to Frame
        this.add(panel);
        this.setResizable(false);
        this.setVisible(true);
    }
    public static void main(String [] args){
        CartGUI a = new CartGUI();
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

