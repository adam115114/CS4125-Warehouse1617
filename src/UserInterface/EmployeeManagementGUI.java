package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by adam on 12/11/2016.
 */
public class EmployeeManagementGUI extends JFrame implements ActionListener, Cinter {

    public EmployeeManagementGUI(){ makeWindow(); }

    private  JLabel lMessage;
    private JButton option1, option3, option4;
    private JPanel panel;
    public void makeWindow() {
        panel = new JPanel();
        lMessage = new JLabel("Manage Employees Menu", SwingConstants.CENTER);
        lMessage.setFont(new Font("", Font.PLAIN, 22));
        option1 = new JButton("Add / Remove employee");
        option1.setFont(new Font("", Font.PLAIN, 18));
        option3 = new JButton("Veiw employee records");
        option3.setFont(new Font("", Font.PLAIN, 18));
        option4 = new JButton("Back");
        option4.setFont(new Font("", Font.PLAIN, 18));
        panel.setLayout(new GridLayout(4,1));
        option1.addActionListener(this);
        option3.addActionListener(this);
        option4.addActionListener(this);
        panel.add(lMessage);
        panel.add(option1);
        panel.add(option3);
        panel.add(option4);
        this.add(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == option1){
            this.dispose();
            EmployeeEditGUI one = new EmployeeEditGUI();

        }if(e.getSource() == option3) {
            EmployeeRecord one = new EmployeeRecord();
        }if (e.getSource() == option4){
            this.dispose();
            try {
                menu a = new menu();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }
}
