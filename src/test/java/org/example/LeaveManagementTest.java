package org.example;

import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class LeaveManagementTest {
    public LeaveManagementTest() {
    }

    private LeaveRequest leaveRequest;
    private Employee employee;
    private Date startDate;
    private Date endDate;
    private LeaveManagement leaveManagement;

    @BeforeAll
    static void beforeall(){
        System.out.println("Testing The Leave Management ");
    }

    @BeforeEach
    void setUp() {
        employee = new Employee("Hesham Mohamed",2,"heshamelafandi","21P0054", "hesham@gmail.com");
        startDate = new Date(2024,5,25);
        endDate = new Date(2024,6,24);
        leaveRequest = new LeaveRequest(1, employee, startDate, endDate, LeaveStatus.PENDING, LeaveType.HOLIDAY);
        leaveManagement = new LeaveManagement();
        leaveManagement.addRequest(leaveRequest);
    }
    @Test
    @Order(1)
    @DisplayName("Get leave Request")
    public void testAddRequestAndGetLeaveRequest() {
        assertEquals(leaveRequest, leaveManagement.getLeaveRequest(0));
    }

    @Test
    @Order(2)
    @DisplayName("Search leave Request Found")
    public void searchRequestFound() {
        assertEquals(0, leaveManagement.searchRequest(1));
    }

    @Test
    @Order(3)
    @DisplayName("Search leave Request Not Found")
    public void searchRequestNotFound() {
        assertTrue(-1 == leaveManagement.searchRequest(2)); // Non-existent ID
    }

    @Test
    @Order(4)
    @DisplayName("Accept leave Request")
    public void acceptLeaveRequest() {
        leaveManagement.acceptLeaveRequest(0);
        assertEquals(LeaveStatus.ACCEPTED, leaveManagement.getLeaveRequest(0).getStatus());
    }

    @Test
    @Order(5)
    @DisplayName("Reject leave Request")
    public void rejectLeaveRequest() {
        leaveManagement.rejectLeaveRequest(0);
        assertEquals(LeaveStatus.REJECTED, leaveManagement.getLeaveRequest(0).getStatus());
    }
}