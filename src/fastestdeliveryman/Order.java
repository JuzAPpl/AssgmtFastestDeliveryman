/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import ADT.LinkedList;
import ADT.ListWithIteratorInterface;
import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author Gan Zhen Jie
 */
public class Order implements Comparable<Order>, Serializable {

    public static final int ADHOC_PENDING = 1;
    public static final int ADHOC_STARTED = 2;
    public static final int ADHOC_COMPLETE = 3;

    public static final int SCH_PENDING = 21;
    public static final int SCH_STARTED_INCOMPLETE = 23;
    public static final int SCH_STARTED_COMPLETE = 23;
    public static final int SCH_COMPLETE = 24;

    private static int newNum = 0;
    
    protected String orderNum;
    protected ListWithIteratorInterface<Food> orderedFood;
    protected Date orderDay;
    protected Location destination;
    protected String customerName;
    protected String customerPhoneNo;
    protected int status;

    public Order() {
        this.orderNum = "S" + String.format("%06d", newNum);
        newNum++;
    }

    public Order(Date orderDay, ListWithIteratorInterface<Food> orderedFood, Location destination, int status) {
        this.orderNum = "S" + String.format("%06d", newNum);
        this.orderDay = orderDay;
        this.destination = destination;
        this.orderedFood = orderedFood;
        this.status = status;
        newNum++;
    }
    
    public Order(Date orderDay, ListWithIteratorInterface<Food> orderedFood, Location destination, String customerName, String customerPhoneNo, int status) {
        this.orderNum = "S" + String.format("%06d", newNum);
        this.orderDay = orderDay;
        this.destination = destination;
        this.orderedFood = orderedFood;
        this.customerName = customerName;
        this.customerPhoneNo = customerPhoneNo;
        this.status = status;
        newNum++;
    }

    public static Order addOrder() {
        return new Order();
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderDay(Date orderDay) {
        this.orderDay = orderDay;
    }

    public Date getOrderDay() {
        return orderDay;
    }

    public void setOrderedFood(LinkedList<Food> orderedFood) {
        this.orderedFood = orderedFood;
    }

    public LinkedList<Food> getOrderedFood() {
        return (LinkedList<Food>) orderedFood;
    }

    public String toString() {
        String orderDetail = "";
        for (int i = 0; i < orderedFood.getNumberOfEntries(); i++) {
            orderDetail += "";
        }

        return orderDetail;
    }

    public static Order newOrder(ListWithIteratorInterface<Food> foods) {
        ListWithIteratorInterface<Food> orderedFood;
        Date orderDay;
        Location destination;
        int status;
        //orderedFood = list provided in parameter
        orderedFood = foods;
        //retrieve destination from user input(+address & time for scheduled order)
        destination = Location.getLocation();
        //order date=current time by default
        orderDay = new Date();
        //status = pending by default(ad-hoc order)
        status = ADHOC_PENDING;
        
        
        return new Order(orderDay, orderedFood, destination, status);
    }
    
    public static Order newOrderWithCustomerInfo(ListWithIteratorInterface<Food> foods) {
        ListWithIteratorInterface<Food> orderedFood;
        Date orderDay;
        Location destination;
        int status;
        //orderedFood = list provided in parameter
        orderedFood = foods;
        //retrieve destination from user input(+address & time for scheduled order)
        destination = Location.getLocation();
        //order date=current time by default
        orderDay = new Date();
        //status = pending by default(ad-hoc order)
        status = ADHOC_PENDING;
        
        
        return new Order(orderDay, orderedFood, destination, status);
    }

    public double getPreparationTime() {
        //return largest preparation time in ordered food collection
        Iterator it = orderedFood.getIterator();
        double largestPreparationTime = -1;
        while (it.hasNext()) {
            Food currentFood = (Food) it.next();
            double prepTime = currentFood.getPreparationTime();
            if (prepTime > largestPreparationTime) {
                largestPreparationTime = prepTime;
            }
        }
        return largestPreparationTime;
    }

    public double getDeliveryTime() {
        //affiliate location vs destination
        Affiliate aff = orderedFood.getEntry(1).getFoodOwner();
        Location temp = aff.getAddress();
        return destination.getTravelTime(temp);
    }

    public Date getArrivalTime() {
        Date currentTime = new Date();
        currentTime.setTime(currentTime.getTime() + (long) (getPreparationTime() * 1000) + (long) (getDeliveryTime() * 1000));
        return currentTime;
    }

    @Override
    public int compareTo(Order anotherOrder) {
        //compare order finish time(preparationTime
        double timeDiff = getPreparationTime() - anotherOrder.getPreparationTime();
        if (timeDiff > 0) {
            return 1;
        } else if (timeDiff < 0) {
            return -1;
        } else {
            return 0;
        }

    }

}
