/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;


/**
 *
 * @author ChowST & NgPX
 */

public class Employee {
    protected String employeeName;
    protected String identityCard;
    protected char gender;
    protected int age;
    protected String contactNo;
    protected String address;
    protected String employeeID;
    protected String employeePassword;
    protected double salary;

    public Employee(String employeeName, String identityCard, char gender, int age, String contactNo, String Address, String employeeID, String employeePassword, double salary) {
        this.employeeName = employeeName;
        this.identityCard = identityCard;
        this.gender = gender;
        this.age = age;
        this.contactNo = contactNo;
        this.address = Address;
        this.employeeID = employeeID;
        this.employeePassword = employeePassword;
        this.salary = salary;
    }
    
       public Employee(){
       
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

    public String getIdentityCard() {
        return identityCard;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }
   
   public String toString(){
       
        return  "Employee ID : " + employeeID +
                "\nEmployee Name: " + employeeName +
                "\nGender: " + gender +
                "\nAddress: " + address+
                "\nSalary: " + String.format("%.2f",salary) +
                "\nContact No : " + contactNo;
    }
   

}
