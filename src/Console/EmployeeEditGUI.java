package Console;

import Manage_Employee.Employee_Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * Created by adam on 12/11/2016.
 */
public class EmployeeEditGUI extends JFrame implements ActionListener, Cinter, ItemListener {

    public EmployeeEditGUI() {
        makeWindow();
    }

    private JCheckBox manager;
    private boolean checker;
    private JLabel name, password, lMessage;
    private JTextField nameInput, passInput;
    private JButton submit, remove, cancel;
    private JPanel panel, panel1;

    public void makeWindow() {
        panel1 = new JPanel();
        panel = new JPanel();
        lMessage = new JLabel();
        lMessage.setFont(new Font("", Font.PLAIN, 15));
        manager = new JCheckBox("Manager?");
        manager.setMnemonic(KeyEvent.VK_G);
        manager.setSelected(false);
        manager.addItemListener(this);
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("", Font.BOLD, 12));
        name = new JLabel("       name:   ");
        password = new JLabel("Password:");
        lMessage = new JLabel("");
        nameInput = new JTextField(20);
        passInput = new JTextField(20);
        submit = new JButton("Add Employee");
        submit.setFont(new Font("", Font.BOLD, 12));
        remove = new JButton("Remove employee");
        remove.setFont(new Font("", Font.BOLD, 12));
        submit.addActionListener(this);
        remove.addActionListener(this);
        cancel.addActionListener(this);
        panel.add(name);
        panel.add(nameInput);
        panel.add(password);
        panel.add(passInput);
        panel.add(submit);
        panel.add(remove);
        panel.add(manager);
        panel.add(cancel);
        this.pack();
        panel1.add(lMessage);
        this.getContentPane().add(BorderLayout.CENTER, panel);
        this.getContentPane().add(BorderLayout.SOUTH, panel1);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 220);
        this.setVisible(true);
    }

    public void itemStateChanged(ItemEvent e) {
        Object source = e.getItemSelectable();

        if (source == manager) {
            checker = true;
        }
        if (e.getStateChange() == ItemEvent.DESELECTED) {
            checker = false;
        }

    }

    public void actionPerformed(ActionEvent e) {
        String name = nameInput.getText();
        String password = passInput.getText();
        nameInput.setText("");
        passInput.setText("");

        if (e.getSource() == submit) {
            try {
                Employee_Manager one = new Employee_Manager(true, name, password, checker);
                lMessage.setText("New employee added.");
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
        if (e.getSource() == remove) {
            try {
                Employee_Manager one = new Employee_Manager(false, name, password, checker);
                lMessage.setText( name + " was removed.");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == cancel) {
            this.dispose();
            try {
                menu a = new menu();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        manager.repaint();
    }
}

