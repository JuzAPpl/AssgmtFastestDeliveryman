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
    protected String employeeName;
    protected String employeeID;
    protected String employeePassword;
    protected double salary;
    protected String contactNo;
    
       public Employee(){
       this.employeeName="Louis";
       this.employeeID="emp1234";
       this.employeePassword="emp4321";
       this.salary=5000;
       this.contactNo="012-34567";
   }
    
   public Employee(String employeeName, String employeeID,String employeePassword, double salary, String contactNo){
       this.employeeName=employeeName;
       this.employeeID=employeeID;
       this.employeePassword=employeePassword;
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
    public String getEmployeePassword(){
       return employeePassword;    
   }
   public void setEmployeePassword(String employeePassword){
       this.employeePassword=employeePassword;
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
                "\nEmployee Password : "+ employeePassword+
                "\nSalary: " + String.format("%.2f",salary) +
                "\nContact No : " + contactNo;
    }
   

}
