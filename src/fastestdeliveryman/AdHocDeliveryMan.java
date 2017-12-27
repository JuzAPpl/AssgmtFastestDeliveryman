/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import ADT.*;
import java.util.Scanner;
import java.util.TimerTask;

/**
 *
 * @author Ng Pei Xiang
 */
public class AdHocDeliveryMan extends DeliveryMan {

    public AdHocDeliveryMan() {
    }

    public AdHocDeliveryMan(String empName, String empID, String empIC, char gender, String contactNo, String address, String password, double salary) {
        super(empName, empID, empIC, gender, contactNo, address, password, salary);
    }

    public AdHocDeliveryMan(String empName, String empID, String empIC, char gender, String contactNo, String address, double salary) {
        super(empName, empID, empIC, gender, contactNo, address, salary);
    }
    
    public String toString(){
        return super.toString();
    }
}
