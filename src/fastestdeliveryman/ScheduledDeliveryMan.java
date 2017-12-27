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
public  class ScheduledDeliveryMan extends DeliveryMan {

    public void displaySelection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ScheduledDeliveryMan() {
    }

    public ScheduledDeliveryMan(String empName, String empID, String empIC, char gender, String contactNo, String address, String password, double salary) {
        super(empName, empID, empIC, gender, contactNo, address, password, salary);
    }

    public ScheduledDeliveryMan(String empName, String empID, String empIC, char gender, String contactNo, String address, double salary) {
        super(empName, empID, empIC, gender, contactNo, address, salary);
    }
    
    
    
}
