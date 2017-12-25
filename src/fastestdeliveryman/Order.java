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
 * @author User
 */
public class Order implements Comparable<Order>, Serializable{

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
    protected int status;

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
        return (LinkedList<Food>)orderedFood;
    }
  
    public String toString(){
        String orderDetail = "";
        for(int i=0; i < orderedFood.getNumberOfEntries(); i++)
        {
            orderDetail += "";
        }
        
        return orderDetail;
    }
    
    public static Order newOrder(LinkedList<Food> foods){
        //retrieve addr, time, destination from user input
        
        //order date=current time by default
        
        
        //arriveTime =current time+preparatin time+time used to travel from restaurant to destination 
        
        return new Order();
    }
    
    public double getPreparationTime(){
        //return largest preparation time in ordered food collection
        Iterator it = orderedFood.getIterator();
        double largestPreparationTime = -1;
        while(it.hasNext()){
            Food currentFood = (Food)it.next();
            double prepTime = currentFood.getPreparationTime();
            if(prepTime > largestPreparationTime)
                largestPreparationTime = prepTime;
        }
        return largestPreparationTime;
    }
    
    public int getDeliveryTimeTaken(){
        //affiliate location vs destination
        
        return 0;
    }
    
    @Override
    public int compareTo(Order anotherOrder){
        //compare order finish time
        return 0;
    } 

}
