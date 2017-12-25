/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import ADT.LinkedList;
import ADT.ListInterface;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author User
 */
public class Order implements Serializable{

    String orderNum;
    String affiliateID;
    ListInterface<Food> orderedFood = new LinkedList<>();
    private static int newNum;
    Date orderDay;
    String location;

    public void Order() {
        newNum = 0;
        this.orderNum = "S00" + newNum;
        newNum++;
        this.affiliateID = "";
    }

    public void Order(String orderNum, Date orderDay, Food[] orderedFood, String location, String affiliateID) {
        this.orderNum = "S00" + newNum;
        this.orderDay = orderDay;
        this.location = location;
        this.affiliateID = affiliateID;
        this.orderedFood = orderedFood;
    }
    
    public static Order addOrder(){
    return new Order();
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
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

    public void setAffiliateID(String affiliateID) {
        this.affiliateID = affiliateID;
    }

    public String getAffiliateID() {
        return affiliateID;
    }

    public void setOrderedFood(Food[] orderedFood) {
        this.orderedFood = orderedFood;
    }

    public Food[] getOrderedFood() {
        return orderedFood;
    }
    
    public String toString(){
        String orderDetail = "";
        for(int i=0; i < orderedFood.getNumberOfEntries(); i++)
        {
            orderDetail += ;
        }
        
        return orderDetail;
    }
}
