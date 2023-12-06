package com.bridgelabz.employeepayrollservice;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Employee Payroll Service Class
 */
public class EmployeePayrollService {
    private static final int CLOSE_EMPLOYEE_PAYROLL_SERVICE = 0;
    private static final int READ_FROM_CONSOLE = 1;
    private static final int WRITE_TO_CONSOLE = 2;
    private List<EmployeePayrollData> employeePayrollDataList;
    private Scanner scanner;
    private Path directory;

    /**
     * Constructor of Employee payroll service class which initialize employeepayrolldatalist , scanner
     * and create required directories
     */
    public EmployeePayrollService(){
        this.employeePayrollDataList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        String directoryPath =  "EmployeePayrollServiceDataList";
        Path dir = Path.of(directoryPath);
        this.directory = dir;
        try{
            Files.createDirectories(dir);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Method to provide functionality to user to add the employee data from console and write to console
     */
    public void openEmployeePayrollDataService(){
        System.out.println("Press 1 , to read the employee data from console");
        System.out.println("Press 2 , to write the employee data to console");
        System.out.println("Press 0 , to exit");
        int optionChosen = scanner.nextInt();
        switch (optionChosen){
            case READ_FROM_CONSOLE:
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

    /**
     * Method to read the data from the console and create a new EmployeePayrollData Object
     */
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

    /**
     * Method to write the data from the employeePayrollDataList to console
     */
    private void writeEmployeePayrollData(){
        System.out.println("Writing Employee Payroll data list");
        employeePayrollDataList.forEach(System.out::println);
        this.openEmployeePayrollDataService();
    }

    /**
     * Method to write the employeePayrollDataList to EmployeePayrollDataList directory by creating new file for every object , if it exists then remove the content and adding new content with same id
     */
    public void writeToFile(){
        for (EmployeePayrollData employeePayrollData : employeePayrollDataList) {
            String content = employeePayrollData.toString();
            Path filePath = this.directory.resolve(employeePayrollData.getId().toString() + ".txt");
            try{
                if(!Files.exists(filePath)){
                    Files.createFile(filePath);
                }
                Files.writeString(filePath, content, StandardOpenOption.CREATE, StandardOpenOption.WRITE , StandardOpenOption.TRUNCATE_EXISTING);
                System.out.println("Successfully created the file with id : " + employeePayrollData.getId());
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Successfully completed the writing operation of employeePayrollDataList to files");
    }

    /**
     * Method to read the data from the files existing in the EmployeePayRollListData directory and printing the content of the file
     */
    public void readDataFromFiles(){
        String directoryPath = "EmployeePayrollServiceDataList";
        try (Stream<Path> paths = Files.walk(Paths.get(directoryPath))){
            paths.filter(Files::isRegularFile)
                    .forEach(this::readAndPrintFileContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to print the content of particular file by using the filePath
     * @param filePath
     * File Path , by using it we get the content , fileName and print all the lines existing in the file
     */
    private void readAndPrintFileContent(Path filePath) {
        try {
            System.out.println("File: " + filePath.getFileName());
            System.out.println("Content:");
            try{
                Files.lines(filePath).forEach(System.out::println);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to print the number of files or EmployeePayrollServiceDataList size
     */
    public void countFilesInEmployeePayrollServiceDataList() {
        System.out.println("Number of files in the directory: " + countFilesInDirectory());
    }

    /**
     * Method to count the number of files in the directory
     * @return
     * Count of files in directory
     */
    public long countFilesInDirectory() {
        try (Stream<Path> paths = Files.walk(directory)) {
            return paths.filter(Files::isRegularFile).count();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}