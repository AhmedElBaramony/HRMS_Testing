import org.example.Sys;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage extends JFrame implements ActionListener {
    private JPanel AdminPage;
    private JPanel TitlePanel;
    private JLabel AdminPageLabel;
    private JButton EmployeeServicesBtn;
    private JPanel BtnPanel;
    private JButton LeaveReqBtn;
    private JButton LoginPageBtn;


    public AdminPage(){
        setContentPane(AdminPage);
        setTitle("Admin Page");
        setSize(500,500);
        setVisible(true);
        // Close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        EmployeeServicesBtn.addActionListener(this);
        LeaveReqBtn.addActionListener(this);
        LoginPageBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == EmployeeServicesBtn) {
            new EmployeeServicesPage();
            dispose();
        }
        else if(e.getSource() == LeaveReqBtn){
            if(Sys.hrms.getLeaveRequestsCount() == 0){
                JOptionPane.showMessageDialog(null,"No Leave Requests available!", "Info",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            new LeaveRequestManagementPage();
            dispose();
        }
        else
        {
            new LoginPage();
            dispose();
        }
    }

    public static void main(String []args){
        new AdminPage();
    }
}
