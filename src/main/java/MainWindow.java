import javax.swing.*;

public class MainWindow extends JFrame {

    private JButton LoginBtn;
    private JTextField UsernameText;
    private JLabel UsernameLabel;
    private JLabel HRMSLabel;
    private JLabel PasswordLabel;
    private JPanel MainWin;
    private JPasswordField PasswordText;

    public MainWindow() {
        // Make the window visible
        setVisible(true);

        // Close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        MainWindow main = new MainWindow();
        main.setContentPane(main.MainWin);
        main.setTitle("HRMS");
        main.setSize(500,500);

    }

}
