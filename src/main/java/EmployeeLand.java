import org.example.Employee;

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


    public EmployeeLand(){

        setContentPane(EmployeePage);
        setTitle("Employee Land Page");
        setSize(500,500);

        // Make the window visible
        setVisible(true);

        // Close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
