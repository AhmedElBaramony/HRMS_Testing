import org.example.Payroll;
import org.example.Sys;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetPayrollPage extends JFrame{
    private JPanel TitlePanel;
    private JLabel GetPayrollTitle;
    private JPanel PayrollInfoPanel;
    private JLabel BaseSalaryLabel;
    private JLabel BonusLabel;
    private JLabel TaxLabel;
    private JLabel DeductionLabel;
    private JPanel BtnPanel;
    private JButton BackBtn;
    private JLabel BaseSalaryText;
    private JPanel GetPayrollPage;
    private JLabel BonusText;
    private JLabel TaxText;
    private JLabel DeductionText;
    private JLabel NetSalaryLabel;
    private JLabel NetSalaryText;

    GetPayrollPage(){
        setContentPane(GetPayrollPage);
        setTitle("Payroll page");
        setSize(500,500);
        setVisible(true);
        // Close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Payroll payroll = Sys.employee.getSalary();
        BaseSalaryText.setText(String.valueOf(payroll.getBaseSalary()));
        BonusText.setText(String.valueOf(payroll.getBonus()));;
        TaxText.setText(String.valueOf(payroll.getTax()));
        DeductionText.setText(String.valueOf(payroll.getDeduction()));;
        NetSalaryText.setText(String.valueOf(payroll.calculateSalary()));;

        BackBtn.addActionListener(e->{
            new ManageEmployeePage();
            dispose();
        });
    }
}
