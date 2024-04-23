package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class PayrollTest {

    private Payroll payroll;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Testing The Payroll Class");
    }

    @BeforeEach
    void setUp() {
        payroll = new Payroll(50000, 5000, 10, 5);
    }

    @Test
    @DisplayName("Test Constructor with Valid Values")
    void testConstructorWithValidValues() {
        assertEquals(50000, payroll.getBaseSalary());
        assertEquals(5000, payroll.getBonus());
        assertEquals(10, payroll.getTax());
        assertEquals(5, payroll.getDeduction());
    }

    @Test
    @DisplayName("Test Constructor with Negative Values")
    void testConstructorWithNegativeValues() {
        Payroll negativePayroll = new Payroll(-50000, -5000, -10, -5);
        assertEquals(0, negativePayroll.getBaseSalary());
        assertEquals(0, negativePayroll.getBonus());
        assertEquals(0, negativePayroll.getTax());
        assertEquals(0, negativePayroll.getDeduction());
    }

    @Test
    @DisplayName("Test Constructor with Out of Range Values")
    void testConstructorWithOutOfRangeValues() {
        Payroll outOfRangePayroll = new Payroll(150000, 15000, 110, 105);
        assertEquals(150000, outOfRangePayroll.getBaseSalary());
        assertEquals(15000, outOfRangePayroll.getBonus());
        assertEquals(100, outOfRangePayroll.getTax());
        assertEquals(100, outOfRangePayroll.getDeduction());
    }

    @Test
    @DisplayName("Test Setters and Getters")
    void testSettersAndGetters() {
        payroll.setBaseSalary(60000);
        assertEquals(60000, payroll.getBaseSalary());

        payroll.setBonus(6000);
        assertEquals(6000, payroll.getBonus());

        payroll.setTax(15);
        assertEquals(15, payroll.getTax());

        payroll.setDeduction(10);
        assertEquals(10, payroll.getDeduction());
    }

    @Test
    @DisplayName("Test Calculate Salary")
    void testCalculateSalary() {
        assertEquals(47750, payroll.calculateSalary());
    }

    @Test
    @DisplayName("Test Calculate Salary with Zero Tax")
    void testCalculateSalaryWithZeroTax() {
        payroll.setTax(0);
        assertEquals(52500, payroll.calculateSalary());
    }

    @Test
    @DisplayName("Test Calculate Salary with Zero Deduction")
    void testCalculateSalaryWithZeroDeduction() {
        payroll.setDeduction(0);
        assertEquals(50000, payroll.calculateSalary());
    }

    @Test
    @DisplayName("Test Calculate Salary with Negative Values")
    void testCalculateSalaryWithNegativeValues() {
        payroll.setBaseSalary(-50000);
        payroll.setBonus(-5000);
        assertEquals(0, payroll.calculateSalary());
    }
}
