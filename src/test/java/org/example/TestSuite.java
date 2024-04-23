package org.example;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({
        HRMSTest.class,
        LeaveManagementTest.class,
        LeaveRequestTest.class,
        Employee.class,
        PayrollTest.class,
        PerformanceEvaluationTest.class
})
public class TestSuite {
}
