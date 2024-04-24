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
    private JButton ViewRequestsBtn;


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
        ViewRequestsBtn.addActionListener(this);
        LoginPageBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == PayrollBtn){
            if(Sys.employee.getSalary() == null){
                JOptionPane.showMessageDialog(null,"Employee doesn't have a payroll yet!","Info",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            new EmployeeGetPayrollPage();
            dispose();
        }
        else if(e.getSource() == PerformaceEvalBtn){
            if(Sys.employee.getPerformanceEvaluation() == null){
                JOptionPane.showMessageDialog(null,"Employee doesn't have a Performance evaluation yet!","Info",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            new EmployeeGetEvaluationPage();
            dispose();
        }
        else if(e.getSource() == RequestLeaveBtn){
            new RequestLeavePage();
            dispose();
        }
        else if(e.getSource() == ViewRequestsBtn){
            new ViewLeaveRequestsPage();
            dispose();
        }
        else{
            new LoginPage();
            dispose();
        }
    }
}
