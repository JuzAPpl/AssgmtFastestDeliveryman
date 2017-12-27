/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import ADT.ListInterface;
import ADT.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Ng Pei Xiang
 */
public class DeliveryMan extends Employee{
    private final static int STATUS_UNAVAILABLE = 0;
    private final static int STATUS_AVAILABLE = 1;
    private final static int STATUS_DELIVERY = 2;
    private final static int STATUS_BREAK = 3;
    private static int currentActive = 0;
     private int completeDO = 0;
    
    private int status;
    private RoutineRecord currentRoutine;
    private ListInterface<RoutineRecord> routineHistory = new LinkedList<>();
    private DeliveryOrder currentOrder;
    private ListInterface<DeliveryOrder> deliveryJobHistory = new LinkedList<>();
    private Location currentLocation;
  
    
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
    
    public void displayMenu(){
        String title = "";
        if(gender =='M'){
            title = "Mr. " + empName;
        }else if(gender =='F'){
            title = "Ms. " + empName;
        } 
        System.out.println("Welcome, " + title);
        if(currentRoutine == null){
            displayMenuBeforeClockIn();
        }else{
            displayMenuAfterClockIn();
        }
            
        
    }

    private void displayMenuAfterClockIn() {
        Scanner selScanner = new Scanner(System.in);
        boolean cont = true;
        do{  
            promptSelectionAfterClockIn();
            int sel = selScanner.nextInt();
            switch(sel){
                case 1:displayCurrentOrder(); 
                    break;
                case 2: startDelivery();
                    break;
                case 3: verifyDelivery();
                    break;
                case 4: requestForDelivery();
                case 5: restOrResume();
                    break;
                case 6: clockOut();                   
                    break;
                case 0: cont = false;
                    break;
                default: System.out.println("Invalid selection.");
                break;
            }
        }while(cont);
    }

    private void promptSelectionAfterClockIn() {
        System.out.println("Please choose an action to continue:");
        System.out.println("1. View current delivery order");
        System.out.println("2. Accept and send current delivery");
        System.out.println("3. Verify and finish current delivery");
        System.out.println("4. Request for next delivery");
        System.out.println("5. Have a break/Resume work");
        System.out.println("6. Clock out");
        System.out.println("0. Exit");
        System.out.print("Your selection: ");
    }

    private void displayMenuBeforeClockIn() {
        Scanner selScanner = new Scanner(System.in);       
        boolean cont = true;
        do{ 
            promptSelectionBeforeClockIn();
            int sel = selScanner.nextInt();
            switch(sel)
            {
                case 1: clockIn();                        
                break;
                case 2: displayDeliveryHistory();
                break;
                case 3: displayRoutineHistory();
                break;
                case 4: displayMenuAfterClockIn();
                case 0: cont = false;
                    break;
                default: System.out.println("Invalid selection.\n");
                    break;
            }
        }while(cont);
    }

    private void promptSelectionBeforeClockIn() {
        System.out.println("Please choose an action to continue:");
        System.out.println("1. Clock In");
        System.out.println("2. View delivery history");
        System.out.println("3. View routine history");
        System.out.println("4. Manage my current routine");
        System.out.println("0. Exit");
        System.out.print("Your selection: ");
    }

    /**
     * A method to allow delivery man to clock in and record their clock in time
     * Last edited: 25/12/2017
     * Last edited by: Ng Pei Xiang
     */
    public void clockIn(){
        if(currentRoutine == null){
            currentRoutine = new RoutineRecord();
            currentRoutine.logClockInTime();
            status = STATUS_AVAILABLE;
            increaseActive();
            System.out.println("Clocked in successful at " + currentRoutine.getClockInTime()+ "\n");
        }else{
            System.out.println("You've already clocked in today!\n");
        }
        
    }
    
    /**
     * A method to allow delivery man to clock out and record their clock out time
     * Last edited: 25/12/2017
     * Last edited by: Ng Pei Xiang
     */
    public void clockOut(){
        if(currentRoutine != null){
            currentRoutine.logClockOutTime();
            status = STATUS_UNAVAILABLE;
            decreaseActive();
            routineHistory.add(currentRoutine);            
            System.out.println("Clocked out successful at " + currentRoutine.getClockOutTime() + "\n");
            currentRoutine = null;
        }else{
            System.out.println("Sorry, you're not clocked in!\n");
        }
    }
    
    public void restOrResume(){
        switch(status){
            case STATUS_AVAILABLE: status = STATUS_BREAK; decreaseActive();
                System.out.println("Enjoy your resting time!");
                break;
            case STATUS_BREAK: status = STATUS_AVAILABLE; increaseActive();
                System.out.println("Welcome back, " + empName + "\n");
                break;
        }
    }
    
    public void displayCurrentOrder(){
        if (currentOrder != null){
             System.out.println(currentOrder);
        } else{
            System.out.println("You don't have any delivery job yet.\n");
        }
    }
    
    public String getCurrentOrderDetails(){
        String orderDetails = "";
        if(currentOrder!=null){
            orderDetails = currentOrder.toDetailsString();
        }else{
            orderDetails = "No order details detected.\n";
        }
        return orderDetails;
    }
    
    public DeliveryOrder getCurrentOrder(){
        return currentOrder;
    }
    public void setCurrentOrder(DeliveryOrder currentOrder){
        this.currentOrder = currentOrder;
    }
    
    private void startDelivery(){
        if(status == STATUS_AVAILABLE){
            currentOrder.startDelivery();
            status = STATUS_DELIVERY;
            System.out.println("You just started a delivery order. Please get verification code from the customer when you reached.");
        }else{
            System.out.println("You don't have any delivery job now.\n");
        }
        
        
    }
    private void verifyDelivery() {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false, cont = false;
        do{
            System.out.println("\nPlease get the verification code from customer: ");
            String code = scanner.nextLine();
            if(currentOrder.verifyDelivery(code)){
                deliveryJobHistory.add(currentOrder);
                 completeDO++;
                status = STATUS_AVAILABLE;
                System.out.println("\nSuccessful! The delivery order is delivered and verified!\n\n");
                System.out.println(currentOrder.toString());
                currentLocation = currentOrder.getDestination();
                currentOrder = null;
                
            }else{
                char yesNo;
                do{
                    System.out.println("Do you want to continue?(Y/N)");
                    yesNo = scanner.nextLine().charAt(0);
                    yesNo = Character.toUpperCase(yesNo);
                    switch (yesNo){
                        case 'Y': cont = true;
                        case 'N': cont = false;
                        default:System.out.println("Invalid selection.\n");
                    }
                }while(yesNo!='Y'&&yesNo!='N');
            }

        }while(!valid && cont);
        
    }
    private void requestForDelivery() {
        currentOrder = currentLocation.assignDeliveryOrder();
    }
      
    /**
     *
     * @return delivery man status in String
     * A method to track delivery man's status
     * Last edited: 25/12/2017
     * Last edited by: Ng Pei Xiang
     */
    public String getDeliveryManStatus(){
        String deliverymanStatus = "Status: ";
        switch (status){
            case STATUS_UNAVAILABLE: deliverymanStatus += "Unavailable"; 
                    break;
            case STATUS_AVAILABLE: deliverymanStatus += "Available"; 
                    break;
            case STATUS_DELIVERY: deliverymanStatus += "On Delivery"; 
                    break;
            case STATUS_BREAK: deliverymanStatus += "On Break"; 
                    break;
            default: deliverymanStatus += "Error";
                    break;
        }
        return deliverymanStatus;
    }
    
    /**
     * A method to display history of delivery job
     * Last edited: 25/12/2017
     * Last edited by: Ng Pei Xiang
     */
    public void displayDeliveryHistory(){
        System.out.println("\n---------------");
        System.out.println("Delivery History");
        System.out.println("---------------");
        System.out.println(deliveryJobHistory.toString());
    }
    
    public void displayRoutineHistory(){
        System.out.println("\n---------------");
        System.out.println("Routine History");
        System.out.println("---------------\n");
        System.out.printf("%-20s %-20s %-20s %-20s\n", "Date", "Clock In Time", "Clock Out Time", "Total Working Hour");
        for(int i =1; i<=routineHistory.getNumberOfEntries(); i++){
            System.out.println(routineHistory.getEntry(i).toString());
        }
        
    }
    
    //Private method to increase the active number of delivery men
    private static void increaseActive(){
        currentActive++;
    }
    
    //Private method to decrease the active number of delivery men
    private static void decreaseActive(){
        currentActive--;
    }
    
    //Return current active delivery men for management purpose
    public static int getCurrentActive(){
        return currentActive;
    }
        public void setCompleteDO(int num) {
        this.completeDO = num;
    }

    public int getCompleteDO() {
        return completeDO;
    }
}
