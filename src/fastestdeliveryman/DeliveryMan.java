/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import ADT.LinkedList;
import ADT.LinkedQueue;
import ADT.ListInterface;
import ADT.QueueInterface;
import java.util.Scanner;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Chow Swee Tung
 */
public abstract class DeliveryMan extends Employee {
    Timer timer = new Timer(); // use to do the task in set the time
    protected int deliverymanStatus;  //status=1 for available, status=2 for onDelivered, status=3 for break
    protected RoutineRecord currentRoutine = new RoutineRecord();//for clock in & out status
    protected ListInterface<RoutineRecord> routineHistory = new LinkedList<>();
    protected QueueInterface<Order> orderDetails = new LinkedQueue<>();
    protected QueueInterface<Affiliate> restaurantDetails = new LinkedQueue<>();
    protected Order deliveryOrder; 
    protected int location; // there may have 6 station and set as number
    private static int currentActive;
//  private FoodOrder currentOrder;
//  private ListInterface<FoodOrder> orderHistory;

    //Empty constructor for delivery man
    public DeliveryMan() {
    }

    //Parameterized constructor for existing delivery man
    public DeliveryMan(String empName, String empID, String empIC, char gender, String contactNo, String address, String password, double salary) {
        super(empName, empID, empIC, gender, contactNo, address, password, salary);
    }

    //Overloading parameterized constructor for new delivery man
    public DeliveryMan(String empName, String empID, String empIC, char gender, String contactNo, String address, double salary) {
        super(empName, empID, empIC, gender, contactNo, address, salary);
    }

    //display menu after login
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("------>>>MENU<<<---------");
        System.out.println("1. Clock In");
        System.out.println("2. Logout");
        System.out.println("0. Exit system");
        System.out.println("Enter the selection: ");
        int selection = scanner.nextInt();

        switch (selection) {
            case 1:
                //make the status of deliveryman available and clock in.
                deliverymanStatus = 1;
                currentRoutine.clockIn();
                System.out.println("You have successfully clock in at." + currentRoutine.getClockInTime());
                location = setCurrentLocation();
                displaySelection();

                break;
            //back to the login
            case 2:

                break;
            //exit program
            case 0:
                System.out.println("You have successfully exit.");
                System.exit(0);
                break;
            default://check error iput and siplay error message
                System.out.println("Error Input");
                displayMenu();
                break;
        }
    }//TODO: ADD LOGIN

    public int setCurrentLocation() {//use to set deliveryman's location
        Random rand = new Random();
        int n = rand.nextInt(6) + 1;
        //Station 6 is the maximum and the 1 is our minimum 
        return n;

    }

    public int getLocation() {
        return location;
    }

    public void setDeliverymanStatus(int deliverymanStatus) {
        this.deliverymanStatus = deliverymanStatus;
    }

    public int getDeliverymanStatus() {
        return deliverymanStatus;
    }

    //Private method to increase the active number of delivery men
    private static void increaseActive() {
        currentActive++;
    }

    //Private method to decrease the active number of delivery men
    private static void decreaseActive() {
        currentActive--;
    }

    //Return current active delivery men for management purpose
    public static int getCurrentActive() {
        return currentActive;
    }

    public abstract void displaySelection();
}
