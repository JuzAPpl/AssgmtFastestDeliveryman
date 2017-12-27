/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import ADT.ADTLinkedListInterface;
import java.util.Scanner;

/**
 *
 * @author Ng Pei Xiang, Chow Swee Tung
 */
public abstract class Employee {

    protected String empName;
    protected String empID;
    protected String empIC;
    protected char gender;
    protected String contactNo;
    protected String address;
    protected String password;
    protected double salary;
    private static Integer currentNo = 1;

    //Empty Constructor for Employee Class
    public Employee() {
    }

    //Parameterized Constructor for Employee Class
    //This constructor is for adding new employee
    public Employee(String empName, String empID, String empIC, char gender,
            String contactNo, String address, double salary) {
        this.empName = empName;
        this.empID = empID;
        this.empIC = empIC;
        this.gender = gender;
        this.contactNo = contactNo;
        this.address = address;
        password = generateDefaultPassword();
        this.salary = salary;
        currentNo++;
    }

    //Parameterized Constructor for Employee class
    //This parameter is for creating existing employee
    public Employee(String empName, String empID, String empIC, char gender,
    String contactNo, String address, String password, double salary) {
        this.empName = empName;
        this.empID = empID;
        this.empIC = empIC;
        this.gender = gender;
        this.contactNo = contactNo;
        this.address = address;
        this.password = password;
        this.salary = salary;
        currentNo++;
    }

    //Static method to generate ID
    public static String generateID() {
        //TODO: Generate and return a new employee id and update 
        return String.format("S%05d", currentNo);
    }

    //Internal method to generate default password
    private String generateDefaultPassword() {
  //TODO: Generate employee's default password by using their identity card
        return empIC;
    }
    
public static Employee loginAccount(ADTLinkedListInterface<Employee>employeeList)
{
        Scanner scanner = new Scanner(System.in);
        boolean found = false;
        Employee target = null;
        int count = 1;

        System.out.println("----WELCOME DELIVERY SYSTEM------");
        System.out.print("LOGIN ID:");
        String userID = scanner.nextLine();
        System.out.print("PASSWORD:");
        String userPassword = scanner.nextLine();

        if (userID.equals("") || userPassword.equals("")) {
            System.out.println("USERID & PASSWORD CANNOT LEFT EMPTY");
            loginAccount(employeeList);

        } else {
            while (!found && employeeList.getEntry(count) != null) {
                if (userID.equals(employeeList.getEntry(count).empID) &&
                  userPassword.equals(employeeList.getEntry(count).password)) {
                    target = employeeList.getEntry(count);
                    found = true;
                } else {
                    count++;
                }
            }
        }
        return target;
    }

    public String toString() {
        return empID + "  " + empName + "   " + empIC +"   "+
                gender+"      "+salary+"     "+contactNo+"   "+address+"\n";
    }
}
