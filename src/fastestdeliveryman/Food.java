/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

/**
 *
 * @author Gan Zhen Jie
 */
public class Food {
    
    public static final int FOOD_UNAVAILABLE = 0;
    public static final int FOOD_AVAILABLE = 1;
    public static final int FOOD_PROMOTION = 2;
    
    private int ID;
    private String name;
    private double price;
    private double preparationTime;
    private int status; //0: unavailable, 1: available, 2: promotion
    
    public Food(){
        this(-1, "", -1.0, -1.0, 0);
    }
    
    public Food(int ID, String name, double price, double preparationTime, int status){
        this.ID=ID;
        this.name=name;
        this.price=price;
        this.preparationTime=preparationTime;
        this.status=status;
    }
    
    //setters and getters
    public void setName(String name){
        this.name=name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setPrice(double price){
        this.price=price;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setPreparationTime(double preparationTime){
        this.preparationTime=preparationTime;
    }
    
    public String getPreparationTimeMinutes(){
        return String.format("%.1f", preparationTime);
    }
    
    public void setStatus(int status){
        this.status=status;
    }
    
    public String getStatus(){
        String status;
        switch(this.status){
            case FOOD_UNAVAILABLE:
                status = "Unavailable";
                break;
            case FOOD_AVAILABLE:
                status="Available";
                break;
            case FOOD_PROMOTION:
                status="Promotion";
                break;
            default:
                status = "";
                break;
        }
        return status;
    }
    
    @Override
    public String toString(){
        return String.format("%-5d %-40s\t%-9.2f\t%-20s\t%-20s", ID, name, price, (getPreparationTimeMinutes()+" minutes"), getStatus());
    }
}
