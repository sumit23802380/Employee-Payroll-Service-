package com.bridgelabz.employeepayrollservice;
/**
 * Employee Payroll Service Main Class
 */
public class EmployeePayrollServiceMain {
    public static void main(String[] args) {
        System.out.println("Hello , Welcome to Employee Payroll Service Main Class");
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        employeePayrollService.openEmployeePayrollDataService();
        employeePayrollService.readDataFromFiles();
        employeePayrollService.writeToFile();
        employeePayrollService.readDataFromFiles();
    }
}