import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {
    public DashboardFrame(String userEmail) {
        setTitle("Student Exchange - Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel welcome = new JLabel("Welcome, " + userEmail, SwingConstants.CENTER);
        add(welcome, BorderLayout.NORTH);

        JPanel options = new JPanel(new GridLayout(2, 2, 10, 10));
        options.add(new JButton("Sell Product"));
        options.add(new JButton("Buy Product"));
        options.add(new JButton("My Products"));
        options.add(new JButton("Logout"));

        add(options, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
