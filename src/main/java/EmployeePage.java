import org.example.Employee;
import org.example.Sys;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeePage extends JFrame implements ActionListener {
    private JLabel EmployeeLandLabel;
    private JLabel NameLabel;
    private JLabel IDLabel;
    private JLabel EmployeeName;
    private JLabel EmployeeID;
    private JLabel DepartmentLabel;
    private JLabel EmployeeDepartment;
    private JPanel EmployeePage;
    private JButton RequestLeaveBtn;
    private JPanel TitlePanel;
    private JPanel EmployeeInfoPanel;
    private JPanel BtnPanel;
    private JButton PerformaceEvalBtn;
    private JButton PayrollBtn;
    private JButton LoginPageBtn;


    public EmployeePage(){
        setContentPane(EmployeePage);
        setTitle("Employee Land Page");
        setSize(500,500);

        Employee emp = Sys.employee;

        EmployeeName.setText(emp.getName());
        EmployeeID.setText(String.valueOf(emp.getId()));
        EmployeeDepartment.setText(emp.getDepartment());
        // Close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Make the window visible
        setVisible(true);

        PayrollBtn.addActionListener(this);
        PerformaceEvalBtn.addActionListener(this);
        RequestLeaveBtn.addActionListener(this);
        LoginPageBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == PayrollBtn){

        }
        else if(e.getSource() == PerformaceEvalBtn){

        }
        else if(e.getSource() == RequestLeaveBtn){

        }
        else{
            new LoginPage();
        }
    }
}
