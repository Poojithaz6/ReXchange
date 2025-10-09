import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("Student Exchange - Login");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1, 10, 5));

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton loginBtn = new JButton("Login");
        JButton registerBtn = new JButton("Register");

        JPanel panel = new JPanel();
        panel.add(loginBtn);
        panel.add(registerBtn);
        add(panel);

        // Handle Login
        loginBtn.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            // Dummy check (replace with DB later)
            if (email.equals("student@mail.com") && password.equals("123456")) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                dispose();
                new DashboardFrame(email);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials!");
            }
        });

        // Go to Register
        registerBtn.addActionListener(e -> {
            dispose();
            new RegisterFrame();
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
