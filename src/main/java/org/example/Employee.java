package org.example;

public class Employee {
    private String name;
    private int id;
    private String username;
    private String password;
    private String department;
    private Payroll salary;
    private PerformanceEvaluation performanceEvaluation;

    public Employee(String name, int id, String username, String password, String department) {
        this.name = name;
        this.id = id;
        this.username = username;
        this.password = password;
        this.department = department;
        this.salary = null;
        this.performanceEvaluation = null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(Payroll salary) {
        this.salary = salary;
    }

    public void setPerformanceEvaluation(PerformanceEvaluation performanceEvaluation) {
        this.performanceEvaluation = performanceEvaluation;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDepartment() {
        return department;
    }

    public Payroll getSalary() {
        return salary;
    }

    public PerformanceEvaluation getPerformanceEvaluation() {
        return performanceEvaluation;
    }
}

