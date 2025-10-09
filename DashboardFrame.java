import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {
    public DashboardFrame(User user) {
        setTitle("Student Exchange - Dashboard");
        setSize(480, 340);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));

        JLabel welcome = new JLabel("Welcome, " + user.getFullName(), SwingConstants.CENTER);
        welcome.setFont(welcome.getFont().deriveFont(16f));
        add(welcome, BorderLayout.NORTH);

        JPanel options = new JPanel(new GridLayout(2, 2, 10, 10));
        JButton sellBtn = new JButton("Sell Product");
        JButton buyBtn = new JButton("Buy Product");
        JButton myProductsBtn = new JButton("My Products");
        JButton logoutBtn = new JButton("Logout");
        options.add(sellBtn);
        options.add(buyBtn);
        options.add(myProductsBtn);
        options.add(logoutBtn);

        add(options, BorderLayout.CENTER);

        logoutBtn.addActionListener(e -> {
            dispose();
            new LoginFrame();
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
