package com.bridgelabz.employeepayrollservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
    private static final int CLOSE_EMPLOYEE_PAYROLL_SERVICE = 0;
    private static final int READ_FROM_HANDLE = 1;
    private static final int WRITE_TO_CONSOLE = 2;
    private List<EmployeePayrollData> employeePayrollDataList;
    private Scanner scanner;
    public EmployeePayrollService(){
        this.employeePayrollDataList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void openEmployeePayrollDataService(){
        System.out.println("Press 1 , to read the employee data from console");
        System.out.println("Press 2 , to write the employee data to console");
        System.out.println("Press 0 , to exit");
        int optionChosen = scanner.nextInt();
        switch (optionChosen){
            case READ_FROM_HANDLE :
                this.readEmployeePayrollData();
                break;
            case WRITE_TO_CONSOLE:
                this.writeEmployeePayrollData();
                break;
            case CLOSE_EMPLOYEE_PAYROLL_SERVICE:
                return;
            default:
                System.out.println("Please press valid key");
        }
    }

    private void readEmployeePayrollData(){
        System.out.println("Enter Employee Id :");
        Long id = scanner.nextLong();
        System.out.println("Enter Employee Name :");
        String name = scanner.next();
        System.out.println("Enter Employee Salary :");
        Double salary = scanner.nextDouble();
        this.employeePayrollDataList.add(new EmployeePayrollData(id , name , salary));
        this.openEmployeePayrollDataService();
    }
    private void writeEmployeePayrollData(){
        System.out.println("Writing Employee Payroll data list");
        employeePayrollDataList.forEach(System.out::println);
        this.openEmployeePayrollDataService();
    }
}
