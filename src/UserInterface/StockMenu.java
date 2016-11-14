package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
/**
 * Created by adam on 30/10/2016.
 */

public class StockMenu extends JFrame implements ActionListener, Cinter {

    public StockMenu() {
        makeWindow();
    }
    private JLabel lMessage;
    private JButton viewS, updateS, back;
    private JPanel panel;

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
        panel.setLayout(new GridLayout(4, 1));
        panel.add(lMessage);
        panel.add(viewS);
        panel.add(updateS);
        panel.add(back);
        this.setTitle("Stock Menu");
        this.setSize(300,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(panel);
        this.setVisible(true);

    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewS) {
            this.dispose();
            boolean answer = true;
            while (answer) {
                String check = JOptionPane.showInputDialog("would you like to show all stock or only certain stock?\n" +
                                                            "(answer in a \"all stock\" or \"certain stock\")");
                if (check != null) {
                    check = check.toLowerCase();
                    if (check.equals("all stock")) {
                        try {
                            ViewStock a = new ViewStock(true);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        answer = false;
                    } else if (check.equals("certain stock")) {
                        try {
                            ViewStock a = new ViewStock(false);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        answer = false;
                    } else {
                        JOptionPane.showMessageDialog(null, "incorrect input format. Please try again.");
                    }
                } else {
                    StockMenu a = new StockMenu();
                    answer = false;
                }
            }
        }
        if (e.getSource() == updateS) {
            this.dispose();
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