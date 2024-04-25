package org.example.JUnit5;

import org.example.*;
import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class HRMSTest {
    public HRMSTest() {
    }

    private HRMS hrms;
    private Employee testEmployee;
    private LeaveRequest testLeaveRequest;
    private Date startDate;
    private Date endDate;
    private LeaveManagement leaveManagement;

    @BeforeAll
    static void beforeall(){
        System.out.println("Testing The HRMS system Class ");
    }

    @BeforeEach
    void setUp() {
        hrms = new HRMS();
        testEmployee = new Employee("Hesham Mohamed",4,"heshamelafandi","21P0054", "hesham@gmail.com");
        startDate = new Date(2024,5,25);
        endDate = new Date(2024,6,24);
        testLeaveRequest = new LeaveRequest(1, testEmployee, startDate, endDate, LeaveStatus.PENDING, LeaveType.HOLIDAY);
        leaveManagement = new LeaveManagement();
        leaveManagement.addRequest(testLeaveRequest);
    }
    // Integration Testing with LeaveManagement Class  in tests from 5-9
    // The rest is Unit testing

    @Test
    @Order(1)
    @DisplayName("Test Add and Get Employee")
    public void testAddEmployeeAndGetEmployee() {
        hrms.addEmployee(testEmployee);
        assertEquals(testEmployee.getId(), hrms.getEmployee(hrms.searchEmployee(testEmployee.getId())).getId());
    }

    @Test
    @Order(2)
    @DisplayName("Test Search Employee Found")
    public void testSearchEmployeeFound() {
        hrms.addEmployee(testEmployee);
        // The expected is location 1 Because in 0 there is already an Employee
        assertEquals(1, hrms.searchEmployee(testEmployee.getId()));
    }

    @Test
    @Order(3)
    @DisplayName("Test Search Employee Not Found")
    public void testSearchEmployeeNotFound() {
        // WE DIDN'T ADD THE EMPLOYEE THIS TIME
        assertEquals(-1, hrms.searchEmployee(testEmployee.getId()));
    }

    @Test
    @Order(4)
    @DisplayName("Test Remove Employee")
    public void testRemoveEmployee() {
        hrms.addEmployee(testEmployee);
        hrms.removeEmployee(hrms.searchEmployee(testEmployee.getId()));
        assertEquals(-1 , hrms.searchEmployee(testEmployee.getId()));
    }

    @Test
    @Order(5)
    @DisplayName("Test Add and Get Leave request")
    // Here We apply integration testing between HRMS and LeaveRequest
    public void testAddRequestAndGetLeaveRequest() {
        hrms.addRequest(testLeaveRequest);
        assertEquals(testLeaveRequest, hrms.getLeaveRequest(0));
    }
    @Test
    @DisplayName("Search Request: Request Exists")
    @Order(6)
    public void testSearchRequestWhenRequestExists() {
        hrms.addRequest(testLeaveRequest);
        int index = hrms.searchRequest(testLeaveRequest.getLeave_Id());
        assertEquals(0, index, "Search request should return the index of the request");
    }

    @Test
    @DisplayName("Search Request: Request Does Not Exist")
    @Order(7)
    public void testSearchRequestWhenRequestDoesNotExist() {
        int index = hrms.searchRequest(15);
        assertEquals(-1, index);
    }

    @Test
    @DisplayName("Accept Leave Request")
    @Order(8)
    public void testAcceptLeaveRequest() {
        hrms.addRequest(testLeaveRequest);
        hrms.acceptLeaveRequest(0);
        assertEquals(LeaveStatus.ACCEPTED, testLeaveRequest.getStatus());
    }

    @Test
    @DisplayName("Reject Leave Request")
    @Order(9)
    public void testRejectLeaveRequest() {
        hrms.addRequest(testLeaveRequest);
        hrms.rejectLeaveRequest(0);
        assertEquals(LeaveStatus.REJECTED, testLeaveRequest.getStatus());
    }
    @Test
    @Order(10)
    @DisplayName("Test authentication for admin user")
    public void testAdminAuthentication() {
        assertEquals(-1, hrms.authenticate("admin", "admin"));
    }

    @Test
    @Order(11)
    @DisplayName("Test authentication for valid employee user")
    public void testValidEmployeeAuthentication() {
        hrms.addEmployee(testEmployee);
         assertEquals(hrms.searchEmployee(testEmployee.getId()),
                 hrms.authenticate(hrms.getEmployee(hrms.searchEmployee(testEmployee.getId())).getUsername(),
                 hrms.getEmployee(hrms.searchEmployee(testEmployee.getId())).getPassword()));
    }

    @Test
    @Order(12)
    @DisplayName("Test authentication for invalid user")
    public void testInvalidAuthentication() {
        assertEquals(-2,
                hrms.authenticate("invalidUser", "invalidPassword"));
    }
}