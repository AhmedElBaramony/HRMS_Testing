import org.example.Payroll;
import org.example.Sys;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetPayrollPage extends JFrame implements ActionListener{
    private JLabel SetPayrollTitle;
    private JPanel PayrollInputPanel;
    private JLabel BaseSalaryLabel;
    private JLabel BonusLabel;
    private JLabel TaxLabel;
    private JButton SubmitBtn;
    private JTextField BaseSalaryText;
    private JPanel SetPayrollPage;
    private JLabel DeductionLabel;
    private JTextField BonusText;
    private JTextField TaxText;
    private JTextField DeductionText;
    private JPanel BtnPanel;
    private JPanel TitlePanel;
    private JButton BackBtn;

    SetPayrollPage(){
        setContentPane(SetPayrollPage);
        setTitle("Payroll page");
        setSize(500,500);
        setVisible(true);
        // Close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SubmitBtn.addActionListener(this);
        BackBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == SubmitBtn){
            try{
                double bs = Double.parseDouble(BaseSalaryText.getText());
                double bonus = Double.parseDouble(BonusText.getText());
                int tax = Integer.parseInt(TaxText.getText());
                int ded = Integer.parseInt(DeductionText.getText());
                Payroll payroll = new Payroll(bs,bonus,tax,ded);
                Sys.employee.setSalary(payroll);
                JOptionPane.showMessageDialog(null, "Payroll added successfully");
            }
            catch(Exception exp){
                JOptionPane.showMessageDialog(null, "Only numbers are allowed!!", "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            new ManageEmployeePage();
            dispose();
        }
    }
}
