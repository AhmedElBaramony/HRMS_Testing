package org.example.JUnit5;

import org.example.Payroll;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PayrollTest {

    private Payroll payroll;
    Payroll payroll1 = new Payroll(50000, 5000, 10, 5);
    Payroll payroll2 = new Payroll(50000, 5000, 0, 5);
    Payroll payroll3 = new Payroll(50000, 5000, 80, 0);

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
    @DisplayName("Test Setters and Getters Correct")
    void testSettersAndGettersCorrect() {
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
    @DisplayName("Test Setters and Getters Incorrect")
    void testSettersAndGettersIncorrect() {
        payroll.setBaseSalary(-500);
        assertEquals(0, payroll.getBaseSalary());

        payroll.setBonus(-73737);
        assertEquals(0, payroll.getBonus());

        payroll.setTax(-5);
        assertEquals(0, payroll.getTax());

        payroll.setTax(150);
        assertEquals(100, payroll.getTax());

        payroll.setDeduction(-5);
        assertEquals(0, payroll.getDeduction());

        payroll.setDeduction(150);
        assertEquals(100, payroll.getDeduction());
    }


    // Parameterized test example
    @ParameterizedTest
    @ValueSource(strings = {"payroll1", "payroll2", "payroll3"})
    void testCalculateSalaryWithParameter(String input) {
        // Perform test with parameter input
        if (input.equals("payroll1"))   assertEquals(47750, payroll1.calculateSalary());
        if (input.equals("payroll2"))   assertEquals(52500, payroll2.calculateSalary());
        if (input.equals("payroll3"))   assertEquals(15000, payroll3.calculateSalary());
    }

    @RepeatedTest(2)
    @DisplayName("Test Calculate Salary with Zero Tax")
    void testCalculateSalaryWithZeroTax() {
        payroll.setTax(0);
        assertEquals(52500, payroll.calculateSalary());
    }

}
