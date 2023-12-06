package com.bridgelabz.employeepayrollservice;

/**
 * Employee Payroll Data Class
 */
public class EmployeePayrollData {
    private Long id;
    private String name;
    private Double salary;

    /**
     * Constructo to initialize the private variables id , name and salary to initialize with
     * @param id
     * id of the employee payroll data
     * @param name
     * name of the employee
     * @param salary
     * salary of the employee
     */
    EmployeePayrollData(Long id , String name , Double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    /**
     * Method to get the name of the employee from employee payroll data class
     * @return
     * Name of the employee
     */
    public String getName(){
        return this.name;
    }

    /**
     * Method to get the id of the employee from employee payroll data class
     * @return
     * Id of the employee
     */
    public Long getId(){
        return this.id;
    }

    /**
     * Method to return formatted string by override the object class method
     * @return
     * Formatted Object of the Employee payroll data class
     */
    @Override
    public String toString(){
        return "id=" +this.id + ",name=" + this.name + ",salary=" + this.salary;
    }
}
