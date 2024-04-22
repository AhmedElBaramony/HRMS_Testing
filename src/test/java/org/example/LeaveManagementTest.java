package org.example;

import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class LeaveManagementTest {

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
        employee = new Employee("Hesham Mohamed",1,"heshamelafandi","21P0054", "hesham@gmail.com");
        startDate = new Date(2024,5,25);
        endDate = new Date(2024,6,24);
        leaveRequest = new LeaveRequest(1, employee, startDate, endDate, LeaveStatus.PENDING, LeaveType.HOLIDAY);
        leaveManagement = new LeaveManagement();
        leaveManagement.addRequest(leaveRequest);
    }
    @Test
    @Order(1)
    @DisplayName("Add and Get leave Request")

    public void testAddRequestAndGetLeaveRequest() {
        assertEquals(leaveRequest, leaveManagement.getLeaveRequest(0));
    }

    @Test
    @Order(2)
    @DisplayName("Search leave Request")
    void searchRequest() {
        int x = -1;
        assertEquals(0, leaveManagement.searchRequest(1));
        assertTrue(x == leaveManagement.searchRequest(2)); // Non-existent ID
    }

    @Test
    @Order(3)
    @DisplayName("Accept leave Request")
    void acceptLeaveRequest() {
        leaveManagement.acceptLeaveRequest(0);
        assertEquals(LeaveStatus.ACCEPTED, leaveManagement.getLeaveRequest(0).getStatus());
    }

    @Test
    @Order(4)
    @DisplayName("Reject leave Request")
    void rejectLeaveRequest() {
        leaveManagement.rejectLeaveRequest(0);
        assertEquals(LeaveStatus.REJECTED, leaveManagement.getLeaveRequest(0).getStatus());
    }
}