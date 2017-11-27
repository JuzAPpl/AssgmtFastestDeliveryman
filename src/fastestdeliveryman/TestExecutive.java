/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

/**
 *
 * @author Ng Pei Xiang
 */
public class TestExecutive {

    /**
     * @param args the command line arguments
     */
    private static Employee[] initializeTestDeliveryman(){
   //employeeName, identityCard, gender, age, contactNo, Address, employeeID, employeePassword, salary
        Employee[] deliveryman = 
        {   new DeliveryMan("Abu", "970101063211", 'M', 21, "011234567", "123, Taman Hijau", "E1001", "1234a56", 2000),
            new DeliveryMan("Ali", "960203065119", 'M', 22, "0123456789", "132, Taman Putih", "E1002", "1234b56", 2000),
            new DeliveryMan("Ajib", "980305091027", 'M', 20, "0134567890", "321, Taman Metali", "E1003", "1234c56", 2000)
         
        };
        return deliveryman;
    }
        
    
    public static void main(String[] args) {
        Employee[] deliveryman;
        deliveryman = initializeTestDeliveryman();
        Executive exec = new Executive();
        exec.displayMenu(deliveryman);
    }
    
}
