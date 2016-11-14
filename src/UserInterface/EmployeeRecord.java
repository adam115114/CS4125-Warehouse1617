package UserInterface;

import DatabaseManager.DataReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by adam on 13/11/2016.
 */
public class EmployeeRecord extends JFrame implements ActionListener, Cinter {
    public EmployeeRecord() {
        makeWindow();
    }

    private JButton submit, cancel;
    private JTextField inputId;
    private JLabel lMessage;
    private JPanel panel;
    private JTextArea output;

    public void makeWindow() {
        panel = new JPanel();
        submit = new JButton("Check");
        submit.setFont(new Font("", Font.PLAIN, 12));
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("", Font.PLAIN, 12));
        lMessage = new JLabel("Please enter the Employees ID");
        lMessage.setFont(new Font("", Font.PLAIN, 18));
        inputId = new JTextField(20);
        output = new JTextArea(20, 23);
        output.setEditable(false);
        output.setText("Name\tSales\tTotal(€)\n");
        submit.addActionListener(this);
        cancel.addActionListener(this);
        panel.add(lMessage);
        panel.add(inputId);
        panel.add(submit);
        panel.add(cancel);
        panel.add(output);
        this.add(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 200);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String input = inputId.getText();
            String pattern = "[0-9]+";
            inputId.setText("");
            if (input.matches(pattern)) {
                lMessage.setText("Your input was formatted correctly");
                try {
                    printInvoices(Integer.parseInt(input));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } else {
                lMessage.setText("Input was incorrectly formatted try again");
            }
        }
        if (e.getSource() == cancel) {
            this.dispose();
            try {
                menu one = new menu();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    private void printInvoices(int i) throws IOException {
        DataReader x = new DataReader();
        String name = "";
        boolean checker = true;
        int count = 0;
        double total = 0.00;
        for (int q = 0; q < x.employee.size(); q++) {
            if (i == x.employee.get(q).getEmpno()) {
                name = x.employee.get(q).getName();
            } else if (q == (x.employee.size())) {
                checker = false;
            }
        }
        for (int y = 0; y < x.invoice.size(); y++) {
            if (i == Integer.parseInt(x.invoice.get(y))) {
                count++;
                total += Double.parseDouble(x.invoice.get(y + 1));
            }
            y++;
        }
        if (!checker) {
            lMessage.setText("There is no record of sales done with this ID");
        } else {
            output.append(name + "\t" + count + "\t" + total + "\n");
        }
    }
}
