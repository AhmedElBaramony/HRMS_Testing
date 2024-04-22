package org.example;

import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class HRMSTest {

    private HRMS hrms;
    private Employee testEmployee;
    private LeaveRequest testLeaveRequest;
    private Date startDate;
    private Date endDate;
    private LeaveManagement leaveManagement;

    @BeforeAll
    static void beforeall(){
        System.out.println("Testing The HRMS system ");
    }

    @BeforeEach
    void setUp() {
        hrms = new HRMS();
        testEmployee = new Employee("Hesham Mohamed",1,"heshamelafandi","21P0054", "hesham@gmail.com");
        startDate = new Date(2024,5,25);
        endDate = new Date(2024,6,24);
        testLeaveRequest = new LeaveRequest(1, testEmployee, startDate, endDate, LeaveStatus.PENDING, LeaveType.HOLIDAY);
        leaveManagement = new LeaveManagement();
        leaveManagement.addRequest(testLeaveRequest);
    }

    @Test
    @Order(1)
    @DisplayName("Test Add and Get Employee")
    void testAddEmployeeAndGetEmployee() {
        hrms.addEmployee(testEmployee);
        assertEquals(testEmployee, hrms.getEmployee(0));
    }

    @Test
    @Order(2)
    @DisplayName("Test Search Employee")
    void testSearchEmployee() {
        // Here We apply integration testing between HRMS and Employee
        hrms.addEmployee(testEmployee);
        assertEquals(0, hrms.searchEmployee(testEmployee.getId()));
    }

    @Test
    @Order(3)
    @DisplayName("Test Add and Get Leave request")
    // Here We apply integration testing between HRMS and LeaveRequest
    void testAddRequestAndGetLeaveRequest() {
        hrms.addRequest(testLeaveRequest);
        assertEquals(testLeaveRequest, hrms.getLeaveRequest(0));
    }

    @Test
    @Order(4)
    @DisplayName("Test Remove Employee")
        // Here We apply integration testing between HRMS and Employee
    void testRemoveEmployee() {
        hrms.addEmployee(testEmployee);
        hrms.removeEmployee(0);
        assertTrue( hrms.searchEmployee(testEmployee.getId()) == -1);
    }
 /*
    @Test
    @Order(5)
    @DisplayName("Test Authentication")
    void testAuthenticate() {
        hrms.addEmployee(testEmployee);
        int employeeIndex = hrms.authenticate(testEmployee.getUsername(), testEmployee.getPassword());
        assertEquals(0, employeeIndex);
    }

 */
}