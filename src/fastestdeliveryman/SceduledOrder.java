/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class SceduledOrder extends Order {

    private int[] deliveryDay;
    private int weeks;

    public SceduledOrder() {

    }

    public SceduledOrder(String orderNum, Date orderDay, Food[] orderedFood, String location, String affiliateID, int[] deliveryDay, int weeks) {
        super(orderNum, orderDay, orderedFood, location, affiliateID);
        this.deliveryDay = deliveryDay;
        this.weeks = weeks;

    }

    public void setWeeks(int weeks) {
        this.weeks = weeks;
    }

    public int getWeeks() {
        return weeks;
    }

    public void setDeliveryDay(int[] deliveryDay) {
        this.deliveryDay = deliveryDay;
    }

    public int[] getDeliveryDay() {
        return deliveryDay;
    }

    public static SceduledOrder addSceduledOrder() {
        //TODO: add
        //After User choosed the food in the addOrder in the Order class

        Order order = Order.addOrder();

        String day;
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Monday");
        System.out.println("2. Tuesday");
        System.out.println("3. Wednesday");
        System.out.println("4. Thurday");
        System.out.println("5. Friday");
        System.out.println("6. Saturday");
        System.out.println("7. Sunday");
        System.out.println("0. Exit");
        System.out.println("Please select the day(s) you want to make order: ");
        day = scanner.nextLine();

        int week;
        System.out.println("You want make order for how many week(s): ");
        week = scanner.nextInt();

        if (day.isEmpty()) {
            System.out.println("Invalid input! Please enter 0-7!");
        } else {
            int a = 0;
            for (int j = 0; j < day.length(); j++) {
                char q = day.charAt(j);
                if (Character.isDigit(q)) {
                    a++;
                }
            }
            int[] days;
            days = new int[a];
            int c = 0;
            for (int k = 0; k < day.length(); k++) {
                char w = day.charAt(k);
                if (Character.isDigit(w)) {
                    days[c] = w;
                    c++;
                }
            }

            if (week > 0) {
                //TODO: Create new object for the sceduled order

                return new SceduledOrder(order.getOrderNum(), order.getOrderDay(), order.getOrderedFood(), order.getLocation(), order.getAffiliateID(), days, week);
            } else {
                System.out.println("Invalid input");
            }

        }
        return null;
    }

    public void cancelSceduledOrder() {
        //TODO: delete
    }

    public void editSceduledOrder() {
        //TODO: edir
    }

    public void checkSceduledOrder() {
        //TODO: check
    }

    public String toString(){
         return "Order No: " + getOrderNum() +
                "\nOrder Day : " + getOrderDay() +
                "\nOrdered Food : "+ getOrderedFood()+
                "\nLocation: " + getLocation()+
                "\nAffiliate ID : " + getAffiliateID()+
                 "\nDelivery Day: "+ deliveryDay+
                 "\nWeek: "+weeks;
  
    }
    public static void addSOToBinaryFile() {
        SceduledOrder SOobject = SceduledOrder.addSceduledOrder();
        try {
            FileOutputStream outFile = new FileOutputStream("SceduledOrder.dat");
            ObjectOutputStream objOutput = new ObjectOutputStream(outFile);
            objOutput.writeObject(SOobject);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SceduledOrder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SceduledOrder.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void readSOInBinaryFile() {
        FileInputStream inFile;
        try {
            inFile = new FileInputStream("SceduledOrder.dat");
            ObjectInputStream objInput = new ObjectInputStream(inFile);
            Object obj = objInput.readObject();
            
            System.out.println("dfd");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SceduledOrder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SceduledOrder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SceduledOrder.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("File is no exist");
        }

    }

}
