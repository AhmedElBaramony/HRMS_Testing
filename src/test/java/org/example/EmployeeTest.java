package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class EmployeeTest {
    private Employee employee;
    private Payroll payroll;
    private PerformanceEvaluation performanceEvaluation;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Testing The Employee Class");
    }

    @BeforeEach
    void setUp() {
        payroll = new Payroll(50000.0, 5000.0, 10, 5); // New sample values for baseSalary, bonus, tax, and deduction

        Evaluation quality = Evaluation.EXCELLENT;
        Evaluation productivity = Evaluation.GOOD;
        Evaluation punctuality = Evaluation.EXCELLENT;
        Evaluation collaboration = Evaluation.GOOD;
        Evaluation initiative = Evaluation.EXCELLENT;

        performanceEvaluation = new PerformanceEvaluation(quality, productivity, punctuality, collaboration, initiative);

        employee = new Employee("Ahmed Mohamed", 1000, "Ahmed_Moh7", "Ahmed2003", "Ain Shams");
        employee.setSalary(payroll);
        employee.setPerformanceEvaluation(performanceEvaluation);
    }

    @Test
    @DisplayName("Test Name Getter/Setter")
    void testName() {
        assertEquals("Ahmed Mohamed", employee.getName());
        employee.setName("Mohamed Ahmed");
        assertEquals("Mohamed Ahmed", employee.getName());
    }

    @Test
    @DisplayName("Test Id Getter/Setter")
    void testId() {
        assertEquals(1000, employee.getId());
        employee.setId(1001);
        assertEquals(1001, employee.getId());
    }

    @Test
    @DisplayName("Test Username Getter/Setter")
    void testUsername() {
        assertEquals("Ahmed_Moh7", employee.getUsername());
        employee.setUsername("Moh7_Ahmed");
        assertEquals("Moh7_Ahmed", employee.getUsername());
    }

    @Test
    @DisplayName("Test Password Getter/Setter")
    void testPassword() {
        assertEquals("Ahmed2003", employee.getPassword());
        employee.setPassword("Mohamed2023");
        assertEquals("Mohamed2023", employee.getPassword());
    }

    @Test
    @DisplayName("Test Department Getter/Setter")
    void testDepartment() {
        assertEquals("Ain Shams", employee.getDepartment());
        employee.setDepartment("Cairo University");
        assertEquals("Cairo University", employee.getDepartment());
    }

    // *********** integrate with PayRoll ***********
    @Test
    @DisplayName("Test Salary Getter/Setter")
    void testSalary() {
        assertEquals(payroll, employee.getSalary());
        Payroll newPayroll = new Payroll(60000.0, 5500.0, 12, 6); // New sample values
        employee.setSalary(newPayroll);
        assertEquals(newPayroll, employee.getSalary());
    }

    // *********** integrate with performanceEvaluation ***********
    @Test
    @DisplayName("Test Get PerformanceEvaluation")
    void testGetPerformanceEvaluation() {
        assertEquals(performanceEvaluation, employee.getPerformanceEvaluation());
    }
}
