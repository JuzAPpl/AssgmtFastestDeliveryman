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
public class TestDisplayMenu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Food food1 = new Food(1, "Delicious Kuey Teow", 4.99, 5, Food.FOOD_UNAVAILABLE);
        Food food2 = new Food(2, "East DonDong Fried Chicken", 9.99, 7.6, Food.FOOD_AVAILABLE);
        Food food3 = new Food(3, "Super Mega Jumbo Burger", 8.79, 10, Food.FOOD_PROMOTION);
        
        Food[] foodArr = {food1, food2, food3};
        Menu menu = new Menu(foodArr);
        
        Affiliate affiliate = new Affiliate("East DonDong", "Mac DonDong's", "PV13", "011-2334567", menu);
        
        affiliate.getMenu().showMenu();
    }
    
}
