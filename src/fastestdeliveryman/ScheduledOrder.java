/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import ADT.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class ScheduledOrder extends Order implements ScheduledOrderInterface {

    private ScheduledOrderList<ScheduledOrder> linkedScheduledOrder = new ScheduledOrderList<>();
    private int totalDays;
    private Date startDate;
    private Date deliveryTime;
    private Node firstNode;

    public ScheduledOrder() {

    }

    public boolean isEmpty() {
        return (firstNode == null);
    }

    public ScheduledOrder(Date orderDay, Food[] orderedFood, String location, String affiliateID, int totalDays, Date startDate, Date deliveryTime) {
        super(orderDay, orderedFood, location, affiliateID);
        this.totalDays = totalDays;
        this.startDate = startDate;
        this.deliveryTime = deliveryTime;

    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    private static final DateFormat dateF = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public String toString() {
        String strDate = startDate.toString() + " " + deliveryTime.toString();
        return String.format("%5d\t%20s\t%20s\t%20s\t5d\n", orderNum, orderedFood, location, strDate, totalDays);
    }

    public int getInputDays(int day) {
        int num;
        String str = "";
        Scanner scanday = new Scanner(System.in);
        switch (day) {
            case 1:
                str += "day(s)";
                break;
            case 2:
                str += "week(s)";
                break;
            case 3:
                str += "month(s)";
                break;
            case 0:
                break;
            default:
        }
        System.out.println("\nHow many " + str + "did you want to make delivery order?");
        num = scanday.nextInt();
        return num;
    }

    @Override
    public ScheduledOrderInterface addScheduledOrder() {
        ScheduledOrder s = new ScheduledOrder();

        //Food Ordering
        //Select deliveryDays
        int day;
        Scanner scanday = new Scanner(System.in);
        System.out.println("\nAdding The Scheduled Order");
        System.out.println("1. Daily");
        System.out.println("2. Weekly");
        System.out.println("3. Monthly");
        System.out.println("0. Exit");
        System.out.println("Please select the day(s) you want to make order: ");
        day = scanday.nextInt();
        int deliveryDay = 0;
        switch (day) {
            case 1:
                deliveryDay = s.getInputDays(day);
                break;
            case 2:
                deliveryDay = s.getInputDays(day) * 7;
                break;
            case 3:
                deliveryDay = s.getInputDays(day) * 28;
                break;
            case 0:
                //back to ScheduledOrder Menu;
                break;
            default:
            //prompt error message and ask to continue or not
        }
        if (deliveryDay > 0) {
            s.setTotalDays(deliveryDay);
        }
        //Get time of delivery
        DateFormat date = new SimpleDateFormat("hh:mm:ss");
        int time;
        Scanner scantime = new Scanner(System.in);
        System.out.println("\n1. Breakfast(9 am)");
        System.out.println("2. Lunch(12 pm)");
        System.out.println("3. Dinner(7 pm)");
        System.out.println("4. Supper(10 pm)");
        System.out.println("5. Other");
        System.out.println("Please select the delivery time: ");
        time = scantime.nextInt();
        String str = "";

        switch (time) {
            case 1:
                str += "09:00:00";
                break;
            case 2:
                str += "12:00:00";
                break;
            case 3:
                str += "19:00:00";
                break;
            case 4:
                str += "22:00:00";
                break;
            case 5:
                System.out.println("Please delivery time in format of (hh:mm:ss): ");
                Scanner scanstr = new Scanner(System.in);
                str = scanstr.nextLine();
                break;
            default:
                System.out.println("Invalid Input");
                //ask to continue or not
                break;
        }
        Date deliverTime = null;
        try {
            deliverTime = date.parse(str);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (deliverTime != null) {
            //setdeliveryTime
            s.setDeliveryTime(deliverTime);
        }

        //Gat the start date of delivery order
        System.out.println("\nStart Time:");
        System.out.println("1. Start Tomorow");
        System.out.println("2. Other");
        System.out.println("Choose the day to start the delivery: ");
        int start;
        Scanner scanstart = new Scanner(System.in);
        start = scantime.nextInt();
        DateFormat startDate = new SimpleDateFormat("yyyy/MM/dd");
        Date today = new Date();
        Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
        String str1 = "";
        switch (start) {
            case 1:
                str1 = startDate.format(tomorrow);
                break;
            case 2:
                System.out.println("\nPlease enter the start day for delivery in format of (yyyy/MM/dd): ");
                Scanner scanstr = new Scanner(System.in);
                str1 = scanstr.nextLine();
                break;
            default:
        }
        Date startDeliver = null;
        try {
            startDeliver = startDate.parse(str1);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (startDeliver != null) {
            //setStartDelivery
            s.setStartDate(startDeliver);
        }

        if (s != null) {

        }
        linkedScheduledOrder.addNew(s);

        return s;
    }

    public void continueAddScheduledOrder(ScheduledOrder s) {
        String con;
        Scanner scancon = new Scanner(System.in);
        System.out.println("Do you want to continue?(y/n)");
        con = scancon.nextLine();

        if (con.equals("Y") || con.equals("y")) {
            editScheduledOrder(s);
        } else if (con.equals("N") || con.equals("n")) {
            System.out.println(s.toString());
        } else {
            System.out.println("Invalid Input!");
            continueAddScheduledOrder(s);
        }
    }

    public void updateDate(ScheduledOrder s) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        s.setOrderDay(date);
    }

    @Override
    public void editScheduledOrder(ScheduledOrderInterface S) {
        ScheduledOrder s = new ScheduledOrder();
        s = (ScheduledOrder) S;

        System.out.println("\nEdit The Scheduled Order");
        System.out.println("1. Food");
        System.out.println("2. Location");
        System.out.println("3. Delivery Time");
        System.out.println("0. Exit");
        int select;
        Scanner scanselect = new Scanner(System.in);
        System.out.println("Which one did you want to edit?");
        select = scanselect.nextInt();
        if (select == 1) {
            //Food edit
        } else if (select == 2) {
            //Location edit
            String local;
            Scanner scanlocal = new Scanner(System.in);
            System.out.println("Please enter the location:");
            local = scanlocal.nextLine();
            if (!local.isEmpty()) {
                s.setLocation(local);
                S = s;
                continueAddScheduledOrder(s);
            } else {
                System.out.println("Invalid Input!");
                editScheduledOrder(s);
            }
        } else if (select == 3) {
            //DeliveryTime edit
            DateFormat date = new SimpleDateFormat("hh:mm:ss");
            int time;
            Scanner scantime = new Scanner(System.in);
            System.out.println("\n1. Breakfast(9 am)");
            System.out.println("2. Lunch(12 pm)");
            System.out.println("3. Dinner(7 pm)");
            System.out.println("4. Supper(10 pm)");
            System.out.println("5. Other");
            System.out.println("Please select the delivery time: ");
            time = scantime.nextInt();
            String str = "";

            switch (time) {
                case 1:
                    str += "09:00:00";
                    break;
                case 2:
                    str += "12:00:00";
                    break;
                case 3:
                    str += "19:00:00";
                    break;
                case 4:
                    str += "22:00:00";
                    break;
                case 5:
                    System.out.println("Please delivery time in format of (hh:mm:ss): ");
                    Scanner scanstr = new Scanner(System.in);
                    str = scanstr.nextLine();
                    break;
                default:
                    System.out.println("Invalid Input");
                    //ask to continue or not
                    break;
            }
            Date deliverTime = null;
            try {
                deliverTime = date.parse(str);

            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (deliverTime != null) {
                //setdeliveryTime
                s.setDeliveryTime(deliverTime);
            }
            if (s != null) {
                S = s;
                continueAddScheduledOrder(s);
            }
        } else if (select == 0) {
            //edit to ScheduledOrder Menu
        } else {
            System.out.println("Invalid Input!");
            editScheduledOrder(S);
        }
    }

    @Override
    public void cancelScheduledOrder() {
        System.out.println("\nScheduled Order Cancelation:");
        System.out.println("\n==============================");

        if (!linkedScheduledOrder.isEmpty()) {
            System.out.println(linkedScheduledOrder.displaySchduledOrders());
            System.out.println("==============================");

            int clear;
            Scanner scanclear = new Scanner(System.in);
            System.out.println("\n1. Cancle all.");
            System.out.println("\n2. Cancel one by one.");
            System.out.println("\n0. Exit");
            System.out.println("\nWhat you want to do?");
            clear = scanclear.nextInt();

            if (clear == 1) {
                String YorN;
                Scanner scanYorN = new Scanner(System.in);
                System.out.println("\nAre you sure to cancle all?(y/n)");
                YorN = scanYorN.nextLine();
                if (YorN.equals("y") || YorN.equals("Y")) {
                    linkedScheduledOrder.clear();
                    continueCancelation();
                } else if (YorN.equals("n") || YorN.equals("N")) {
                    continueCancelation();
                } else {
                    System.out.println("Invalid Input!");
                    continueCancelation();
                }
            } else if (clear == 2) {
                int select;
                Scanner scanselect = new Scanner(System.in);
                System.out.println("\nWhich Scheduled Order want to cancel?(number of the row)");
                select = scanselect.nextInt();

                String confirmation;
                Scanner scanYorN = new Scanner(System.in);
                System.out.println("\nAre you sure to cancel the Scheduled Order no." + select + " ?(y/n)");
                confirmation = scanYorN.nextLine();

                if (confirmation.equals("y") || confirmation.equals("Y")) {
                    linkedScheduledOrder.remove(select);
                    System.out.println(linkedScheduledOrder.displaySchduledOrders());
                    continueCancelation();
                } else if (confirmation.equals("n") || confirmation.equals("N")) {
                    continueCancelation();
                } else {
                    System.out.println("\nInvalid Input!");
                    continueCancelation();
                }
            } else if (clear == 0) {
                //display ScheduledOrder Menu
                System.out.println("Main Page");
            } else {
                System.out.println("Invalid Input!");
                continueCancelation();
            }
        } else {
            System.out.println("No Scheduled Order!");
        }
    }

    public void continueCancelation() {
        String continues;
        Scanner scancontinues = new Scanner(System.in);
        System.out.println("\nDo you want to continue?(y/n)");
        continues = scancontinues.nextLine();

        if (continues.equals("y") || continues.equals("Y")) {
            cancelScheduledOrder();
        } else if (continues.equals("n") || continues.equals("N")) {

        } else {
            System.out.println("\nInvalid Input!\n");
            continueCancelation();
        }
    }

    @Override
    public void checkScheduledOrder() {
        //For restuarant uses, check the daily ScheduledOrder.
        ScheduledOrderList<ScheduledOrder> currentScheduledOrder = new ScheduledOrderList<>();
        ScheduledOrder s = new ScheduledOrder();
        Date today = new Date();
        if (!linkedScheduledOrder.isEmpty()) {
            for (int i = 1; i < linkedScheduledOrder.countNode(linkedScheduledOrder.getFirstNode()); ++i) {
                s = (ScheduledOrder) linkedScheduledOrder.getObject(i);
                if (s.startDate.compareTo(today) == 0) {
                    currentScheduledOrder.addNew(s);
                }
            }
            if (!currentScheduledOrder.isEmpty()) {
                currentScheduledOrder.displaySchduledOrders();
            }
        }
    }

    public static void main(String[] args) {

        ScheduledOrderList<ScheduledOrder> so = new ScheduledOrderList<>();

    }

}
