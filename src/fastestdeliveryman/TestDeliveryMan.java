/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import ADT.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author S3113
 */
public class TestDeliveryMan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // OrderedDelivery(String OrderedID, String affillateID, String foodID, String custID, String custName, Date orderedDate, String address) {       
        //"yyyy/MM/dd HH:mm:ss
      
        DeliveryMan deliver = new AdHocDeliveryMan();
        deliver.displayMenu();
             
                
      //  DeliveryMan deliver = new DeliveryMan("Abu", "970101063211", 'M', 21, "011234567", "123, Taman Hijau", "E1001", "a1234", 2000);
     //   deliver.loginDelivery();
    }

}
