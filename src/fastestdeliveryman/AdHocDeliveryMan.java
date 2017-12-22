/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import java.util.Scanner;
import java.util.TimerTask;

/**
 *
 * @author Chow Swee Tung
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
       
    
      //start working after clock in
    public void displaySelection() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("------>>>Selection<<<---------");
        System.out.println("1. Take Order");
        System.out.println("2. Rest/Continue");
        System.out.println("3. Clock Out");
        System.out.println("Enter the selection: ");
        int selection = scanner.nextInt();

        switch (selection) {
            case 1:
                if (getDeliverymanStatus() == 1) {
                    System.out.println("Are You confirm to Take It? (Y/N)");
                    char userResponse = scanner.next().charAt(0);
                    userResponse = Character.toUpperCase(userResponse);
                    if (userResponse == 'Y') {
                        setDeliverymanStatus(2);
                        takeOrder();
                        displayOrderMenu();
                    } else if (userResponse == 'N') {
                        setDeliverymanStatus(1);
                        displaySelection();
                    } else {
                        System.out.println("Error Input!!1");
                        displaySelection();
                    }
                } else {
                    System.out.println("Sry!! You are break now!! ");
                    displaySelection();
                }
                break;
            case 2:
                //change the status to break or continue
                if (deliverymanStatus == 2) {//check onDelivery
                    System.out.println("You are still taking delivery order");
                } else {
                    if (deliverymanStatus == 1) {//change the status to break
                        deliverymanStatus = 3;
                        System.out.println("You are rest now");

                    } else {//change the status to availability
                        deliverymanStatus = 1;
                        System.out.println("You are continue to work now");
                    }
                    displaySelection();
                }
                break;
            //clock out and store working time in routineHistory;
            case 3:
                currentRoutine.clockOut();
                System.out.println("You have successfully clock out in " + currentRoutine.getClockOutTime());
                currentRoutine.calWorkingHour();
                routineHistory.add(currentRoutine);
                displayMenu();
                break;
            default:
                System.out.println("Error Input!!1");
                displaySelection();
                break;
        }

    }//TODO MAKE LOGOUT

    public void takeOrder() {
        //        for(int i=0; i<    ;i++){
        //      Location.getLocations().getEntry(1);
        doneOrder();
        displayOrderMenu();

    } //TODO ALMOST NEED TO DO HERE

    public void doneOrder() {

        timer.schedule(new TimerTask() {
            public void run() {
                deliverymanStatus = 1;
                //location=Order.getlocation(); 
                System.out.println("You have complete delivered!!! Now can take new order.");
                displaySelection();
            }
        }, 5000);
    }//TODO:SET LOCATION TO ORDERLOCATION

    public void displayOrderMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(deliveryOrder);
        System.out.println("------>>>ORDERING<<<---------");
        System.out.println("1. Stay Back");
        System.out.println("2. Logout");
        System.out.println("Enter the selection: ");
        int selection = scanner.nextInt();

        switch (selection) {
            case 1: //view the ordered that had taken.
                displayOrderMenu();
                break;
            //back to the login
            case 2:

                break;
            default://check error input
                System.out.println("Error Input");
                displayOrderMenu();
                break;
        }
    }//TODO:MAKE LOGOUT
}
