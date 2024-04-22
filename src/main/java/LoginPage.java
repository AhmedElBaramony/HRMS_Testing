import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.example.Employee;
import org.example.HRMS;
import org.example.Sys;

public class LoginPage extends JFrame {

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

        // Close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LoginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = UsernameText.getText();
                char[] passch = PasswordText.getPassword();
                String password = new String(passch);

                status = Sys.hrms.authenticate(username,password);

                Sys.status = status;

                if (status >= 0) {

                    Employee employee = Sys.hrms.getEmployee(status);
                    EmployeeLand employeepage = new EmployeeLand();
                    dispose();

                    //JOptionPane.showMessageDialog(LoginPage.this, "Employee Name = " + employee.getName());


                }
                else {

                    JOptionPane.showMessageDialog(LoginPage.this, "Admin Logged");
                }
                // Do something with the input text (e.g., display it)

            }
        });
    }

    public static void main(String[] args) {

        LoginPage main = new LoginPage();
        main.setContentPane(main.MainWin);
        main.setTitle("HRMS");
        main.setSize(500,500);

    }

}
