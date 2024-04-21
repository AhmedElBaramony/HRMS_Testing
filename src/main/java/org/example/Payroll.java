package org.example;

public class Payroll {
    private double baseSalary;
    private double bonus;
    private int tax; //percentage
    private int deduction; //percentage

    public Payroll(double baseSalary, double bonus, int tax, int deduction) {
        if(baseSalary<0)
            this.baseSalary = 0;
        else
            this.baseSalary = baseSalary;

        if(bonus < 0)
            this.bonus = 0;
        else
            this.bonus = bonus;

        if(tax < 0)
            this.tax = 0;
        else if(tax > 100)
            this.tax = 100;
        else
            this.tax = tax;

        if(deduction < 0)
            this.deduction = 0;
        else if(deduction > 100)
            this.deduction = 100;
        else
            this.deduction = deduction;
    }

    public void setBaseSalary(double baseSalary) {
        if(baseSalary<0)
            this.baseSalary = 0;
        else
            this.baseSalary = baseSalary;
    }

    public void setBonus(double bonus) {
        if(bonus < 0)
            this.bonus = 0;
        else
            this.bonus = bonus;
    }

    public void setTax(int tax) {
        if(tax < 0)
            this.tax = 0;
        else if(tax > 100)
            this.tax = 100;
        else
            this.tax = tax;
    }

    public void setDeduction(int deduction) {
        if(deduction < 0)
            this.deduction = 0;
        else if(deduction > 100)
            this.deduction = 100;
        else
            this.deduction = deduction;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public int getTax() {
        return tax;
    }

    public int getDeduction() {
        return deduction;
    }

    public double calculateSalary(){
        double salary = this.baseSalary - (bonus * (this.baseSalary/100));
        salary -= tax * (salary/100);
        salary += this.bonus;
        return salary;
    }
}
