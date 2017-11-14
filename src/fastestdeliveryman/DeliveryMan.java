/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import java.io.BufferedWriter;
import java.io.File;
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

    Calendar cal = Calendar.getInstance();

    public DeliveryMan(String employeeName, String employeeID, String employeePassword, double salary, String contactNo) {
        super(employeeName, employeeID, employeePassword, salary, contactNo);
    }

    public void writeText(String clockInTime){
        try {
           
            File ClockInFile = new File("C:\\Users\\S3113\\Desktop\\ClockIn.txt");

            FileWriter fw = new FileWriter(ClockInFile);
            fw.write(clockInTime);
            fw.close();

        } catch (IOException iox) {
            //do stuff with exception
            iox.printStackTrace();
        }
    }
    
    public void clockIn() {
        String pattern = "yyyy/MM//dd_____hh:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String clockInTime = sdf.format(cal.getTime());
        writeText(clockInTime);

    }

    public void clockOut() {

    }

    public void validation(String ID, String password) {
        if (ID.isEmpty() || password.isEmpty()) {
            System.out.println("Please dont make it blank");
        } else {
            if (ID.equals(employeeID) && password.equals(employeePassword)) {
                clockIn();
            } else if (!ID.equals(employeeID) && !password.equals(employeePassword)) {
                System.out.println("Please Type Again YOur ID & PAssword");
            } else if (!ID.equals(employeeID) && password.equals(employeePassword)) {
                System.out.println("Please Type Again YOur ID");
            } else if (ID.equals(employeeID) && !password.equals(employeePassword)) {
                System.out.println("Please Type Again YOur PAssword");
            }
        }
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
