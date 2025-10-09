import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends JFrame {
    private JTextField nameField, emailField, phoneField, studentIdField, collegeField;
    private JPasswordField passwordField;

    public RegisterFrame() {
        setTitle("Student Exchange - Register");
        setSize(420, 420);
        setLayout(new GridLayout(8, 2, 6, 6));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Full Name:"));
        nameField = new JTextField(); add(nameField);

        add(new JLabel("Email:"));
        emailField = new JTextField(); add(emailField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField(); add(passwordField);

        add(new JLabel("Phone:"));
        phoneField = new JTextField(); add(phoneField);

        add(new JLabel("Student ID:"));
        studentIdField = new JTextField(); add(studentIdField);

        add(new JLabel("College:"));
        collegeField = new JTextField(); add(collegeField);

        JButton registerBtn = new JButton("Register");
        JButton backBtn = new JButton("Back to Login");
        add(registerBtn);
        add(backBtn);

        registerBtn.addActionListener(e -> {
            String fullName = nameField.getText().trim();
            String email = emailField.getText().trim();
            String password = new String(passwordField.getPassword());
            String phone = phoneField.getText().trim();
            String studentId = studentIdField.getText().trim();
            String college = collegeField.getText().trim();

            if (fullName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Full name, email and password are required.", "Validation", JOptionPane.WARNING_MESSAGE);
                return;
            }

            User user = new User(email, password, fullName, phone, studentId, college);
            boolean added = UserStore.getInstance().addUser(user);
            if (!added) {
                JOptionPane.showMessageDialog(this, "An account with this email already exists.", "Register Failed", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Registration successful! Please login.");
                dispose();
                new LoginFrame();
            }
        });

        backBtn.addActionListener(e -> {
            dispose();
            new LoginFrame();
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends JFrame {
    private JTextField nameField, emailField, phoneField, studentIdField, collegeField;
    private JPasswordField passwordField;

    public RegisterFrame() {
        setTitle("Student Exchange - Register");
        setSize(420, 420);
        setLayout(new GridLayout(8, 2, 6, 6));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Full Name:"));
        nameField = new JTextField(); add(nameField);

        add(new JLabel("Email:"));
        emailField = new JTextField(); add(emailField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField(); add(passwordField);

        add(new JLabel("Phone:"));
        phoneField = new JTextField(); add(phoneField);

        add(new JLabel("Student ID:"));
        studentIdField = new JTextField(); add(studentIdField);

        add(new JLabel("College:"));
        collegeField = new JTextField(); add(collegeField);

        JButton registerBtn = new JButton("Register");
        JButton backBtn = new JButton("Back to Login");
        add(registerBtn);
        add(backBtn);

        registerBtn.addActionListener(e -> {
            String fullName = nameField.getText().trim();
            String email = emailField.getText().trim();
            String password = new String(passwordField.getPassword());
            String phone = phoneField.getText().trim();
            String studentId = studentIdField.getText().trim();
            String college = collegeField.getText().trim();

            if (fullName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Full name, email and password are required.", "Validation", JOptionPane.WARNING_MESSAGE);
                return;
            }

            User user = new User(email, password, fullName, phone, studentId, college);
            boolean added = UserStore.getInstance().addUser(user);
            if (!added) {
                JOptionPane.showMessageDialog(this, "An account with this email already exists.", "Register Failed", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Registration successful! Please login.");
                dispose();
                new LoginFrame();
            }
        });

        backBtn.addActionListener(e -> {
            dispose();
            new LoginFrame();
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
