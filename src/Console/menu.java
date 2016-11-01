package Console;

import Manage_Sales.Sales;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by adam on 30/10/2016.
 */
public class menu extends JFrame implements ActionListener, Cinter {// Adam's work Still in first iteration and will be updated to GUI's
    JLabel lMessage;
    JButton option1, option2, option3;
    JPanel jPanel1;

    public menu() throws IOException {

        jPanel1 = new JPanel();
        this.setSize(500,500);
        lMessage = new JLabel("Welcome to the Main Menu", SwingConstants.CENTER);
        lMessage.setFont(new Font("",Font.PLAIN, 22));
        option1 = new JButton("Update Stock");
        option1.setFont(new Font("",Font.PLAIN, 18));
        option2 = new JButton("Sales");
        option2.setFont(new Font("",Font.PLAIN, 18));
        option3 = new JButton("Log out");
        option3.setFont(new Font("",Font.PLAIN, 18));
        this.setTitle("Main Menu");
        option1.addActionListener(this);
        option2.addActionListener(this);
        option3.addActionListener(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jPanel1.setLayout(new GridLayout(4,1));
        jPanel1.add(BorderLayout.CENTER, lMessage);
        jPanel1.add(option1);
        jPanel1.add(option2);
        jPanel1.add(option3);
        this.add(jPanel1);
        this.setVisible(true);
    }

    public void makeWindow() {

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == option1){
            this.setVisible(false);
            try {
                StockMenu a = new StockMenu();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == option2){
            this.setVisible(false);
            Sales b = null;
            try {
                b = new Sales();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                b.sale();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == option3){
            this.setVisible(false);
            LoginPage b = new LoginPage();
        }
    }
}