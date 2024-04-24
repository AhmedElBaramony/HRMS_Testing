import org.example.Employee;
import org.example.LeaveRequest;
import org.example.Sys;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewLeaveRequestsPage extends JFrame implements ActionListener{
    private ArrayList<LeaveRequest> leaveRequests;
    int counter; //curr index
    private JPanel TitlePanel;
    private JLabel ViewLeaveRequestTitle;
    private JPanel DateInputPanel;
    private JLabel StartDateLabel;
    private JLabel EndDateLabel;
    private JLabel TypeLabel;
    private JLabel StartDateText;
    private JPanel BtnPanel;
    private JButton BackBtn;
    private JPanel ViewLeaveRequestPage;
    private JLabel StatusLabel;
    private JLabel EndDateText;
    private JLabel TypeText;
    private JLabel StatusText;
    private JButton PrevRequestBtn;
    private JButton NextRequestBtn;

    ViewLeaveRequestsPage(){
        setContentPane(ViewLeaveRequestPage);
        setTitle("Employee Land Page");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        BackBtn.addActionListener(this);
        PrevRequestBtn.addActionListener(this);
        NextRequestBtn.addActionListener(this);
        PrevRequestBtn.setEnabled(false);

        leaveRequests = new ArrayList<LeaveRequest>();
        //importing employee's leave requests for viewing
        LeaveRequest lr;
        int count = 0;
        for(int i=0;i<Sys.hrms.getLeaveRequestsCount();i++){
            lr = Sys.hrms.getLeaveRequest(i);
            if(lr.getEmployee().getId() == Sys.employee.getId()) {
                leaveRequests.add(lr);
                count++;
            }
        }
        if(count==0){
            new EmployeePage();
            dispose();
            JOptionPane.showMessageDialog(null,"No Leave Requests available!", "Info",JOptionPane.INFORMATION_MESSAGE);
        }

        counter = 0;
        setInfo(leaveRequests.get(counter));
    }

    void setInfo(LeaveRequest leaveRequest){
        StartDateText.setText(leaveRequest.getStart_date().toString());
        EndDateText.setText(leaveRequest.getEnd_date().toString());
        TypeText.setText(leaveRequest.getType().toString());
        StatusText.setText(leaveRequest.getStatus().toString());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == PrevRequestBtn){
            NextRequestBtn.setEnabled(true);
            if(counter==1){
                PrevRequestBtn.setEnabled(false);
            }
            counter--;
            setInfo(leaveRequests.get(counter));
        }
        else if(e.getSource() == NextRequestBtn){
            PrevRequestBtn.setEnabled(true);
            if(counter==leaveRequests.size() - 2){
                NextRequestBtn.setEnabled(false);
            }
            counter++;
            setInfo(leaveRequests.get(counter));
        }
        else{
            new EmployeePage();
            dispose();
        }
    }
}
