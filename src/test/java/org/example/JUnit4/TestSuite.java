package org.example.JUnit4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({
        EmployeeTest2.class,
        PayrollTest2.class,
})
public class TestSuite {
}
