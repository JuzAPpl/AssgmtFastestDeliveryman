/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import java.util.Date;

/**
 *
 * @author User
 */
public class Order {

    private String orderNum;
    private String affiliateID;
    private Food[] orderedFood;
    private static int newNum;
    private Date orderDay;
    private String location;

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
}
