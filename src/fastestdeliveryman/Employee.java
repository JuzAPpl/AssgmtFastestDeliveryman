/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;


/**
 *
 * @author S3113
 */
public class Employee {
    private String employeeName;
    private String employeeID;
    private double salary;
    private String contactNo;
    
    
   public Employee(String employeeName, String employeeID, double salary, String contactNo){
       this.employeeName=employeeName;
       this.employeeID=employeeID;
       this.salary=salary;
       this.contactNo=contactNo;
   }
   
   public String getEmployeeName(){
       return employeeName;    
   }
   public void setEmployeeName(String employeeName){
       this.employeeName=employeeName;
   }
   public String getEmployeeID(){
       return employeeID;
   }
   public void setEmployeeID(String employeeID){
       this.employeeID=employeeID;
   }
    public double getSalary(){
       return salary;
   }
   public void setSalary( double salary){
       this.salary=salary;
   }
    public String getContactNo(){
       return contactNo;
   }
   public void setContactNo(String contactNo){
       this.contactNo=contactNo;
   }
   
   public String toString(){
        return "Employee Name: " + employeeName +
                "\nEmployee ID : " + employeeID +
                "\nSalary: " + String.format("%.2f",salary) +
                "\nContact No : " + contactNo;
    }
}
