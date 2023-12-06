package com.bridgelabz.employeepayrollservice;

public class EmployeePayrollData {
    private Long id;
    private String name;
    private Double salary;
    EmployeePayrollData(Long id , String name , Double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "id : " +this.id + ", name : " + this.name + ", salary : " + this.salary;
    }
}
