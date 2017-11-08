/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

/**
 *
 * @author Leo
 */
public class Affiliate {
    private String onwerName;
    private String address;
    private String restaurantName;
    
    public Affiliate(){
        this.onwerName="";
        this.address="";
        this.restaurantName="";
    }
    
    public Affiliate(String ownerName, String restaurantName, String address){
        this.onwerName = ownerName;
        this.restaurantName = restaurantName;
        this.address = address;
    }
    
    public String getOwnerName(){
        return onwerName;
    }
    
    public void setOwnerName(String ownerName){
        this.onwerName=ownerName;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
        this.address=address;
    }
    
    public String getRestaurantName(){
        return restaurantName;
    }
    
    public void setRestaurantName(String restaurantName){
        this.restaurantName=restaurantName;
    }
    
    @Override
    public String toString(){
        return "Onwer Name: " + onwerName +
                "\nRestaurant Name: " + restaurantName +
                "\nAddress: " + address;
    }
    
}
