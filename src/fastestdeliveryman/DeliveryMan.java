/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

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
    private String ClockInTime = new String("");
    private String ClockOutTime = new String("");

    public DeliveryMan(String employeeName, String identityCard, char gender, int age, String contactNo, String Address, String employeeID, String employeePassword, double salary) {
        super(employeeName, identityCard, gender, age, contactNo, Address, employeeID, employeePassword, salary);
    }

    public DeliveryMan(String employeeName, String employeeID, String employeePassword, double salary, String contactNo) {
        super(employeeName, employeeID, employeePassword, salary, contactNo);
    }

    public DeliveryMan() {

    }

    public void getTimeNow() {
        cal=Calendar.getInstance();
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

    public void validation(String ID, String password) {
        if (ID.isEmpty() || password.isEmpty()) {
            System.out.println("Please dont make it blank");
        } else {
            if (ID.equals(employeeID) && password.equals(employeePassword)) {
                setSelection();
            } else if (!ID.equals(employeeID) && !password.equals(employeePassword)) {
                System.out.println("Please Type Again YOur ID & PAssword");
                loginDelivery();
            } else if (!ID.equals(employeeID) && password.equals(employeePassword)) {
                System.out.println("Please Type Again YOur ID");
                loginDelivery();
            } else if (ID.equals(employeeID) && !password.equals(employeePassword)) {
                System.out.println("Please Type Again YOur PAssword");
                loginDelivery();
            }
        }
    }

    public void setSelection() {
        int selection = 0;
        Scanner reader = new Scanner(System.in);
        do {
            System.out.println("What Do You Want???");
            System.out.println("1. Clock In");
            System.out.println("2. Clock Out");
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

                }
            }else if(selection == 0){
                
            }
            else{
                System.out.println("Please Type Properly. Try Again");
                 System.out.println("===========================");
            }
        } while (selection != 0);
    }

    public void loginDelivery() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Employee ID: ");
        String empID = scan.nextLine();
        System.out.println("Enter Password:");
        String empPASSWORD = scan.nextLine();
        validation(empID, empPASSWORD);

    }

   
}
