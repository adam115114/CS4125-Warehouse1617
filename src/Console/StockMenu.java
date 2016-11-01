package Console;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            JOptionPane.showMessageDialog(null, "Veiw Stock was clicked");
        if (e.getSource() == updateS)
            JOptionPane.showMessageDialog(null, "Update stock was clicked");
    }
}