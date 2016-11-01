package Console;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Tadhg on 01/11/2016.
 */
public class CartGUI extends JFrame implements Cinter , ActionListener
{

    private JTextField sName, quan;
    private JButton addToCart ,checkout ,remove ,cancel;
    private JLabel lMessage , euro , runningTotal , stock , quantity;
    private JPanel panel , cartPanel , messagePanel;

    public CartGUI() {
        makeWindow();
    }

    public void makeWindow() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(200 , 400);
        panel = new JPanel();
        sName = new JTextField();
        quan = new JTextField();
        stock = new JLabel();
        quantity = new JLabel();





    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
