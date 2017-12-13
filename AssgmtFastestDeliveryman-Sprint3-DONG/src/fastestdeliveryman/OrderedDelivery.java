/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import ADT.LinkedList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author S3113
 */
public class OrderedDelivery {

    private String OrderedID;
    private String affillateID;
    private String foodID;
    private String foodName;
    private String custID;
    private String custName;
    private String orderedDate;
    private String address;
    LinkedList<OrderedDelivery> orderdetails = new LinkedList<>();

    public OrderedDelivery() {
        
    }

    public OrderedDelivery(String OrderedID, String affillateID, String foodID, String foodName, String custID, String custName, String orderedDate, String address) {
        this.OrderedID = OrderedID;
        this.affillateID = affillateID;
        this.foodID = foodID;
        this.foodName = foodName;
        this.custID = custID;
        this.custName = custName;
        this.orderedDate = orderedDate;
        this.address = address;
    }

   

    public String getOrderedID() {
        return OrderedID;
    }

    public String getAffillateID() {
        return affillateID;
    }

    public String getFoodID() {
        return foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getCustID() {
        return custID;
    }

    public String getCustName() {
        return custName;
    }

    public String getOrderedDate() {
        return orderedDate;
    }

    public String getAddress() {
        return address;
    }

    public void setOrderedID(String OrderedID) {
        this.OrderedID = OrderedID;
    }

    public void setAffillateID(String affillateID) {
        this.affillateID = affillateID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void setOrderedDate(String orderedDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date dateTime = new Date();
        this.orderedDate = dateFormat.format(dateTime);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return OrderedID + " " + custName + " " + foodName + " " + address + " " + orderedDate+ "\n";
    }

    
}
