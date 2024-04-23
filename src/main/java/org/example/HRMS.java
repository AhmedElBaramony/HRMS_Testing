package org.example;

import java.util.ArrayList;

public class HRMS{
    private ArrayList<Employee> employees;
    private LeaveManagement leaveManagement;

    public HRMS() {
        this.employees = new ArrayList<Employee>();
        this.leaveManagement = new LeaveManagement();

        Employee emp1 = new Employee("Ahmed",1,"ahmed","ahmed", "baramony@gmail.com");
        employees.add(emp1);
    }

    public Employee getEmployee(int index){
        return employees.get(index);
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public int searchEmployee(int id){
        int index = -1;
        for(int i=0;i<employees.size();i++){
            if(employees.get(i).getId() == id){
                index = i;
                break;
            }
        }
        return index;
    }

    public void removeEmployee(int index){
        employees.remove(index);
    }

    public LeaveRequest getLeaveRequest(int index){
        return leaveManagement.getLeaveRequest(index);
    }

    public void addRequest(LeaveRequest leaveRequest){
        leaveManagement.addRequest(leaveRequest);
    }

    public int searchRequest(int id){
        return leaveManagement.searchRequest(id);
    }

    public void acceptLeaveRequest(int index){
        leaveManagement.acceptLeaveRequest(index);
    }

    public void rejectLeaveRequest(int index){
        leaveManagement.rejectLeaveRequest(index);
    }

    public int authenticate(String username, String password){
        int state = -2; //not an admin nor employee

        if(username.equals("admin") && password.equals("admin")){
            state = -1; //admin
        }
        else
        {
            for (int i=0;i<employees.size();i++)
            {
                if (username.equals(employees.get(i).getUsername()) && password.equals(employees.get(i).getPassword())) {
                    state = i; //employee
                    break;
                }
            }
        }

        return state;
    }
}
