package Console;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by adam on 11/11/2016.
 */
public class updateStock extends JFrame implements ActionListener, Cinter{
    private JLabel itemLabel, quanLabel, lMessage;
    private JTextField itemId, quanId;
    private JButton include, remove;
    private JPanel panel, panel1;
    public  updateStock(){ makeWindow();}

    public void makeWindow() {
        panel = new JPanel();
        panel1 = new JPanel();
        itemId = new JTextField(20);
        quanId = new JTextField(20);
        include = new JButton("Add Stock");
        remove = new JButton("Remove stock");
        lMessage = new JLabel("");
        include.addActionListener(this);
        remove.addActionListener(this);
        itemLabel = new JLabel("Enter ID of item:        ");
        quanLabel = new JLabel("Enter number of item: ");
        panel.add(itemLabel);
        panel.add(itemId);
        panel.add(quanLabel);
        panel.add(quanId);
        panel.add(include);
        panel1.add(lMessage);
        panel.add(remove, BorderLayout.CENTER);
        this.getContentPane().add(BorderLayout.CENTER, panel);
        this.getContentPane().add(BorderLayout.SOUTH, panel1);
        this.setSize(400, 150);
        this.add(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == remove){
            /** remove stock from the stock folder. if inputs are
             * incorrect or there is not enough stock to remove the print a
             * error message to lMessage with lMessage.setText("error message");
             */
        }
        if (e.getSource() == include){
            /**add stock to the stock folder there will be no checks except
             * that the the quanity is an int. if successful then print an
             * acceptance message to the to lMessage with lMessage.setText("acceptants message");
             */
        }
    }
}
