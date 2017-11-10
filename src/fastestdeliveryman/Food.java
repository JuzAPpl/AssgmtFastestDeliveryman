/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

/**
 *
 * @author ASUS
 */
public class Food {
    
    private int ID;
    private String name;
    private double price;
    private double preparationTime;
    
    public Food(){
        this.ID=-1;
        this.name="";
        this.price=-1.0;
        this.preparationTime=-1.0;
    }
    
    public void Food(int ID, String name, double price, double preparationTime){
        this.ID=ID;
        this.name=name;
        this.price=price;
        this.preparationTime=preparationTime;
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
    
    @Override
    public String toString(){
        return String.format("%-5d %30s %-7.2f %-17s\n", ID, name, price, (getPreparationTimeMinutes()+" minutes"));
    }
}
