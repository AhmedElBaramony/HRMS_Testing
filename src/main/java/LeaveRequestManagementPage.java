import org.example.LeaveRequest;
import org.example.Sys;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeaveRequestManagementPage extends JFrame implements ActionListener {
    private int counter;
    private JPanel TitlePanel;
    private JLabel EmployeePageLabel;
    private JPanel BtnPanel;
    private JButton ApproveBtn;
    private JButton RejectBtn;
    private JButton BackBtn;
    private JPanel EmployeeInfoPanel;
    private JLabel NameLabel;
    private JLabel IDLabel;
    private JLabel EmployeeName;
    private JLabel EmployeeID;
    private JLabel DepartmentLabel;
    private JLabel EmployeeDepartment;
    private JPanel LeaveRequestPage;
    private JPanel RequestDetailsPanel;
    private JLabel StartDateLabel;
    private JLabel EndDateLabel;
    private JLabel TypeLabel;
    private JLabel StartDate;
    private JLabel EndDate;
    private JLabel RequestType;
    private JButton NextRequestBtn;
    private JButton PrevRequestBtn;
    private JLabel StatusLabel;
    private JLabel RequestStatus;

    LeaveRequestManagementPage(){
        setContentPane(LeaveRequestPage);
        setTitle("Manage Leave Requests");
        setSize(500,500);
        setVisible(true);
        // Close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PrevRequestBtn.addActionListener(this);
        NextRequestBtn.addActionListener(this);
        ApproveBtn.addActionListener(this);
        RejectBtn.addActionListener(this);
        BackBtn.addActionListener(this);

        counter = 0;
        setInfo(Sys.hrms.getLeaveRequest(counter));
        PrevRequestBtn.setEnabled(false);
    }

    void setInfo(LeaveRequest leaveRequest){
        EmployeeName.setText(leaveRequest.getEmployee().getName());
        EmployeeID.setText(String.valueOf(leaveRequest.getEmployee().getId()));
        EmployeeDepartment.setText(leaveRequest.getEmployee().getDepartment());
        StartDate.setText(leaveRequest.getStart_date().toString());
        EndDate.setText(leaveRequest.getEnd_date().toString());
        RequestType.setText(leaveRequest.getType().toString());
        RequestStatus.setText(leaveRequest.getStatus().toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == PrevRequestBtn){
            if(counter == 1){
                PrevRequestBtn.setEnabled(false);
            }
            counter--;
            setInfo(Sys.hrms.getLeaveRequest(counter));
            NextRequestBtn.setEnabled(true);
        }
        else if(e.getSource() == NextRequestBtn){
            if(counter == Sys.hrms.getLeaveRequestsCount() - 2){
                NextRequestBtn.setEnabled(false);
            }
            counter++;
            setInfo(Sys.hrms.getLeaveRequest(counter));
            PrevRequestBtn.setEnabled(true);
        }
        else if(e.getSource() == ApproveBtn){
            Sys.hrms.acceptLeaveRequest(counter);
            setInfo(Sys.hrms.getLeaveRequest(counter));
        }
        else if(e.getSource() == RejectBtn){
            Sys.hrms.rejectLeaveRequest(counter);
            setInfo(Sys.hrms.getLeaveRequest(counter));
        }
        else{
            new AdminPage();
            dispose();
        }
    }

    public static void main(String[]a){
        new LeaveRequestManagementPage();
    }
}
