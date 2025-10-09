import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("Student Exchange - Login");
        setSize(360, 240);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1, 8, 8));

        JPanel p1 = new JPanel(new BorderLayout());
        p1.add(new JLabel("Email:"), BorderLayout.NORTH);
        emailField = new JTextField();
        p1.add(emailField, BorderLayout.CENTER);
        add(p1);

        JPanel p2 = new JPanel(new BorderLayout());
        p2.add(new JLabel("Password:"), BorderLayout.NORTH);
        passwordField = new JPasswordField();
        p2.add(passwordField, BorderLayout.CENTER);
        add(p2);

        JPanel buttons = new JPanel();
        JButton loginBtn = new JButton("Login");
        JButton registerBtn = new JButton("Register");
        buttons.add(loginBtn);
        buttons.add(registerBtn);
        add(buttons);

        loginBtn.addActionListener(e -> {
            String email = emailField.getText().trim();
            String password = new String(passwordField.getPassword());

            User user = UserStore.getInstance().getUserByEmail(email);
            if (user == null) {
                JOptionPane.showMessageDialog(this, "Invalid email or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (user.getPassword().equals(password)) {
                JOptionPane.showMessageDialog(this, "Login successful. Welcome " + user.getFullName() + "!");
                dispose();
                new DashboardFrame(user);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid email or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        });

        registerBtn.addActionListener(e -> {
            dispose();
            new RegisterFrame();
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
