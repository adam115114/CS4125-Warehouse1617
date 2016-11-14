package UserInterface;

import ManageEmployee.Employee_Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * Created by adam on 12/11/2016.
 */
public class EmployeeEdit extends JFrame implements ActionListener, Cinter, ItemListener {

    public EmployeeEdit() {
        makeWindow();
    }

    private JCheckBox manager;
    private boolean checker;
    private JLabel name, password, lMessage;
    private JTextField nameInput, passInput;
    private JButton submit, remove, cancel;
    private JPanel panel, panel1;

    public void makeWindow() { // This method is used to make the GUI for Editing employees
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
        // Add actionListeners to the buttons
        submit.addActionListener(this);
        remove.addActionListener(this);
        cancel.addActionListener(this);
        // Adding Objects to the Panel
        panel.add(name);
        panel.add(nameInput);
        panel.add(password);
        panel.add(passInput);
        panel.add(submit);
        panel.add(remove);
        panel.add(manager);
        panel.add(cancel);
        panel1.add(lMessage);
        this.pack(); // to get rid of unnecessary space on the JFrame
        this.setTitle("Update Employees");
        this.getContentPane().add(BorderLayout.CENTER, panel);
        this.getContentPane().add(BorderLayout.SOUTH, panel1);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 220);
        this.setVisible(true);
    }

    public void itemStateChanged(ItemEvent e) { // This is for the Check box on the GUI that updates if a new employee is a manager or not.
        Object source = e.getItemSelectable();

        if (source == manager) {
            checker = true;
        }
        if (e.getStateChange() == ItemEvent.DESELECTED) {// if the box is unselected during the process it will still update till it's passed into the next class
            checker = false;
        }

    }

    public void actionPerformed(ActionEvent e) {// basic actionListener for 3 buttons
        String name = nameInput.getText();
        String password = passInput.getText();
        nameInput.setText("");
        passInput.setText("");

        if (e.getSource() == submit) {
            try {// This doesn't make a GUI. This Object just communicates with the DataReader to add a new employee
                Employee_Manager one = new Employee_Manager(true, name, password, checker);
                lMessage.setText("New employee added.");
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }if (e.getSource() == remove) {
            try {// This doesn't make a GUI. This Object just communicates with the DataReader to remove an existing employee
                Employee_Manager one = new Employee_Manager(false, name, password, checker);
                lMessage.setText( name + " was removed.");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }if (e.getSource() == cancel) {// This option exists on all  GUI and it will bring you back to the main Menu.
            this.dispose();
            try {
                menu a = new menu();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        manager.setSelected(false); // This at the end of removing or adding an employee it will look like the GUI reset

    }
}

