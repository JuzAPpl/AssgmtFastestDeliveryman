/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import java.util.Scanner;

/**
 *
 * @author Leo
 */
public class Affiliate implements AffiliateInterface{
    private String onwerName;
    private String address;
    private String restaurantName;
    private String contactNo;
    private Menu menu;
           
    public Affiliate(String ownerName, String restaurantName, String address, String contactNo){
        this.onwerName = ownerName;
        this.restaurantName = restaurantName;
        this.address = address;
        this.contactNo = contactNo;
        this.menu = new Menu();
    }       
    
    public Affiliate(String ownerName, String restaurantName, String address, String contactNo, Menu menu){
        this.onwerName = ownerName;
        this.restaurantName = restaurantName;
        this.address = address;
        this.contactNo = contactNo;
        this.menu = menu;
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
    
    public String getContactNo(){
        return contactNo;
    }
    
    public void setContactNo(String contactNo){
        this.contactNo=contactNo;
    }
    
    @Override
    public Menu getMenu(){
        //this method will return an object Menu
        return menu;
    }
    
    @Override
    public void setMenu(){
        int choice;
        Scanner reader = new Scanner(System.in);
        
        //display options to affiliate and ask user to select an option
        System.out.println("Please select an option: ");
        System.out.println("1. Add food to menu");
        System.out.println("2. Remove food to menu");
        System.out.println("3. Set status of food");
        System.out.println("9. Exit");
        System.out.println("===========================");
        System.out.print("Your choice: ");
        choice = reader.nextInt();
        
        switch(choice){
            case 1:
                menu.addFood();
                break;
            case 2:
                menu.removeFood();
                break;
            case 3:
                //invoke setFood() method here
                break;
            case 9:
            default:
                //go back
        }
    }
    
    @Override
    public String toString(){
        return "Onwer Name: " + onwerName +
                "\nRestaurant Name: " + restaurantName +
                "\nAddress: " + address + 
                "\nContact Number: " + contactNo;
    }
    
}
