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
    private JPanel panel , panel1;
    private JTextArea shoppinglist;
    private GridBagLayout gridBagCons;

    public CartGUI() {
        makeWindow();
    }

    public void makeWindow() {
        panel1 = new JPanel(gridBagCons);
        gridBagCons = new GridBagLayout();
        panel = new JPanel();
        panel.setLayout(gridBagCons);
        //Creating constraints and setting anchor and weight
        GridBagConstraints gridBagCons = new GridBagConstraints();
        gridBagCons.anchor = GridBagConstraints.FIRST_LINE_START;
        gridBagCons.weightx = 0.5;
        gridBagCons.weighty = 0.5;
        gridBagCons.gridheight =100;
        gridBagCons.gridwidth =200;

        stock = new JLabel("Please enter stock Item: ");
        stock.setFont(new Font("", Font.PLAIN, 8));
        sName = new JTextField(8);
        quantity = new JLabel("Enter Quantity: ");
        quantity.setFont(new Font("", Font.PLAIN, 8));
        quan = new JTextField(8);
        addToCart = new JButton("Add To Cart");
        addToCart.setFont(new Font("", Font.PLAIN, 8));
        checkout = new JButton("Check Out");
        checkout.setFont(new Font("", Font.PLAIN, 8));
        remove = new JButton("Remove Item from cart");
        remove.setFont(new Font("", Font.PLAIN, 8));
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("", Font.PLAIN, 8));
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
            gridBagCons.gridx = 1;
            gridBagCons.gridy = 2;
            panel.add(remove , gridBagCons);
        //Add the cancel button to panel
            gridBagCons.gridx = 1;
            gridBagCons.gridy = 3;
            panel.add(cancel , gridBagCons);
        //Add the euro textfield to panel
            gridBagCons.gridx = 0;
            gridBagCons.gridy = 2;
            panel1.add(euro , gridBagCons);
        //Add the runningTotal textfiend to panel
            gridBagCons.gridx = 0;
            gridBagCons.gridy = 1;
            panel1.add(runningTotal , gridBagCons);
        //Add the lMessage textfield to panel
            gridBagCons.gridx = 0;
            gridBagCons.gridy = 5;
            gridBagCons.gridwidth = 200;
            panel.add(lMessage , gridBagCons);
        //Add the shoppingList textarea to panel
            gridBagCons.gridx = 0;
            gridBagCons.gridy = 0;
            gridBagCons.fill = GridBagConstraints.BOTH;
            panel1.add(shoppinglist , gridBagCons);

        //Add panel to Frame
        this.getContentPane().add(BorderLayout.WEST, panel);
        this.getContentPane().add(BorderLayout.EAST, panel1);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Cart");
        this.setSize(1000,600);
        this.setResizable(false);
        this.setVisible(true);

        addToCart.addActionListener(this);
        checkout.addActionListener(this);
        remove.addActionListener(this);
        cancel.addActionListener(this);
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

