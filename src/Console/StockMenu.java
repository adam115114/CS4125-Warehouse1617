package Console;

import Manage_Stock.Stock_Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by adam on 30/10/2016.
 */

public class StockMenu extends JFrame implements ActionListener, Cinter {

    public StockMenu() {
        makeWindow();
    }
    public JLabel lMessage;
    public JButton viewS, updateS;
    public JPanel panel;

    public void makeWindow() {
        panel = new JPanel();
        lMessage = new JLabel("Welcome to the Stock Menu", SwingConstants.CENTER);
        lMessage.setFont(new Font("",Font.PLAIN, 22));
        viewS = new JButton("Veiw Stock");
        viewS.setFont(new Font("",Font.PLAIN, 18));
        updateS = new JButton("Update Stock");
        updateS.setFont(new Font("", Font.PLAIN, 18));
        viewS.addActionListener(this);
        updateS.addActionListener(this);
        this.setSize(300,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(3, 1));
        panel.add(lMessage);
        panel.add(viewS);
        panel.add(updateS);
        this.add(panel);
        this.setVisible(true);

    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewS)
            try {
                Stock_Manager v = new Stock_Manager();
                v.checkStock();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        if (e.getSource() == updateS)
            try {
                Stock_Manager v = new Stock_Manager();
                v.addStock();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
    }
}