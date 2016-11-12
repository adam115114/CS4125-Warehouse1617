package Console;

import Database_Manager.DataReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by adam on 30/10/2016.
 */
public class menu extends JFrame implements ActionListener {
    JLabel lMessage;
    JButton option1, option2, option4, option3;
    JPanel jPanel1;
    public int id;

    public menu() throws IOException {
        makeWindow();
    }

    public void makeWindow() throws IOException {
        DataReader e = new DataReader();
        jPanel1 = new JPanel();
        this.setSize(500, 500);
        lMessage = new JLabel("Welcome to the Main Menu", SwingConstants.CENTER);
        lMessage.setFont(new Font("", Font.PLAIN, 22));
        option1 = new JButton("Update Stock");
        option1.setFont(new Font("", Font.PLAIN, 18));
        option2 = new JButton("Sales");
        option2.setFont(new Font("", Font.PLAIN, 18));
        option3 = new JButton("Log out");
        option3.setFont(new Font("", Font.PLAIN, 18));
        if (e.employee.get(LoginPage.number).isCheck()) {
            option4 = new JButton("Manage employees");
            option4.setFont(new Font("", Font.PLAIN, 18));
            option4.addActionListener(this);
            jPanel1.setLayout(new GridLayout(5,1));
        }else{
            jPanel1.setLayout(new GridLayout(4, 1));
        }
        this.setTitle("Main Menu");
        option1.addActionListener(this);
        option2.addActionListener(this);
        option3.addActionListener(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jPanel1.add(BorderLayout.CENTER, lMessage);
        jPanel1.add(option1);
        jPanel1.add(option2);
        if (e.employee.get(LoginPage.number).isCheck())
            jPanel1.add(option4);
        jPanel1.add(option3);
        this.add(jPanel1);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == option1) {
            this.dispose();
            StockMenu a = new StockMenu();
        }
        if (e.getSource() == option2) {
            this.dispose();
            CartGUI c = new CartGUI();

        }
        if (e.getSource() == option3) {
            this.dispose();
            LoginPage b = new LoginPage();
        }
        if (e.getSource() == option4){
            this.dispose();
            /**
             * add code her for the manager GUI
             */
        }
    }
}