package UserInterface;

import ManageSales.Sales;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Tadhg on 01/11/2016.
 */
public class Cart extends JFrame implements Cinter, ActionListener
{

    private JTextField sName, quan;
    private GridBagLayout layout;
    private GridBagConstraints gbc;
    private JButton addToCart, checkout, remove, cancel;
    private JLabel lMessage, euro, runningTotal, stock, quantity;
    private JPanel panel;
    private JTextArea shoppinglist;
    private Sales s;

    public Cart() {
        makeWindow();
    }

    public void makeWindow()
    {
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(800,250));
        layout = new GridBagLayout();
        gbc = new GridBagConstraints();
        //Creating constraints and setting anchor and weight
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(2,2,2,2);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        layout.rowHeights = new int[] {50,50,50,50,50};
        layout.columnWidths =new int[] {200,200,200,200};
        panel.setLayout(layout);

        stock = new JLabel("Please enter stock Item: ");
        stock.setFont(new Font("", Font.PLAIN, 15));
        sName = new JTextField(15);
        quantity = new JLabel("Enter Quantity: ");
        quantity.setFont(new Font("", Font.PLAIN, 15));
        quan = new JTextField(15);
        addToCart = new JButton("Add To Cart");
        addToCart.setFont(new Font("", Font.PLAIN, 15));
        checkout = new JButton("Check Out");
        checkout.setFont(new Font("", Font.PLAIN, 15));
        remove = new JButton("Remove Item from cart");
        remove.setFont(new Font("", Font.PLAIN, 15));
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("", Font.PLAIN, 15));
        lMessage = new JLabel("");
        euro = new JLabel("Euro: ");
        euro.setFont(new Font("", Font.PLAIN, 15));
        runningTotal = new JLabel("N/A");
        shoppinglist = new JTextArea();
        shoppinglist.setEditable(false);
        //Add the stock label to panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        panel.add(stock , gbc);
        //Add the sName textfield to panel
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
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
        gbc.gridwidth = 1;
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
        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        panel.add(lMessage , gbc);
        //Add the euro textfield to panel
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        panel.add(euro , gbc);
        //Add the runningTotal textfiend to panel
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        panel.add(runningTotal , gbc);
        //Add the shoppingList textarea to panel
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 4;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(shoppinglist , gbc);

        //Add panel to Frame
        //this.getContentPane().add(BorderLayout.WEST, panel);
        //this.getContentPane().add(BorderLayout.EAST, panel1);
        //this.setLayout(new GridLayout(1,2));
        this.add(panel);
        //this.add(panel1);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Cart");
        this.setResizable(false);
        this.setVisible(true);
        this.pack();

        addToCart.addActionListener(this);
        checkout.addActionListener(this);
        remove.addActionListener(this);
        cancel.addActionListener(this);
        try {
            s = new Sales();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        String pattern = "[0-9]+";
        if (e.getSource() == addToCart){
            lMessage.setText("");
            try {
                String n = sName.getText();
                String q = quan.getText();
                if(!n.matches(pattern) || !q.matches(pattern))
                    lMessage.setText("Error: incorrect input");
                else
                {
                    if (s.inCart(Integer.parseInt(n))) {
                        s.addCart(Integer.parseInt(n), Integer.parseInt(q));
                        s.list();
                        shoppinglist.setText(s.shop + "\n");
                        s.totals();
                        runningTotal.setText("" + s.total);
                    } else {
                        if (s.addToCart(Integer.parseInt(n), Integer.parseInt(q))) {
                            s.list();
                            shoppinglist.setText(s.shop + "\n");
                            s.totals();
                            runningTotal.setText("" + s.total);
                        } else
                            lMessage.setText(s.error);
                    }
                }
            }catch(Exception e1){
                e1.printStackTrace();
            }
            sName.setText("");
            quan.setText("");
        }
        if (e.getSource() == checkout){
            try {
                s.updates();
                s.invoice();
                this.dispose();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == remove){
            lMessage.setText("");
            String n = sName.getText();
            String q = quan.getText();
            if(!n.matches(pattern) || !q.matches(pattern))
                lMessage.setText("Error: incorrect input");
            else {
                s.remove(Integer.parseInt(sName.getText()), Integer.parseInt(quan.getText()));
                s.list();
                shoppinglist.setText(s.shop + "\n");
                s.totals();
                runningTotal.setText("" + s.total);
                sName.setText("");
                quan.setText("");
            }
        }
        if (e.getSource() == cancel){
            // cancel back to the main menu
            this.dispose();
            try {
                menu a = new menu();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}