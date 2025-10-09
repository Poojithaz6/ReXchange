import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterFrame extends JFrame {
    private JTextField nameField, emailField, phoneField, studentIdField, collegeField;
    private JPasswordField passwordField;

    public RegisterFrame() {
        setTitle("Student Exchange - Register");
        setSize(400, 400);
        setLayout(new GridLayout(8, 2, 5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Full Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        add(new JLabel("Phone:"));
        phoneField = new JTextField();
        add(phoneField);

        add(new JLabel("Student ID:"));
        studentIdField = new JTextField();
        add(studentIdField);

        add(new JLabel("College:"));
        collegeField = new JTextField();
        add(collegeField);

        JButton registerBtn = new JButton("Register");
        JButton backBtn = new JButton("Back to Login");
        add(registerBtn);
        add(backBtn);

        registerBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Registration successful!");
            dispose();
            new LoginFrame();
        });

        backBtn.addActionListener(e -> {
            dispose();
            new LoginFrame();
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
