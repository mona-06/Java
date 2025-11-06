package com.DAY5.CW.InterfaceDemo;

interface Payable{
    void generatePayslip();
}

interface Bonus{
    void calculateBonus();
}

class Contractor implements Payable,Bonus {
    @Override
    public void generatePayslip() {
        System.out.println("Contractor's Salary can be calculated on day basis ");
    }

    @Override
    public void calculateBonus(){
        System.out.println("Bonus  can be calculated by performance");
    }
}

class FullTimeEmployee implements Payable,Bonus{
    @Override
    public void generatePayslip() {
        System.out.println("FullTimeEmployee's Salary will be calculated on month basis ");
    }
    @Override
    public void calculateBonus(){
            System.out.println("FullTimeEmployee's Bonus  can be calculated by performance");
    }
}
public class InterfaceDemo {
    public static void main(String[] args) {
        Payable Contractor = new Contractor();
        Contractor.generatePayslip();
        Bonus Contractor1 = new Contractor();
        Contractor1.calculateBonus();
        Payable FullTimeEmployee = new FullTimeEmployee();
        FullTimeEmployee.generatePayslip();
        Bonus Contractor2 = new Contractor();
        Contractor2.calculateBonus();
    }
}
