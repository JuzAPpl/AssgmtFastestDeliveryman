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
public class Executive extends Employee implements Management{
    
    
    public Executive(String employeeName, String employeeID, double salary, String contactNo) {
        super(employeeName, employeeID, salary, contactNo);
    }
    
    public void addStaff(){
        //TODO:Add new staff.
    }
    
    public void terminateStaff(){
        //TODO:Remove terminated staff
    }
}
