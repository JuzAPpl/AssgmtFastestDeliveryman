/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Ng Pei Xiang
 * Delivery Order class shall indicate the date 
 */
public class DeliveryOrder {
    //Indicate the delivery order is created and ready for deliveryman to get the order
    private static final int STATUS_NEW = 0;    
    //Indicate the delivery order is taken by the deliveryman and is on delivery
    private static final int STATUS_ONDELIVERY = 1;
    //Indicate the delivery order is delivered to customer
    private static final int STATUS_DELIVERED = 2;
    private Date deliveryDate;
    private Date arrTime;
    private int status;
    private String verificationCode;
    private String orderID;
    private Order foodOrder;
    
    private static int nextNum = 1000;

    public DeliveryOrder(Order foodOrder) {
        deliveryDate = new Date();
        this.orderID = generateDeliveryOrderID();
        this.foodOrder = foodOrder;
        status = STATUS_NEW;
        nextNum++;
    }
    
    
    /**
     *
     * @return OrderID
     * A method called to generate new Order ID for delivery
     * Last Edited: 24/12/2017
     * Last Edited by: Ng Pei Xiang
     * 
     */
    public static String generateDeliveryOrderID(){
        return String.format("D%05d", nextNum);
    }
    
    public String getDeliveryOrderID(){
        return orderID;
    }
    
    public void startDelivery(){
        status = STATUS_ONDELIVERY;
        verificationCode = generateVerificationCode();
    }
    public Location getDestination(){
        return foodOrder.getDestination();
    }
    public boolean verifyDelivery(String verificationCode){
        boolean valid = false;
        if(this.verificationCode.equals(verificationCode)){
            status = STATUS_DELIVERED;
            arrTime = new Date();
            valid = true;
        }
        return valid;
    }
    public void setOrderStatus(int status){
        this.status = status;
    }
    
    public int getNewStatus(){
        return STATUS_NEW;
    }
    private String convertDateToString(){
        String datePattern = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
        return dateFormat.format(deliveryDate);
    }
    
    private String convertArriveTimetoString(){
        String datePattern = "HH:mm:ss";
        SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
        return dateFormat.format(arrTime);
    }
    
    public String getStatus(){
        String orderStatus;
        switch(status){
            case STATUS_NEW: orderStatus = "New"; 
            break;
            case STATUS_ONDELIVERY: orderStatus = "Delivery on the way"; 
            break;
            case STATUS_DELIVERED: orderStatus = "Completed"; 
            break;
            default: orderStatus = "Error";         
        }
        return orderStatus;
    }
    
    public String toDetailsString(){
        String orderDetails = foodOrder.toString();
        return orderDetails; 
    }
    public String generateVerificationCode(){
        Random r = new Random();
        return r.nextInt(9999) + "";
    }
    
    @Override
    public String toString(){
        String deliveryOrderSummary;
        switch(status){
            case STATUS_DELIVERED: deliveryOrderSummary = String.format("%-15s %-12s %-24s %-15s",convertDateToString(),orderID,
                    getStatus(),convertArriveTimetoString());
                break;
            default: deliveryOrderSummary = String.format("%-15s %-12s %-24s",
                    convertDateToString(),orderID,getStatus());
                break;
        }
        return deliveryOrderSummary;
    }
    public static void main(String[] args) {
        DeliveryOrder dO = new DeliveryOrder(new Order());
        String code = dO.generateVerificationCode();
        System.out.println(code);
    }
    
}
