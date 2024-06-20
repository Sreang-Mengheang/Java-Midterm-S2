import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LockerApp extends JFrame implements ActionListener {

    private JLabel messageLabel;
    private JPasswordField passwordField;
    private JButton enterButton;
    private String password;
    private boolean passwordSet = false;

    public LockerApp() {
        super("Locker App");
        setLayout(new FlowLayout());

        messageLabel = new JLabel("Enter your password:");
        add(messageLabel);

        passwordField = new JPasswordField(15);
        passwordField.setActionCommand("enter");
        passwordField.addActionListener(this);
        add(passwordField);

        enterButton = new JButton("Enter");
        enterButton.setActionCommand("enter");
        enterButton.addActionListener(this);
        add(enterButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("enter")) {
            String enteredPassword = new String(passwordField.getPassword());
            if (!passwordSet) {
                password = enteredPassword;
                passwordSet = true;
                messageLabel.setText("Password Set");
            } else {
                if (enteredPassword.equals(password)) {
                    messageLabel.setText("Correct Password");
                    // Simulate opening the locker (replace with your desired action)
                    JOptionPane.showMessageDialog(this, "Locker Opened!");
                } else {
                    messageLabel.setText("Incorrect Password");
                    passwordField.setText("");
                }
            }
        }
        passwordField.requestFocus(); // Set focus back to password field
    }

    public static void main(String[] args) {
        new LockerApp();
    }
}
