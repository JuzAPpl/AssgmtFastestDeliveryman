/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import ADT.LinkedList;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Customer {
    LinkedList<Food> cart = new LinkedList<>();

    public LinkedList<Food> getCart() {
        return cart;
    }

    public void setCart(LinkedList<Food> cart) {
        this.cart = cart;
    }

    public Customer() {

    }

    public void login() {
        System.out.print("Press enter to login!");
        Scanner in = new Scanner(System.in);
        in.nextLine();

        //TODO: cust id and pw vaidation
        int menuSel;
        do {
            //TODO: display list of selection available for customer
            System.out.println("Enter 1: Order food");
            System.out.println("Enter 0: Log out");
            menuSel = in.nextInt();
            switch (menuSel) {
                case 1:
                    orderFood();
                    break;
                case 0:
                    System.out.println("You have been logged out successfully.");
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        } while (menuSel != 0);
    }

    private void orderFood() {
        Scanner in = new Scanner(System.in);

        int menuSel;
        do {
            //TODO: display list of selection available for customer
            System.out.println("Enter 1: Browse restaurants");
            System.out.println("Enter 2: Search for food");
            System.out.println("Enter 0: Back to prevous menu");
            menuSel = in.nextInt();
            switch (menuSel) {
                case 1:
                    browseRestaurants();
                    break;
                case 2:
                    searchFood();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        } while (menuSel != 0);
    }

    private void browseRestaurants() {
        //Dummy data: to be replaced after implementation of reading objects from binary files
        Food food1 = new Food(1, "Delicious Kuey Teow", 4.99, 5, Food.FOOD_UNAVAILABLE);
        Food food2 = new Food(2, "East DonDong Fried Chicken", 9.99, 7.6, Food.FOOD_AVAILABLE);
        Food food3 = new Food(3, "Super Mega Jumbo Burger", 8.79, 10, Food.FOOD_PROMOTION);

        Food[] foodArr0 = {food1, food2, food3};
        Menu menu0 = new Menu(foodArr0);

        Affiliate affiliate0 = new Affiliate("East DonDong", "Mac DonDong's", "PV13", "011-2334567", menu0);

        Food food4 = new Food(1, "Very Delicious Kuey Teow", 4.99, 5, Food.FOOD_UNAVAILABLE);
        Food food5 = new Food(2, "West DonDong Fried Chicken", 9.99, 7.6, Food.FOOD_AVAILABLE);
        Food food6 = new Food(3, "Super Mega Giga Jumbo Burger", 8.79, 10, Food.FOOD_PROMOTION);

        Food[] foodArr1 = {food4, food5, food6};
        Menu menu1 = new Menu(foodArr1);

        Affiliate affiliate1 = new Affiliate("West DonDong", "Mac DinDing's", "PV13", "011-2334567", menu1);

        Affiliate[] affiliates = {affiliate0, affiliate1};
        //End of dummy data
        
        Scanner in=new Scanner(System.in);
        
        for(int i=0;i<affiliates.length;i++){
            System.out.println((i+1) + ": " + affiliates[i].getRestaurantName());
        }
        System.out.println("0: Cancel");
        System.out.println("Please enter your selection");
        int menuSel = in.nextInt()-1;
        if(menuSel==-1){
            //return to previous menu
        }else if(menuSel>=affiliates.length || menuSel<-1){
            //error message of invalid input
            System.out.println("Invalid input!");
        }else{
            affiliates[menuSel].getMenu().showMenu();
            System.out.println("---Food ordering service under construction---");
        }
        
        
    }

    private void searchFood() {
        //TODO: redirect to affiliate if customer wants to order more food (business rule: one affiliate per order)
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the food name(or part of the food name) you want to search: ");
        String keyword = in.nextLine();
        System.out.println(keyword);
        //TODO: read affiliate objects from binary files
        //TODO: change to linked implementation of list

        //Dummy data: to be replaced after implementation of reading objects from binary files
        Food food1 = new Food(1, "Delicious Kuey Teow", 4.99, 5, Food.FOOD_UNAVAILABLE);
        Food food2 = new Food(2, "East DonDong Fried Chicken", 9.99, 7.6, Food.FOOD_AVAILABLE);
        Food food3 = new Food(3, "Super Mega Jumbo Burger", 8.79, 10, Food.FOOD_PROMOTION);

        Food[] foodArr0 = {food1, food2, food3};
        Menu menu0 = new Menu(foodArr0);

        Affiliate affiliate0 = new Affiliate("East DonDong", "Mac DonDong's", "PV13", "011-2334567", menu0);

        Food food4 = new Food(1, "Very Delicious Kuey Teow", 4.99, 5, Food.FOOD_UNAVAILABLE);
        Food food5 = new Food(2, "West DonDong Fried Chicken", 9.99, 7.6, Food.FOOD_AVAILABLE);
        Food food6 = new Food(3, "Super Mega Giga Jumbo Burger", 8.79, 10, Food.FOOD_PROMOTION);

        Food[] foodArr1 = {food4, food5, food6};
        Menu menu1 = new Menu(foodArr1);

        Affiliate affiliate1 = new Affiliate("West DonDong", "Mac DinDing's", "PV13", "011-2334567", menu1);

        Affiliate[] affiliates = {affiliate0, affiliate1};
        //End of dummy data
        System.out.println(menu0.getLength());
        LinkedList<Food> results = new LinkedList<>();
        
        for (int i = 0; i < affiliates.length; i++) {
            Menu currentMenu = affiliates[i].getMenu();
            
            for (int j=0;j<currentMenu.getLength();j++){
                Food currentFood = currentMenu.getMenu().getEntry(j+1);
                for (int k = 0; k < currentFood.getName().length() - (keyword.length() - 1); k++) {
                    if (currentFood.getName().substring(k, k + keyword.length()).equalsIgnoreCase(keyword)) {
                        results.add(currentFood);
                        break;
                        //break is required to prevent repeated records when there are 2 matches in a single name
                    }
                }
            }
        }
        
        //Show list of matches found
        if (results.getNumberOfEntries() != 0) {
            for (int i = 0; i < results.getNumberOfEntries(); i++) {
                    System.out.println((i + 1) + ": " + results.getEntry(i+1));
            }
            //System.out.print("Please enter the number of the food to order(0 to cancel): ");
            System.out.println("---Food ordering service under construction---");
            //uncomment after implementation of food ordering service
//            int a = in.nextInt();
//            if (a == 0) {
//                //return to previous menu
//            }else if(a>0 && a<=matchCount){
//                //TODO: add selected food into cart
//                
//            }else{
//                //error message for invalid input
//                //System.out.println("Invalid input!");
//            }
        } else {
            System.out.println("No matching results.");
        }
        
    }
    
    private void addFoodToCart(LinkedList<Food> foodList){
        //show list of food
        System.out.printf("%-5s %20s %-9s %-17s %10s\n", "ID", "Food name", "Price(RM)", "Preparation time", "Status");
       //change this: foodList.displayMenuItemWithStatusOrder();
        
        //prompt user to enter selection and add to cart
        Scanner scanner = new Scanner(System.in);
        int sel;
        
        do{        
            System.out.println("Please enter your selection(0 to exit): ");
            sel = Integer.parseInt(scanner.nextLine());

            if(sel<0 || sel > foodList.getNumberOfEntries()){
                System.out.println("Invalid Input!");
            }
            else if(sel>0){
                cart.add(foodList.getEntry(sel));
            }
        }while(sel!=0);
        //return to browse the restaurant containing the food if user choose to
        
        System.out.println("You have ordered: " + cart);
    }
    
    private void addFoodToCart(Food food){
        //Show food details
        //Prompt user to enter qty(0 to cancel)
        //Add food to list using a loop,
    }
    
    private void checkOut(){
        //
    }
}
