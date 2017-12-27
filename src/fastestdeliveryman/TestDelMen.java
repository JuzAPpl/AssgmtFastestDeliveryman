/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import ADT.*;

/**
 *
 * @author Ng Pei Xiang
 */
public class TestDelMen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //String empName, String empID, String empIC, char gender, 
        //String contactNo, String address, String password, double salary
        DeliveryMan del = new DeliveryMan("Ali", "S1010", "950123080201", 'F', "0156661234", "Taman Megah", "ABC123", 1500.0);
        
        DeliveryOrder delOrder = new DeliveryOrder(new Order());
        del.setCurrentOrder(delOrder);del.displayMenu();
        
        ListInterface<Location> map = new LinkedList<>();
       
        
    }
    
}
