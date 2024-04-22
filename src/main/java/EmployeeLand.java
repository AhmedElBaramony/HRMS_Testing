import org.example.Employee;
import org.example.Sys;

import javax.swing.*;

public class EmployeeLand extends JFrame {
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
    private JPanel PerfEvalPanel;
    private JPanel PayrollPanel;
    private JPanel LeaveBtnPanel;
    private JLabel PerformanceEvaluationLabel;
    private JLabel PayrollLabel;


    public EmployeeLand(){

        setContentPane(EmployeePage);
        setTitle("Employee Land Page");
        setSize(500,500);

        Employee emp = Sys.hrms.getEmployee(Sys.status);

        EmployeeName.setText(emp.getName());
        EmployeeID.setText(String.valueOf(emp.getId()));
        EmployeeDepartment.setText(emp.getDepartment());


        // Make the window visible
        setVisible(true);

        // Close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
