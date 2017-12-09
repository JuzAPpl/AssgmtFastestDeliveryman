/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import java.util.Scanner;
import ADT.*;

/**
 *
 * @author Gan Zhen Jie, Lim Fang Chun
 */
public class Menu implements MenuInterface {

    private LinkedList<Food> linkedFood = new LinkedList<>();
    private Food[] food = new Food[100];
    private int countFood = 0;
    private int length;

    public Menu() {
        
    }

    public Menu(Food[] menu) {
        for (int i = 0; i < menu.length; i++) {
            addFood(menu[i]);
        }
    }

    @Override
    public void showMenu() {
        //this method will display only status == promotion OR food status == available
        //status == unavailable will not be displayed
        //status == promotion will be displayed first
        //followed by status == available

        System.out.printf("%-5s %20s %-9s %-17s %10s\n", "ID", "Food name", "Price(RM)", "Preparation time", "Status");
        for (int i = 0; i < countFood; ++i) {
            if (food[i].getStatus().equals("Promotion")) {
                System.out.println(food[i]);
            }
        }

        for (int i = 0; i < countFood; ++i) {
            if (food[i].getStatus().equals("Available")) {
                System.out.println(food[i]);
            }
        }
    }

    public void initializeMenu() {
        //TODO: read from binary file
    }

    @Override
    public void addFood() {
        //TODO: Add a new food object into list of food in menu(this) class

        Scanner reader = new Scanner(System.in);
        String foodName;
        double price, preparationTime;
        int foodStatus;
        Boolean validInput;

        do {
            //ask affiliate to enter details for new food
            System.out.println("====================");
            System.out.println("Enter food name: ");
            foodName = reader.nextLine();
            System.out.println("Enter price for this food: ");
            price = Double.parseDouble(reader.nextLine());
            System.out.println("Enter preparation time for this food(in minute): ");
            preparationTime = Double.parseDouble(reader.nextLine());
            System.out.println("Select a status for this food: ");
            System.out.println("1. Available");
            System.out.println("2. Promotion");
            System.out.println("3. Not available");
            System.out.println("Your choice: ");
            foodStatus = Integer.parseInt(reader.nextLine());

            switch (foodStatus) {
                case 1:
                    foodStatus = Food.FOOD_AVAILABLE;
                    break;
                case 2:
                    foodStatus = Food.FOOD_PROMOTION;
                    break;
                case 3:
                    foodStatus = Food.FOOD_UNAVAILABLE;
                    break;
            }
            //check if affiliate enter any empty data
            //if there is any empty data, then prompt error message
            //else proceed to creating new food object
            if (!foodName.equals("") && price > 0 && preparationTime > 0 && foodStatus >= 0 && foodStatus <= 2) {
                //food[countFood] = new Food(countFood + 1, foodName, price, preparationTime, foodStatus);
                Food newFood = new Food(linkedFood.getNumberOfEntries() + 1, foodName, price, preparationTime, foodStatus);
                linkedFood.add(newFood);
                //++countFood;
                validInput = true;
                System.out.println("====================================");
                System.out.println("The food has been added to your menu");
                System.out.println("Food Details: ");
                System.out.println("======================");
                System.out.println("Food ID          : " + linkedFood.getEntry(linkedFood.getNumberOfEntries()).getID());
                System.out.println("Food Name        : " + linkedFood.getEntry(linkedFood.getNumberOfEntries()).getName());
                System.out.println("Price            : RM" + linkedFood.getEntry(linkedFood.getNumberOfEntries()).getPrice());
                System.out.println("Preparation Time : " + linkedFood.getEntry(linkedFood.getNumberOfEntries()).getPreparationTime());
                System.out.println("Status           : " + linkedFood.getEntry(linkedFood.getNumberOfEntries()).getStatus());
                System.out.println("======================");
            } else {
                System.out.println("Please do not leave any blank space.");
                validInput = false;
            }
        } while (!validInput);
    }

    public void addFood(Food food) {
        this.food[length++] = food;
    }

    public Food[] getMenu() {
        return food;
    }

    @Override
    public void removeFood() {
        //TODO
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean setFoodStatus() {
        //TODO: allow affiliate to change food status to available, unvailable or promotion
        Scanner reader = new Scanner(System.in);
        Boolean validInput;
        int foodID;
        int newFoodStatus;

        System.out.println("==================================");
        System.out.println(String.format("%-5s %20s %-7.2s %-10s", "ID", "Food Name", "Price", "Status"));
        for (Food f : food) {
            System.out.println(f);
        }
        do {
            System.out.println("==================================");
            System.out.println("Please enter the Food ID to change the status");
            System.out.print("Food ID: ");
            foodID = Integer.parseInt(reader.nextLine());

            if (foodID <= countFood + 1 && foodID >= 1) {
                newFoodStatus = Food.getNewFoodStatus();

                //food[foodID - 1].setStatus(newFoodStatus);
                linkedFood.getEntry(foodID).setStatus(newFoodStatus);
                
                System.out.println("==========================================");
                System.out.println("Update successfull!");
                System.out.println("The following food status has been updated");
                System.out.println("Food Name:        " + linkedFood.getEntry(foodID).getName());
                System.out.println("Price:            " + linkedFood.getEntry(foodID).getPrice());
                System.out.println("Preparation Time: " + linkedFood.getEntry(foodID).getPreparationTime());
                System.out.println("Status:           " + linkedFood.getEntry(foodID).getStatus());
                System.out.println("==========================================");

                validInput = true;
            } else {
                System.out.println("Invalid food ID. Please try again");
                validInput = false;
            }
        } while (!validInput);
        return validInput;
    }

    @Override
    public String toString() {
        //this toString() method will display all food in menu regardless of status
        String msg = "";
//        for (Food f : food) {
//            msg += f.toString();
//        }
        msg += linkedFood;

        return msg;
    }

    public void sortByID() {
        //TODO: sort food list by ascending order  of "ID" field
    }

    public void sortByName() {
        //TODO: sort food list by ascending order of "name" field
    }
}
