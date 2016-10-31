package Console;

import Database_Manager.DataReader;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;


public class LoginPage extends JFrame implements ActionListener {

    private JLabel username, password;
    private JButton logIn, Cancel;
    private JTextField nameInput;
    private JPasswordField passwordInput;
    private JPanel panel;

    public LoginPage() {
        makeWindow();

    }

    public void makeWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        username = new JLabel("Username:");
        password = new JLabel("Password:");
        nameInput = new JTextField(20);
        passwordInput = new JPasswordField(20);
        passwordInput.setEchoChar('*');
        logIn = new JButton("LogIn");
        logIn.addActionListener(this);
        Cancel = new JButton("Cancel");
        Cancel.addActionListener(this);


        panel.add(username);
        panel.add(nameInput);
        panel.add(password);
        panel.add(passwordInput);
        panel.add(logIn);
        panel.add(Cancel);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(BorderLayout.CENTER, panel);
        this.setSize(300, 200);
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
            JOptionPane.showMessageDialog(null,"incorrect input or ID not recognised. Please try again");
        else {
            id = Integer.parseInt(name);
            for (int x = 0; x < e.employee.size(); x++) {
                if (id == e.employee.get(x).getEmpno() && password.equals(e.employee.get(x).getPassword())) {
                    this.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Login was Successful");
                    checker = false;
                    menu a = new menu();
                }
                if (x == e.employee.size() - 1) checker = false;
            }
            if (!checker){
                JOptionPane.showMessageDialog(null, "Login was not successful. Please start again");
                this.setVisible(false);
                LoginPage b = new LoginPage();
            }
        }
    }
}
