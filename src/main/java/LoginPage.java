import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.example.Sys;

public class LoginPage extends JFrame implements ActionListener{

    private JButton LoginBtn;
    private JTextField UsernameText;
    private JLabel UsernameLabel;
    private JLabel HRMSLabel;
    private JLabel PasswordLabel;
    private JPanel MainWin;
    private JPasswordField PasswordText;
    private JPanel TitlePanel;
    private JPanel BtnPanel;
    private JPanel InnputPanel;

    public int status;

    public LoginPage() {
        // Make the window visible
        setVisible(true);

        setContentPane(MainWin);
        setTitle("HRMS");
        setSize(500,500);
        setVisible(true);

        // Close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LoginBtn.addActionListener(this);
    }

    public static void main(String[] args) {
        new LoginPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == LoginBtn){
            String username = UsernameText.getText();
            String password = new String(PasswordText.getPassword());

            status = Sys.hrms.authenticate(username,password);

            if (status >= 0) {
                Sys.employee = Sys.hrms.getEmployee(status);
                new EmployeePage();
                dispose();
            }
            else if(status == -1){
                new AdminPage();
                Sys.employee = null;
                dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(LoginPage.this, "Invalid Credentials!");
            }
        }
    }
}
