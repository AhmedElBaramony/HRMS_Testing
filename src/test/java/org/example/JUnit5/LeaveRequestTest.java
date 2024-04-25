package org.example.JUnit5;

import org.example.Employee;
import org.example.LeaveRequest;
import org.example.LeaveStatus;
import org.example.LeaveType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeaveRequestTest {
    private LeaveRequest leaveRequest;
    private Employee employee;
    private Date startDate;
    private Date endDate;

    @BeforeAll
    static void beforeall(){
        System.out.println("Testing The Leave Request Class ");
    }

    @BeforeEach
    void setUp() {
        employee = new Employee("Hesham Mohamed",3,"heshamelafandi","21P0054", "hesham@gmail.com");
        startDate = new Date(2024,5,25);
        endDate = new Date(2024,6,24);
        leaveRequest = new LeaveRequest(1, employee, startDate, endDate, LeaveStatus.PENDING, LeaveType.HOLIDAY);
    }

    @Test
    @DisplayName("Test Leave_Id Getter/Setter")
    void testLeave_Id() {
        assertEquals(1, leaveRequest.getLeave_Id());
        leaveRequest.setLeave_Id(2);
        assertEquals(2, leaveRequest.getLeave_Id());
    }

    @Test
    @DisplayName("Test Employee Getter/Setter")
    void testEmployee() {
        assertEquals(employee, leaveRequest.getEmployee());
        Employee newEmployee = new Employee("Ahmed Mohamed El Baramouny", 2, "ahmedelbaramouny", "21P0476", "baramouny@gmail.com");
        leaveRequest.setEmployee(newEmployee);
        assertEquals(newEmployee, leaveRequest.getEmployee());
    }

    @Test
    @DisplayName("Test Start_date Getter/Setter")
    void testStart_date() {
        assertEquals(startDate, leaveRequest.getStart_date());
        Date newStartDate = new Date(2024,6,2);
        leaveRequest.setStart_date(newStartDate);
        assertEquals(newStartDate, leaveRequest.getStart_date());
    }

    @Test
    @DisplayName("Test End_date Getter/Setter")
    void testEnd_date() {
        assertEquals(endDate, leaveRequest.getEnd_date());
        Date newEndDate = new Date(2024,7,1);
        leaveRequest.setEnd_date(newEndDate);
        assertEquals(newEndDate, leaveRequest.getEnd_date());
    }

    // To test that the values in the ENUMS are assigned correctly
    @Test
    @DisplayName("Test Enums Getters/Setters")
    void Setters_And_Getters_For_ENUMS() {
        // testSetAndGetStatus
        LeaveStatus[] statuses = LeaveStatus.values();
        for (LeaveStatus status : statuses) {
            leaveRequest.setStatus(status);
            assertEquals(status, leaveRequest.getStatus());
        }
        // testSetAndGetType
        LeaveType[] types = LeaveType.values();
        for (LeaveType type : types) {
            leaveRequest.setType(type);
            assertEquals(type, leaveRequest.getType());
        }
    }

}
