/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import ADT.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class ScheduledOrder extends Order implements ScheduledOrderInterface {

    private LinkedList<ScheduledOrder> linkedScheduledOrder = new LinkedList<>();
    private String deliveryDate;
    private String deliveryTime;
    private int weeks;
    private Node firstNode;

    public ScheduledOrder() {

    }

    public boolean isEmpty() {
        return (firstNode == null);
    }

    public ScheduledOrder(String orderNum, Date orderDay, Food orderedFood, String location, String affiliateID, String deliveryDate, String deliveryTime, int weeks) {
        super.Order(orderNum, orderDay, null, location, affiliateID);
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
        this.weeks = weeks;

    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public int getWeeks() {
        return weeks;
    }

    public void setWeeks(int weeks) {
        this.weeks = weeks;
    }

    private static final DateFormat dateF = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public String toString2() {
        return "\n============================"
                + "\nScheduledOrder:"
                + "\norderNum= " + orderNum
                + "\norderDay= " + dateF.format(orderDay)
                + "\norderedFood= " + orderedFood
                + "\nlocation= " + location
                + "\naffiliateID= " + affiliateID
                + "\ndeliveryDate= " + deliveryDate
                + "\ndeliveryTime= " + deliveryTime
                + "\nweeks= " + weeks
                + "\n============================\n";
    }

    @Override
    public ScheduledOrderInterface addScheduledOrder() {
        ScheduledOrder s = new ScheduledOrder();

        String day;
        Scanner scanday = new Scanner(System.in);
        System.out.println("\nAdding The Scheduled Order");
        System.out.println("1. Monday");
        System.out.println("2. Tuesday");
        System.out.println("3. Wednesday");
        System.out.println("4. Thurday");
        System.out.println("5. Friday");
        System.out.println("6. Saturday");
        System.out.println("7. Sunday");
        System.out.println("0. Exit");
        System.out.println("Please select the day(s) you want to make order: ");
        day = scanday.nextLine();
        String str1 = "";
        if (day.isEmpty()) {
            System.out.println("Invalid Input");
            addScheduledOrder();
        } else {
            for (int i = 0; i < day.length(); ++i) {
                char days = day.charAt(i);
                if (Character.isDigit(days)) {
                    switch (days) {
                        case '1':
                            str1 += "Monday ";
                            break;
                        case '2':
                            str1 += "Tuesday ";
                            break;
                        case '3':
                            str1 += "Wednesday ";
                            break;
                        case '4':
                            str1 += "Thursday ";
                            break;
                        case '5':
                            str1 += "Friday ";
                            break;
                        case '6':
                            str1 += "Saturday ";
                            break;
                        case '7':
                            str1 += "Sunday ";
                            break;
                        default:
                            System.out.println("Invalid Input");
                            addScheduledOrder();
                            break;
                    }
                }
            }
            s.setDeliveryDate(str1);

            int time;
            Scanner scantime = new Scanner(System.in);

            System.out.println("1. Breakfast(9 am)");
            System.out.println("2. Lunch(12 pm)");
            System.out.println("3. Dinner(7 pm)");
            System.out.println("4. Supper(11 pm)");
            System.out.println("Please select the delivery time: ");
            time = scantime.nextInt();
            String str2 = "";

            switch (time) {
                case 1:
                    str2 += "Breakfast(9 am) ";
                    break;
                case 2:
                    str2 += "Lunch(12 pm) ";
                    break;
                case 3:
                    str2 += "Dinner(7 pm) ";
                    break;
                case 4:
                    str2 += "Supper(11 pm) ";
                    break;
                default:
                    System.out.println("Invalid Input");
                    addScheduledOrder();
                    break;
            }
            s.setDeliveryTime(str2);

            int week;
            Scanner scanweek = new Scanner(System.in);
            System.out.println("You want make order for how many week(s): ");
            week = scanweek.nextInt();
            if (week > 0) {
                s.setWeeks(week);
                UpdateDate(s);
            } else {
                System.out.println("Invalid Input!");
                addScheduledOrder();
            }

        }

        return s;
    }

    public void Continue(ScheduledOrder s) {
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
            Continue(s);
        }
    }

    public void UpdateDate(ScheduledOrder s) {
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
        System.out.println("3. Delivery Date");
        System.out.println("4. Delivery Time");
        System.out.println("5. Delivery for how many week");
        int select;
        Scanner scanselect = new Scanner(System.in);
        System.out.println("Which one did you want to edit?");
        select = scanselect.nextInt();
        if (select == 1) {
            //Food edit
        } else if (select == 2) {
            String local;
            Scanner scanlocal = new Scanner(System.in);
            System.out.println("Please enter the location:");
            local = scanlocal.nextLine();
            if (!local.isEmpty()) {
                s.setLocation(local);
                UpdateDate(s);
                S = s;
                Continue(s);
            } else {
                System.out.println("Invalid Input!");
                editScheduledOrder(s);
            }
        } else if (select == 3) {
            String day;
            Scanner scanday = new Scanner(System.in);

            System.out.println("1. Monday");
            System.out.println("2. Tuesday");
            System.out.println("3. Wednesday");
            System.out.println("4. Thurday");
            System.out.println("5. Friday");
            System.out.println("6. Saturday");
            System.out.println("7. Sunday");
            System.out.println("0. Exit");
            System.out.println("Please select the delivery date(s): ");
            day = scanday.nextLine();
            String str1 = "";
            if (day.isEmpty()) {
                System.out.println("Invalid Input");
                editScheduledOrder(s);
            } else {
                for (int i = 0; i < day.length(); ++i) {
                    char days = day.charAt(i);
                    if (Character.isDigit(days)) {
                        switch (days) {
                            case '1':
                                str1 += "Monday ";
                                break;
                            case '2':
                                str1 += "Tuesday ";
                                break;
                            case '3':
                                str1 += "wednesday ";
                                break;
                            case '4':
                                str1 += "Thursday ";
                                break;
                            case '5':
                                str1 += "Friday ";
                                break;
                            case '6':
                                str1 += "Saturday ";
                                break;
                            case '7':
                                str1 += "Sunady ";
                                break;
                            default:
                                System.out.println("Invalid Input");
                                editScheduledOrder(s);
                                break;
                        }
                    }
                }
                s.setDeliveryDate(str1);
                UpdateDate(s);
            }
            S = s;
            Continue(s);
        } else if (select == 4) {
            int time;
            Scanner scantime = new Scanner(System.in);

            System.out.println("1. Breakfast(9 am)");
            System.out.println("2. Lunch(12 pm)");
            System.out.println("3. Dinner(7 pm)");
            System.out.println("4. Supper(11 pm)");
            System.out.println("Please select the delivery time: ");
            time = scantime.nextInt();

            String str2 = "";

            switch (time) {
                case 1:
                    str2 += "Breakfast(9 am) ";
                    break;
                case 2:
                    str2 += "Lunch(12 pm) ";
                    break;
                case 3:
                    str2 += "Dinner(7 pm) ";
                    break;
                case 4:
                    str2 += "Supper(11 pm) ";
                    break;
                default:
                    System.out.println("Invalid Input");
                    editScheduledOrder(s);
                    break;
            }
            s.setDeliveryTime(str2);
            UpdateDate(s);
            S = s;
            Continue(s);

        } else if (select == 5) {
            int week;
            Scanner scanweek = new Scanner(System.in);
            System.out.println("You want make order for how many week(s): ");
            week = scanweek.nextInt();
            s.setWeeks(week);
            UpdateDate(s);
            S = s;
            Continue(s);
        } else {
            System.out.println("Invalid Input!");
            editScheduledOrder(S);
        }
    }

    public String toString() {
        return "orderNum= " + orderNum
                + ", orderDay= " + dateF.format(orderDay)
                + ", orderedFood= " + orderedFood
                + ", location= " + location
                + ", affiliateID= " + affiliateID
                + ", deliveryDate= " + deliveryDate
                + ", deliveryTime= " + deliveryTime
                + ", weeks= " + weeks + "\n";

    }

    @Override
    public void cancelScheduledOrder() {
        System.out.println("\nScheduled Order Cancelation:");
        System.out.println("\n==============================");

        if (!linkedScheduledOrder.isEmpty()) {
            System.out.println(linkedScheduledOrder.toString2());
            System.out.println("==============================");

            int clear;
            Scanner scanclear = new Scanner(System.in);
            System.out.println("\n1. Cancle all.");
            System.out.println("\n2. Cancel one by one.");
            System.out.println("\n3. Exit");
            System.out.println("\nWhat you want to do?");
            clear = scanclear.nextInt();

            if (clear == 1) {
                String YorN;
                Scanner scanYorN = new Scanner(System.in);
                System.out.println("\nAre you sure to cancel all?(y/n)");
                YorN = scanYorN.nextLine();
                if (YorN.equals("y") || YorN.equals("Y")) {
                    linkedScheduledOrder.clear();
                    Continues();
                } else if (YorN.equals("n") || YorN.equals("N")) {
                    Continues();
                } else {
                    System.out.println("Invalid Input!");
                    Continues();
                }
            } else if (clear == 2) {
                int select;
                Scanner scanselect = new Scanner(System.in);
                System.out.println("\nWhich Scheduled Order want to cancel?(number of the row)");
                select = scanselect.nextInt();

                String YorN;
                Scanner scanYorN = new Scanner(System.in);
                System.out.println("\nAre you sure to cancel the Scheduled Order no." + select + " ?(y/n)");
                YorN = scanYorN.nextLine();

                if (YorN.equals("y") || YorN.equals("Y")) {
                    linkedScheduledOrder.remove(select);
                    System.out.println(linkedScheduledOrder.toString2());
                    Continues();
                } else if (YorN.equals("n") || YorN.equals("N")) {
                    Continues();
                } else {
                    System.out.println("\nInvalid Input!");
                    Continues();
                }
            }else if(clear==3){
                System.out.println("Main Page");
            }else {
                System.out.println("Invalid Input!");
                Continues();
            }
        } else {
            System.out.println("No Scheduled Order!");
        }
    }

    public void Continues() {
        String continues;
        Scanner scancontinues = new Scanner(System.in);
        System.out.println("\nDo you want to continue?(y/n)");
        continues = scancontinues.nextLine();

        if (continues.equals("y") || continues.equals("Y")) {
            cancelScheduledOrder();
        } else if (continues.equals("n") || continues.equals("N")) {

        } else {
            System.out.println("\nInvalid Input!\n");
            Continues();
        }
    }

    @Override
    public void checkScheduledOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        Date date1 = new Date("2017/10/10 12:12:12");
        Date date2 = new Date("2017/11/11 02:12:1");
        Date date3 = new Date("2017/12/10 12:12:12");

        ScheduledOrderInterface s1 = new ScheduledOrder("S001", date1, null, "Taman Bunga Raya", "A001", "Monday", "Breakfirst(9.00am)", 5);
        ScheduledOrderInterface s2 = new ScheduledOrder("S002", date2, null, "Taman Melawati", "A002", "Friday", "Breakfirst(9.00am)", 7);
        ScheduledOrderInterface s3 = new ScheduledOrder("S003", date3, null, "Taman Tarc", "A003", "Friday", "Lunch(12.00pm)", 3);

        ScheduledOrder so = new ScheduledOrder();
        so.adding(s1);
        so.adding(s2);
        so.adding(s3);
        so.cancelScheduledOrder();

    }

    
    public void adding(ScheduledOrderInterface S) {
        ScheduledOrder s = new ScheduledOrder();
        s = (ScheduledOrder) S;
        linkedScheduledOrder.add(s);
    }
}

//yyyy/MM/dd HH:mm:ss
//public void addtoNode(ScheduledOrderInterface S);