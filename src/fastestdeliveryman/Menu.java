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
public class Menu {
    
    private Food[] menu ;
    
    public Menu(){
    
    }
    
    public Menu(Food[] menu){
        
    }
    
    public void showMenu(){
        System.out.printf("%-5s %30s %-9s %17s\n", "ID", "Food name", "Price(RM)", "Preparation time");
        for (int i=0;i<menu.length;i++){
            menu[i].toString();
        }
    }
    
    public void initializeMenu(){
        //TODO: read from binary file
    }
    
    public void addFood(){
        //TODO: Add a new food object into list of food in menu(this) class
    }
    
    public void removeFood(){
        //TODO
    }
}
