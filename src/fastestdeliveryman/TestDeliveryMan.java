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
import java.util.Scanner;

/**
 *
 * @author Chow Swee Tung
 */
public class TestDeliveryMan {

    public static void main(String[] args) {

        ADTLinkedListInterface<Employee> employeeList = new ADTLinkedList<>();
        //test assign for executive
        Executive test = new Executive(1000.0, "A101", "EEE", "1234", "0000",
                'M', "12341213", "asdasd", "0000", 1000.0);
        //emp assign for 2 types of Deliveryman
        DeliveryMan emp1 = new AdHocDeliveryMan("Louis ", "S00009", 
                "111111111111", 'F', "8323147983", "RIP ", "1111", 900.0);
        DeliveryMan emp2 = new AdHocDeliveryMan("DING ", "S00109", 
                "222222222222", 'M', "8323147983", "RIEPER ", "2222", 950.0);
        Executive test2 = new Executive(1000.0, "A101", "AAA", "1235", "0001",
                'M', "12341213", "asdasd", "0000", 1000.0);
        DeliveryMan emp3 = new ScheduledDeliveryMan("Dang ", "S00119", 
                "333333333333", 'M', "8323147983", "RESP KING", "4444", 950.0);
        DeliveryMan emp4 = new ScheduledDeliveryMan("NEWAS ", "S00819", 
                "44444444444", 'M', "8363147983", "RESP Fota", "3333", 1000.0);
        DeliveryMan del = new AdHocDeliveryMan("Ali", "S10100", "950123080201",
                'F', "0156661234", "Taman Megah", "ABC123", 1500.0);
       
  //delivery order      
        DeliveryOrder delOrder = new DeliveryOrder(new Order());
        DeliveryOrder delOrder2 = new DeliveryOrder(new Order());
 //assign deliveryorder to deliveryman    
        del.setCurrentOrder(delOrder);
        emp4.setCompleteDO(5);
        emp4.getCompleteDO();
        emp1.setCompleteDO(3);
        emp1.getCompleteDO();

 // add employee into list       
        employeeList.add(emp1);
        employeeList.add(test);
        employeeList.add(emp2);
        employeeList.add(test2);
        employeeList.add(emp3);
        employeeList.add(emp4);
        employeeList.add(del);
        
  // to allow current user login depends their own identity      
        boolean cont = true;
        do {
            Employee currentUser = Employee.loginAccount(employeeList);
            if (currentUser != null) {
                if (currentUser instanceof Executive) {
                    ((Executive) currentUser).displayMenu(employeeList);
                } else if (currentUser instanceof DeliveryMan) {
                    ((DeliveryMan) currentUser).displayMenu();
                }
            } else {
                System.out.println("No user is detected!");
            }
            Scanner scanner = new Scanner(System.in);
            char yesNo;
            do {
                System.out.print("Continue?(Y/N)");
                yesNo = scanner.next().charAt(0);
                yesNo = Character.toUpperCase(yesNo);
                switch (yesNo) {
                    case 'Y':
                        cont = true;
                        break;
                    case 'N':
                        cont = false;
                        break;
                    default:
                        System.out.println("Invalid input.");
                        break;
                }
            } while (yesNo != 'Y' && yesNo != 'N');
        } while (cont);
        System.out.println("See you");
        System.exit(0);

    }

}
