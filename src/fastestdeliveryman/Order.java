/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import ADT.LinkedList;
import ADT.ListInterface;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author User
 */
public class Order implements Serializable{

    public static final int ADHOC_PENDING = 1;
    public static final int ADHOC_STARTED = 2;
    public static final int ADHOC_COMPLETE = 3;
    public static final int SCH_PENDING = 21;
    public static final int SCH_STARTED_INCOMPLETE = 23;
    public static final int SCH_STARTED_COMPLETE = 23;
    public static final int SCH_COMPLETE = 24;
    
    private static int newNum = 0;
    protected String orderNum;
    protected LinkedList<Food> orderedFood;
    protected Date orderDay;
    protected Time arriveTime;
    protected DeliveryMan delManInCharge; 
    protected Location destination; //TODO: change to "Location destination;" aftter implementation of Location class

    public Order() {
        this.orderNum = "S" + String.format("%06d",newNum);
        newNum++;
    }

    public Order(Date orderDay, LinkedList<Food> orderedFood, Location destination) {
        this.orderNum = "S" + String.format("%06d",newNum);
        this.orderDay = orderDay;
        this.destination = destination;
        this.orderedFood = orderedFood;
         newNum++;
    }
    
    public static Order addOrder(){
    return new Order();
    }

    public Time getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Time arriveTime) {
        this.arriveTime = arriveTime;
    }

    public DeliveryMan getDelManInCharge() {
        return delManInCharge;
    }

    public void setDelManInCharge(DeliveryMan delManInCharge) {
        this.delManInCharge = delManInCharge;
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
        return orderedFood;
    }
  
    public String toString(){
        String orderDetail = "";
        for(int i=0; i < orderedFood.getNumberOfEntries(); i++)
        {
            orderDetail += "";
        }
        
        return orderDetail;
    }
}
