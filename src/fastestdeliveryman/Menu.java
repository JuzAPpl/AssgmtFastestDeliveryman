/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import java.util.Scanner;

/**
 *
 * @author Gan Zhen Jie
 */
public class Menu implements MenuInterface{
    
    private Food[] menu ;
    
    public Menu(){
    
    }
    
    public Menu(Food[] menu){
        
    }
    
    @Override
    public void showMenu(){
        System.out.printf("%-5s %30s %-9s %17s\n", "ID", "Food name", "Price(RM)", "Preparation time");
        for (Food menu1 : menu) {
            menu1.toString();
            //TODO: display food status == promotion
            //              food status == available
            //Do not display unvailable food
        }
    }
    
    public void initializeMenu(){
        //TODO: read from binary file
    }
    
    @Override
    public void addFood(){
        //TODO: Add a new food object into list of food in menu(this) class
        
        Scanner reader = new Scanner(System.in);
        String foodName;
        double price, preparationTime;
        
        //ask affiliate to enter details for new food
        System.out.println("Enter food name: ");
        foodName = reader.nextLine();
        System.out.println("Enter price for this food: ");
        price = reader.nextDouble();
        System.out.println("Enter preparation time for this food: ");
        preparationTime = reader.nextDouble();
        
        //check if affiliate enter any empty data
        //if there is any empty data, then prompt error message
        //else proceed to creating new food object
        if(!foodName.equals("") && price != 0 && preparationTime != 0){
            //TODO: invoke addFood() method and create new food object and add to menu food array
        }
        else{
            System.out.println("Please do not leave any blank space.");
        }
    }
    
    @Override
    public void removeFood(){
        //TODO
    }
    
    @Override
    public boolean setFoodStatus(){
        //TODO: allow affiliate to change food status to available, unvailable or promotion
        
        return true;
    }
}
