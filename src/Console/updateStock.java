package Console;

import Database_Manager.DataReader;
import objects.Stock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by adam on 11/11/2016.
 */
public class updateStock extends JFrame implements ActionListener, Cinter{
    private JLabel itemLabel, quanLabel, lMessage;
    private JTextField itemId, quanId;
    private JButton include, remove, back;
    private JPanel panel, panel1;
    private DataReader dr;
    private boolean madeObj, NF;

    public  updateStock(){ makeWindow();}

    public void makeWindow() {
        panel    = new JPanel();
        panel1   = new JPanel();
        itemId   = new JTextField(20);
        quanId   = new JTextField(20);
        include  = new JButton("Add Stock");
        remove   = new JButton("Remove stock");
        back     = new JButton("Back");
        lMessage = new JLabel("");
        include.addActionListener(this);
        remove.addActionListener(this);
        back.addActionListener(this);
        itemLabel = new JLabel("Enter ID of item:        ");
        quanLabel = new JLabel("Enter number of item: ");
        panel.add(itemLabel);
        panel.add(itemId);
        panel.add(quanLabel);
        panel.add(quanId);
        panel.add(include);
        panel1.add(lMessage);
        panel.add(remove, BorderLayout.CENTER);
        panel.add(back);
        this.getContentPane().add(BorderLayout.CENTER, panel);
        this.getContentPane().add(BorderLayout.SOUTH, panel1);
        this.setSize(400, 150);
        this.add(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        try { dr = new DataReader(); madeObj = true; }
        catch (IOException exc) { madeObj = false; }
        NF = false;
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == remove){
            /** remove stock from the stock folder. if inputs are
             * incorrect or there is not enough stock to remove the print a
             * error message to lMessage with lMessage.setText("error message");
             */
            for (Stock s: dr.stock)
            {
                try {
                    if (s.getStockNum() == Integer.parseInt(itemId.getText()))
                    {
                        s.setQuantity(s.getQuantity() - Integer.parseInt(quanId.getText()));
                        NF = false;
                        break;
                    }
                } catch (NumberFormatException exc)
                {
                    lMessage.setText("Failed to convert to an Int.");
                    NF = true;
                }
            }
            if (NF)
                lMessage.setText("Failed to find an Item with id: " + itemId.getText());
            else {
                lMessage.setText("Succeeded removing the quantity.");
            }
            itemId.setText("");
            quanId.setText("");
        }
        if (e.getSource() == include){
            /**add stock to the stock folder there will be no checks except
             * that the the quanity is an int. if successful then print an
             * acceptance message to the to lMessage with lMessage.setText("acceptants message");
             */
            for (Stock s: dr.stock)
            {
                try {
                    if (s.getStockNum() == Integer.parseInt(itemId.getText()))
                    {
                        s.setQuantity(Integer.parseInt(quanId.getText()) + s.getQuantity());
                        NF = false;
                        break;
                    } else { NF = true; }
                } catch (NumberFormatException exc) {
                    lMessage.setText("Failed to convert ItemID to int.");
                }
            }
            if (NF)
                lMessage.setText("Failed to find an Item with id: " + itemId.getText());
            else {
                lMessage.setText("Succeeded the quantity update.");
            }
            itemId.setText("");
            quanId.setText("");
        }
        if (e.getSource() == back){
            // cancel back to the main menu
            this.dispose();
            try {
                menu a = new menu();
                dr.update();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
