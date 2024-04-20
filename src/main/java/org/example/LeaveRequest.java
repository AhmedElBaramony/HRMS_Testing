package org.example;

import java.util.Date;

public class LeaveRequest {
    private int leave_Id;
    private Employee employee;
    private Date start_date;
    private Date end_date;
    private LeaveStatus status;
    private LeaveType type;

    public LeaveRequest(int leave_Id, Employee employee, Date start_date, Date end_date, LeaveStatus status, LeaveType type) {
        this.leave_Id = leave_Id;
        this.employee = employee;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
        this.type = type;
    }

    public void setLeave_Id(int leave_Id) {
        this.leave_Id = leave_Id;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public void setStatus(LeaveStatus status) {
        this.status = status;
    }

    public void setType(LeaveType type) {
        this.type = type;
    }

    public int getLeave_Id() {
        return leave_Id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Date getStart_date() {
        return start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public LeaveStatus getStatus() {
        return status;
    }

    public LeaveType getType() {
        return type;
    }
}
