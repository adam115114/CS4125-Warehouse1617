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
    public JButton viewS, updateS, back;
    public JPanel panel;

    public void makeWindow() {
        panel = new JPanel();
        lMessage = new JLabel("Welcome to the Stock Menu", SwingConstants.CENTER);
        lMessage.setFont(new Font("",Font.PLAIN, 22));
        viewS = new JButton("Veiw Stock");
        viewS.setFont(new Font("",Font.PLAIN, 18));
        updateS = new JButton("Update Stock");
        updateS.setFont(new Font("", Font.PLAIN, 18));
        back = new JButton("Back");
        back.setFont(new Font("", Font.PLAIN, 18));
        back.addActionListener(this);
        viewS.addActionListener(this);
        updateS.addActionListener(this);
        this.setSize(300,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(4, 1));
        panel.add(lMessage);
        panel.add(viewS);
        panel.add(updateS);
        panel.add(back);
        this.add(panel);
        this.setVisible(true);

    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewS)
            try {
                this.setVisible(false);
                Stock_Manager v = new Stock_Manager();
                v.checkStock();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        if (e.getSource() == updateS) {
            this.setVisible(false);
            updateStock a = new updateStock();
        }
        if (e.getSource() == back){
            try {
                this.dispose();
                menu a = new menu();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}