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
 * @author User
 */
public class ScheduledOrder extends Order implements ScheduledOrderInterface {

    private String deliveryDate;
    private String deliveryTime;
    private int weeks;

    public ScheduledOrder() {

    }

    public ScheduledOrder(String orderNum, Date orderDay, Food[] orderedFood, String location, String affiliateID, String deliveryDate, String deliveryTime, int weeks) {
        super.Order(orderNum, orderDay, orderedFood, location, affiliateID);
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

    @Override
    public String toString() {
        return "\n============================"
                + "\nScheduledOrder:"
                + "\norderNum= " + orderNum
                + "\norderDay= " + orderDay
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
        Date date = new Date();
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

    @Override
    public void cancelScheduledOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void checkScheduledOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        ScheduledOrderInterface s1 = new ScheduledOrder();
        s1 = s1.addScheduledOrder();
        s1.editScheduledOrder(s1);
    }
}
