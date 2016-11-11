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

    public CartGUI() {
        makeWindow();
    }

    public void makeWindow()
    {
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(800,400));
        panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(800,200));
        layout = new GridBagLayout();
        gbc = new GridBagConstraints();
        //Creating constraints and setting anchor and weight
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(5,5,5,5);
        layout.rowHeights = new int[] {200,200,200,200,200};
        layout.columnWidths =new int[] {100,100,100,100};
        setLayout(layout);

        stock = new JLabel("Please enter stock Item: ");
        stock.setFont(new Font("", Font.PLAIN, 12));
        sName = new JTextField(15);
        quantity = new JLabel("Enter Quantity: ");
        quantity.setFont(new Font("", Font.PLAIN, 12));
        quan = new JTextField(15);
        addToCart = new JButton("Add To Cart");
        addToCart.setFont(new Font("", Font.PLAIN, 12));
        checkout = new JButton("Check Out");
        checkout.setFont(new Font("", Font.PLAIN, 12));
        remove = new JButton("Remove Item from cart");
        remove.setFont(new Font("", Font.PLAIN, 12));
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("", Font.PLAIN, 12));
        lMessage = new JLabel("");
        euro = new JLabel("euro: ");
        runningTotal = new JLabel("N/A");
        shoppinglist = new JTextArea();
        shoppinglist.setEditable(false);
        //Add the stock label to panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        panel.add(stock , gbc);
        //Add the sName textfield to panel
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        panel.add(sName , gbc);
        //Add the quantity label to panel
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        panel.add(quantity , gbc);
        //Add the quan textfiend to panel
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        panel.add(quan , gbc);
        //Add the addToCart button to panel
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        panel.add(addToCart , gbc);
        //Add the checkout button to panel
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        panel.add(checkout , gbc);
        //Add the remove button to panel
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        panel.add(remove , gbc);
        //Add the cancel button to panel
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        panel.add(cancel , gbc);
        //Add the lMessage textfield to panel
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridheight = 1;
        gbc.gridwidth = 4;
        panel.add(lMessage , gbc);
        //Add the euro textfield to panel
        gbc.gridx = 5;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        panel1.add(euro , gbc);
        //Add the runningTotal textfiend to panel
        gbc.gridx = 5;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        panel1.add(runningTotal , gbc);
        //Add the shoppingList textarea to panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        gbc.gridheight = 3;
        panel1.add(shoppinglist , gbc);

        //Add panel to Frame
        //this.getContentPane().add(BorderLayout.WEST, panel);
        //this.getContentPane().add(BorderLayout.EAST, panel1);
        this.setLayout(new GridLayout(1,2));
        this.add(panel);
        this.add(panel1);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Cart");
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(800,600);

        addToCart.addActionListener(this);
        checkout.addActionListener(this);
        remove.addActionListener(this);
        cancel.addActionListener(this);
    }
    //public static void main(String [] args){
      //  CartGUI a = new CartGUI();
   //}

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

