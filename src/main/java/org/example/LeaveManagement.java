package org.example;
import java.util.ArrayList;

public class LeaveManagement {
    ArrayList<LeaveRequest> leaveRequests;

    public LeaveManagement() {
        this.leaveRequests = new ArrayList<LeaveRequest>();
    }

    public LeaveRequest getLeaveRequest(int index){
        return leaveRequests.get(index);
    }

    public void addRequest(LeaveRequest leaveRequest){
        leaveRequests.add(leaveRequest);
    }

    public int searchRequest(int id){
        int index = -1;
        for(int i=0;i<leaveRequests.size();i++){
            if(leaveRequests.get(i).getLeave_Id() == id){
                index = i;
                break;
            }
        }
        return index;
    }

    public int getSize(){
        return leaveRequests.size();
    }

    public void acceptLeaveRequest(int index){
        leaveRequests.get(index).setStatus(LeaveStatus.ACCEPTED);
    }

    public void rejectLeaveRequest(int index){
        leaveRequests.get(index).setStatus(LeaveStatus.REJECTED);
    }
}
