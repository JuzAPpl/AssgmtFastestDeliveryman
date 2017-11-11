/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class SceduledOrder extends Order {

    private static int[] deliveryDay;
    private static int weeks;

    public void SceduledOrder(String orderNum, Date orderDay, Food[] orderedFood, String location, String affiliateID, int[] deliveryDay, int weeks) {
        super.Order(orderNum, orderDay, orderedFood, location, affiliateID);
        SceduledOrder.deliveryDay = deliveryDay;
        SceduledOrder.weeks = weeks;

    }

    public static void setWeeks(int weeks) {
        SceduledOrder.weeks = weeks;
    }

    public static int getWeeks() {
        return weeks;
    }

    public static void setDeliveryDay(int[] deliveryDay) {
        SceduledOrder.deliveryDay = deliveryDay;
    }

    public static int[] getDeliveryDay() {
        return deliveryDay;
    }

    public static void addSceduledOrder() {
        //TODO: add
        //After User choosed the food in the addOrder in the Order class
        
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
        String[] a = day.split(" ");
        int[] days;
        days = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int b = Integer.parseInt(a[i]);
            if (b != 0) {
                days[i] = b;
            }
            else{
                System.out.println("exit");
                //Do exit back to the menu
            }
        }
        if(!day.equals("")){
            //TODO: get the day(s) that user want to order
            setDeliveryDay(days);
        }
        int week;
        System.out.println("You want make order for how many week(s): ");
        week= scanner.nextInt();
        
        if(week>0){
            //TODO: get how many week the user want to order
            setWeeks(week);
        }
        else{
            System.out.println("Invalid input");
        }

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

}
