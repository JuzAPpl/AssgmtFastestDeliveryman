/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author S3113
 */
public class DeliveryMan extends Employee {

    static DeliveryMan deliverman;
    Calendar cal = Calendar.getInstance();
    String getTime;
    String ClockInTime;

    public DeliveryMan(String employeeName, String employeeID, String employeePassword, double salary, String contactNo) {
        super(employeeName, employeeID, employeePassword, salary, contactNo);
    }

    public DeliveryMan() {

    }

    public void getTimeNow() {
        String pattern = "yyyy/MM//dd_____hh:mm:ss";
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
        ClockInTime = getTime;
    }

    public void clockOut() {
        try {
            getTimeNow();
            clockIn();
            File ClockInFile = new File("StatusRecord.txt");

            FileWriter fw = new FileWriter(ClockInFile);
            fw.write(employeeID + " " + employeeName + " " + ClockInTime + " " + getTime);
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
            System.out.println("3. Logout!!!");
            System.out.print("Enter he Number you want to Do: ");
            selection = reader.nextInt();

            if (selection == 1) {
                clockIn();
                System.out.println("You have success to clockIn");
            } else if (selection == 2) {
                clockOut();
                System.out.println("You have success to clockOut");
            }
        } while (selection != 3);
    }

    public void loginDelivery() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Employee ID: ");
        String empID = scan.nextLine();
        System.out.println("Enter Password:");
        String empPASSWORD = scan.nextLine();
        validation(empID, empPASSWORD);

    }

    public static void main(String[] args) {
        deliverman = new DeliveryMan();
        deliverman.loginDelivery();

    }
}
