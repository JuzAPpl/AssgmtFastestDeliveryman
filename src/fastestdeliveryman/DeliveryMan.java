/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import ADT.LinkedList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author S3113
 */
public class DeliveryMan extends Employee {

    private Calendar cal;
    private String getTime;
    private String ClockInTime = "";
    private String ClockOutTime = new String("");
    private String orderStatus = "null";
    LinkedList<OrderedDelivery> orderDetail = new LinkedList<>();
    OrderedDelivery ordered = new OrderedDelivery("O001", "A001", "F001", "CHEESEBURGER", "C001", "Louis", "2017/12/11 14:55:15", "TAMAN MAD 000");
    OrderedDelivery ordered2 = new OrderedDelivery("O002", "A002", "F002", "PIZZA", "C002", "CHOUYUFONG", "2017/11/11 00:55:15", "TAMAN MD 010");

    public DeliveryMan(String employeeName, String identityCard, char gender, int age, String contactNo, String Address, String employeeID, String employeePassword, double salary) {
        super(employeeName, identityCard, gender, age, contactNo, Address, employeeID, employeePassword, salary);
    }

    public DeliveryMan(String employeeName, String employeeID, String employeePassword, double salary, String contactNo) {
        super(employeeName, employeeID, employeePassword, salary, contactNo);
    }

    public DeliveryMan() {

    }

    public void getTimeNow() {
        cal = Calendar.getInstance();
        String pattern = "yyyy/MM//dd__hh:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        getTime = sdf.format(cal.getTime());

    }

    public void readText() {
        // The name of the file to open.
        String fileName = "StatusRecord.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader
                    = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader
                    = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + fileName + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }

    public void clockIn() {
        getTimeNow();
        ClockInTime = new String(getTime);
        System.out.println("Your work start at" + ClockInTime);
    }

    public boolean checkClockIn() {
        getTimeNow();
        if (!ClockInTime.isEmpty()) {
            System.out.println("You have already clock in.");
            System.out.println("Please Select another Option.");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            return false;
        } else {
            return true;
        }

    }

    public boolean checkClockOut() {
        getTimeNow();
        if (ClockInTime.isEmpty()) {
            System.out.println("You have already clock out.");
            System.out.println("Please Select another Option.");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            return false;
        } else {
            return true;
        }
    }

    public void clockOut() {
        try {
            getTimeNow();
            ClockOutTime = new String(getTime);
            File ClockInFile = new File("StatusRecord.txt");
            FileWriter fw = new FileWriter(ClockInFile, true);
            fw.write(employeeID + " , " + employeeName + " , " + ClockInTime + " , " + ClockOutTime);
            fw.write("\r\n");
            fw.close();

        } catch (IOException iox) {
            //do stuff with exception
            iox.printStackTrace();
        }
    }

    public void displayOrder() {
        
        int selection = 0;
        int choice = 0;
        Scanner reader = new Scanner(System.in);

        do {
            if (ordered.equals("")) {
                System.out.println("There are no order consisted!!!");
            } else {
                System.out.println(">>>>>>>>>>>>>>>ORDER LIST<<<<<<<<<<<<<<<");
                System.out.println("0. Return to Main Menu");
                System.out.print(orderDetail.toString2());
                System.out.print("Enter the Number you want to Take the order: ");
                selection = reader.nextInt();
                if (selection == 1) {
                    if (orderStatus != "pending") {
                        System.out.println("Are you confirm to select?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        choice = reader.nextInt();
                        if (choice == 1) {
                            System.out.println("You have Successfully select this order");
                            orderStatus = "pending";
                        } else if (choice == 2) {
                            displayOrder();
                        }
                    } else {
                        System.out.println("Sorry,You have already selected one order!!!");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        displayMenu();
                    }
                } else if (selection == 2) {
                    if (orderStatus != "pending") {
                        System.out.println("Are you confirm to select?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        choice = reader.nextInt();
                        if (choice == 1) {
                            System.out.println("You have Successfully select this order");
                            orderStatus = "pending";
                        } else if (choice == 2) {
                            displayOrder();
                        }
                    } else {
                        System.out.println("Sorry,You have already selected one order!!!");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        displayMenu();
                    }
                }else if(selection ==0){
                    
                }else{
                    System.out.println("Invalid Input! Please try again!");
                    displayOrder();
                }

            }

        } while (selection != 0);
  
    }

    public void displayMenu() {

        int selection = 0;
        Scanner reader = new Scanner(System.in);
        do {
            System.out.println("------>>>MENU<<<---------");
            System.out.println("1. Clock In");
            System.out.println("2. Clock Out");
            System.out.println("3. Order Selection");
            System.out.println("0. Logout");
            System.out.print("Enter the Number you want to Do: ");
            selection = reader.nextInt();

            if (selection == 1) {
                if (checkClockIn()) {
                    clockIn();
                    System.out.println("You have success to clockIn");
                    System.out.println("===========================");
                }
            } else if (selection == 2) {
                if (checkClockOut()) {
                    clockOut();
                    System.out.println("You have success to clockOut");
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    ClockInTime = "";
                    orderStatus="null";
                }
            } else if (selection == 3) {
                if (ClockInTime == "") {
                    System.out.println("You haven't clock in yet.");
                    System.out.println("|||||||||||||||||||||||||");
                    displayMenu();
                } else {
                    displayOrder();
                }
            } else if (selection == 0) {

            } else {
                System.out.println("Please Type Properly. Try Again");
                System.out.println("===========================");
            }
        } while (selection != 0);
    }

    public void loginDelivery() {
        orderDetail.add(ordered);
        orderDetail.add(ordered2);
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Employee ID: ");
        String empID = scan.nextLine();
        System.out.println("Enter Password:");
        String empPASSWORD = scan.nextLine();

        if (empID.isEmpty() || empPASSWORD.isEmpty()) {
            System.out.println("Please dont make it blank");
        } else {
            if (empID.equals(employeeID) && empPASSWORD.equals(employeePassword)) {
                displayMenu();
            } else if (!empID.equals(employeeID) && !empPASSWORD.equals(employeePassword)) {
                System.out.println("Please Type Again YOur ID & PAssword");
                loginDelivery();
            } else if (!empID.equals(employeeID) && empPASSWORD.equals(employeePassword)) {
                System.out.println("Please Type Again YOur ID");
                loginDelivery();
            } else if (empID.equals(employeeID) && !empPASSWORD.equals(employeePassword)) {
                System.out.println("Please Type Again YOur PAssword");
                loginDelivery();
            }
        }

    }

}
