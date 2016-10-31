package Console;

import Database_Manager.DataReader;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;


public class LoginPage extends JFrame implements ActionListener, Cinter { // This is Adam's work and has been updated to GUI's already

    private JLabel username, password, lMessage;
    private JButton logIn, Cancel;
    private JTextField nameInput;
    private JPasswordField passwordInput;
    private JPanel panel, panel1;

    public LoginPage() {
        this.setVisible(false);
        makeWindow();

    }

    public void makeWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel1 = new JPanel();
        username = new JLabel("Username:");
        password = new JLabel("Password:");
        lMessage = new JLabel("");
        nameInput = new JTextField(20);
        passwordInput = new JPasswordField(20);
        passwordInput.setEchoChar('*');
        logIn = new JButton("LogIn");
        logIn.addActionListener(this);
        Cancel = new JButton("Cancel");
        Cancel.addActionListener(this);

        this.setResizable(false);
        panel.add(username);
        panel.add(nameInput);
        panel.add(password);
        panel.add(passwordInput);
        panel.add(logIn);
        panel.add(Cancel, BorderLayout.CENTER);
        panel1.add(lMessage, BorderLayout.SOUTH);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(BorderLayout.CENTER, panel);
        this.getContentPane().add(BorderLayout.SOUTH, panel1);
        this.setSize(350, 150);
        this.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logIn) {
            try {
                CheckLogIn();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == Cancel)
            System.exit(1);
    }

    public void CheckLogIn() throws IOException {
        DataReader e = new DataReader();
        String input;
        String pattern = "[0-9]+";
        int id = 0;
        boolean checker = true;
        String name, password;
        name = nameInput.getText();
        char[] pass = passwordInput.getPassword();
        password = new String(pass);
        nameInput.setText("");
        passwordInput.setText("");
        if (!name.matches(pattern))
            lMessage.setText("incorrect input or ID not recognised.\nPlease try again");
        else {
            id = Integer.parseInt(name);
            for (int x = 0; x < e.employee.size() || checker; x++) {
                if (id == e.employee.get(x).getEmpno() && password.equals(e.employee.get(x).getPassword())) {
                    lMessage.setText("Login was Successful, please wait to be redirected");
                    checker = false;
                    this.setVisible(false);
                    menu menu = new menu();
                }
                else if(x == e.employee.size() - 1){
                    lMessage.setText("ID was not found. Please try again");
                    checker = false;
                }
            }
            if (!checker) {
                lMessage.setText("Login was not successful. Please start again");
                checker = true;
            }
        }

    }
}
