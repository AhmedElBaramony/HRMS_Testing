import org.example.Employee;
import org.example.Sys;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageEmployeePage extends JFrame implements ActionListener {
    private JPanel TitlePanel;
    private JLabel ManageEmployeePageLabel;
    private JPanel EmployeeIDPanel;
    private JTextField IDText;
    private JLabel EmployeeIDLabel;
    private JButton SubmitBtn;
    private JPanel ManageEmployeePage;
    private JPanel BtnPanel;
    private JButton SetPayrollBtn;
    private JButton GetPayrollBtn;
    private JButton FireEmployeeBtn;
    private JButton SetEvaluationBtn;
    private JButton GetEvaluationBtn;
    private JButton ReturnBtn;
    private JPanel EmployeeInfoPanel;
    private JLabel NameLabel;
    private JLabel IDLabel;
    private JLabel EmployeeName;
    private JLabel EmployeeID;
    private JLabel DepartmentLabel;
    private JLabel EmployeeDepartment;

    ManageEmployeePage(){
        setContentPane(ManageEmployeePage);
        setTitle("Manage Employees page");
        setSize(500,500);
        setVisible(true);
        // Close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        EmployeeInfoPanel.setVisible(false);
        BtnPanel.setVisible(false);

        SubmitBtn.addActionListener(this);
        SetPayrollBtn.addActionListener(this);
        GetPayrollBtn.addActionListener(this);
        SetEvaluationBtn.addActionListener(this);
        GetEvaluationBtn.addActionListener(this);
        FireEmployeeBtn.addActionListener(this);

        ReturnBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == SubmitBtn){
            if(IDText.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please enter an id!", "Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            int id;
            try{
                id = Integer.parseInt(IDText.getText());
            }
            catch(Exception exp){
                EmployeeInfoPanel.setVisible(false);
                BtnPanel.setVisible(false);
                JOptionPane.showMessageDialog(null,"Only numbers are allowed in ID!!", "Error",JOptionPane.ERROR_MESSAGE);
                return;
            }

            int index = Sys.hrms.searchEmployee(id);
            if(index == -1){
                EmployeeInfoPanel.setVisible(false);
                BtnPanel.setVisible(false);
                JOptionPane.showMessageDialog(null,"ID doesn't exist!", "Error",JOptionPane.ERROR_MESSAGE);
                return;
            }

            Sys.employee = Sys.hrms.getEmployee(index);

            EmployeeName.setText(Sys.employee.getName());
            EmployeeID.setText(String.valueOf(Sys.employee.getId()));
            EmployeeDepartment.setText(Sys.employee.getDepartment());

            EmployeeInfoPanel.setVisible(true);
            BtnPanel.setVisible(true);
        }
        else if(e.getSource() == SetPayrollBtn){
            new SetPayrollPage();
            dispose();
        }
        else if(e.getSource() == GetPayrollBtn){
            new GetPayrollPage();
            dispose();
        }
        else if(e.getSource() == SetEvaluationBtn){
            new SetEvaluationPage();
            dispose();
        }
        else if(e.getSource() == GetEvaluationBtn){
            new GetEvaluationPage();
            dispose();
        }
        else if(e.getSource() == FireEmployeeBtn){
            int option = JOptionPane.showConfirmDialog(null,"ID doesn't exist!", "Error",JOptionPane.YES_NO_OPTION);
            if(option == 0){
                int id = Sys.employee.getId();
                int index = Sys.hrms.searchEmployee(id);
                EmployeeInfoPanel.setVisible(false);
                BtnPanel.setVisible(false);
                Sys.hrms.removeEmployee(index);
            }
        }
        else{
            new EmployeeServicesPage();
            dispose();
        }

    }
}
