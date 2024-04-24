import org.example.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Month;
import java.util.Calendar;
import java.text.DateFormatSymbols;
import java.util.Date;

public class RequestLeavePage extends JFrame implements ActionListener {
    private JPanel TitlePanel;
    private JLabel RequestToLeaveTitle;
    private JPanel DateInputPanel;
    private JLabel StartDateLabel;
    private JLabel EndDateLabel;
    private JPanel BtnPanel;
    private JButton SubmitBtn;
    private JButton BackBtn;
    private JTextField SDayText;
    private JTextField SMonthText;
    private JTextField SYearText;
    private JTextField EDayText;
    private JTextField EMonthText;
    private JTextField EYearText;
    private JLabel TypeLabel;
    private JComboBox TypeDrop;
    private JPanel LeaveTypePanel;
    private JPanel RequestLeavePage;

    RequestLeavePage(){
        String[] types = {LeaveType.VACATION.toString(), LeaveType.HOLIDAY.toString(), LeaveType.EMERGENCY.toString(),
                LeaveType.SICK_LEAVE.toString(), LeaveType.PARENTAL_LEAVE.toString()};
        for(String i:types){
            TypeDrop.addItem(i);
        }

        SubmitBtn.addActionListener(this);
        BackBtn.addActionListener(this);

        setContentPane(RequestLeavePage);
        setTitle("Manage Employees page");
        setSize(500,500);
        setVisible(true);
        // Close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == SubmitBtn){
            try{
                int day = Integer.parseInt(SDayText.getText());
                int month = Integer.parseInt(SDayText.getText());
                int year = Integer.parseInt(SDayText.getText());
                Date start = new Date(day, month, year);

                day = Integer.parseInt(EDayText.getText());
                month = Integer.parseInt(EDayText.getText());
                year =Integer.parseInt(EDayText.getText());
                Date end = new Date(day, month, year);

                LeaveType leaveType = LeaveType.valueOf(TypeDrop.getSelectedItem().toString());

                int id = Sys.hrms.getLeaveRequestsCount();

                Sys.hrms.addRequest(new LeaveRequest(id, Sys.employee, start, end, LeaveStatus.PENDING, leaveType));
                JOptionPane.showMessageDialog(null,"Request added successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(Sys.hrms.getLeaveRequestsCount());
            }
            catch(Exception exp){
                JOptionPane.showMessageDialog(null,"Only numbers are allowed!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        else{
            new EmployeePage();
            dispose();
        }
    }
}
