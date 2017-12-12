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
public class Menu implements MenuInterface{

    private LinkedList<Food> linkedFood = new LinkedList<>();
    private LinkedFoodListInterface<Food> linkedFood = new LinkedList<>();
    private Food[] food = new Food[100];
    private int countFood = 0;
    private int length;
    private LinkedQueue<Integer> emptyFoodID = new LinkedQueue<>();

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
        linkedFood.displayMenuItemWithStatusOrder();
//        for (int i = 0; i < countFood; ++i) {
//            if (food[i].getStatusString().equals("Promotion")) {
//                System.out.println(food[i]);
//            }
//        }
//
//        for (int i = 0; i < countFood; ++i) {
//            if (food[i].getStatusString().equals("Available")) {
//                System.out.println(food[i]);
//            }
//        }
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
            //request affiliate to enter details for new food
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
                if (emptyFoodID.isEmpty()) {
                    Food newFood = new Food(linkedFood.getNumberOfEntries()+ 1, foodName, price, preparationTime, foodStatus);
                    linkedFood.add(newFood);
                } else {
                    int nextID = emptyFoodID.dequeue();
                    Food newFood = new Food(nextID, foodName, price, preparationTime, foodStatus);
                    linkedFood.replace(nextID, newFood);
                }
                //linkedFood.add(newFood);
                validInput = true;
                System.out.println("====================================");
                System.out.println("The food has been added to your menu");
                System.out.println("Food Details: ");
                System.out.println("======================");
<<<<<<< HEAD
                System.out.println("Food ID          : " + linkedFood.getEntry(linkedFood.getNumberOfEntries()).getID());
                System.out.println("Food Name        : " + linkedFood.getEntry(linkedFood.getNumberOfEntries()).getName());
                System.out.println("Price            : RM" + linkedFood.getEntry(linkedFood.getNumberOfEntries()).getPrice());
                System.out.println("Preparation Time : " + linkedFood.getEntry(linkedFood.getNumberOfEntries()).getPreparationTime());
                System.out.println("Status           : " + linkedFood.getEntry(linkedFood.getNumberOfEntries()).getStatusString());
=======
                displayFoodDetail(linkedFood.getNumberOfEntries());
>>>>>>> Sprint3-ChiongYF
                System.out.println("======================");
            } else {
                System.out.println("Please do not leave any blank space.");
                validInput = false;
            }
        } while (!validInput);
    }

    public void addFood(Food food) {
        linkedFood.add(food);
    }

    public LinkedList<Food> getMenu() {
        return linkedFood;
    }

    @Override
    public void removeFood() {
        int foodID;
        boolean validInput;
        char confirm;
        Scanner reader = new Scanner(System.in);

        do {
            System.out.println("=======================================");
            System.out.println(linkedFood);
            System.out.println("=======================================");
            System.out.println("Please enter the food ID to remove it: ");
            foodID = Integer.parseInt(reader.nextLine());

            validInput = foodID >= 1 && foodID <= linkedFood.getNumberOfEntries();

            if (validInput) {
                System.out.println("=========================================");
                System.out.println("You have selected the following food: ");
                displayFoodDetail(foodID);
                System.out.println("=========================================");
                System.out.println("This food will be removed from your menu,");
                System.out.println("Do you want to do this? (Y/N)");
                confirm = reader.nextLine().charAt(0);
                confirm = Character.toUpperCase(confirm);
                if (confirm == 'Y') {
                    emptyFoodID.enqueue(linkedFood.getFoodByID(foodID).getID());
                    System.out.println("=====================================");
                    System.out.println("The following food has been deleted");
                    displayFoodDetail(foodID);
                    System.out.println("=====================================");
                    linkedFood.replace(foodID, null);
                    linkedFood.replace(foodID, null);//////error here

                    System.out.println("Your current menu items: ");
                    System.out.println(String.format("%-5s %20s %9s %17s %10s\n", 
                                    "ID", "Food Name", "Price", "Preparation time", "Status"));
                    System.out.println(linkedFood);
                    System.out.println("=====================================");
                }
            } else {
                System.out.println("================");
                System.out.println("Invalid Food ID");
                System.out.println("Please try again");
                System.out.println("================");
            }
        } while (!validInput);
    }

    public int getLength() {
        return linkedFood.getNumberOfEntries();
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
        System.out.println(linkedFood);
        do {
            System.out.println("==================================");
            System.out.println("Please enter the Food ID to change the status");
            System.out.print("Food ID: ");
            foodID = Integer.parseInt(reader.nextLine());

            if (foodID <= linkedFood.getNumberOfEntries() && foodID >= 1) {
            if (foodID <= linkedFood.getNumberOfEntries()&& foodID >= 1) {
                newFoodStatus = Food.getNewFoodStatus();
                System.out.println("==========================================");
                System.out.println("You have selected the following food: ");
                displayFoodDetail(foodID);
                System.out.println("==========================================");

                linkedFood.getFoodByID(foodID).setStatus(newFoodStatus);

                System.out.println("==========================================");
                System.out.println("Update successfull!");
                System.out.println("The following food status has been updated");
                displayFoodDetail(foodID);
                System.out.println("==========================================");

                validInput = true;
            } else {
                System.out.println("Invalid food ID. Please try again");
                validInput = false;
            }
        } while (!validInput);
        return validInput;
    }

    private void displayFoodDetail(int foodID) {
<<<<<<< HEAD
        System.out.println("ID:               " + linkedFood.getFoodByID(foodID).getID());
        System.out.println("Food Name:        " + linkedFood.getFoodByID(foodID).getName());
        System.out.println("Price:            " + linkedFood.getFoodByID(foodID).getPrice());
        System.out.println("Preparation Time: " + linkedFood.getFoodByID(foodID).getPreparationTime());
        System.out.println("Status:           " + linkedFood.getFoodByID(foodID).getStatusString());
=======
        Food f = linkedFood.getFoodByID(foodID);
        System.out.println("ID:               " + f.getID());
        System.out.println("Food Name:        " + f.getName());
        System.out.println("Price:            " + f.getPrice());
        System.out.println("Preparation Time: " + f.getPreparationTime());
        System.out.println("Status:           " + f.getStatus());
>>>>>>> Sprint3-ChiongYF
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

    public void setRestaurant(Affiliate aff){
        //set the affiliate of food under this menu to the affiliate provided in paramenter
        
    }
    public void sortByID() {
        //TODO: sort food list by ascending order  of "ID" field
    }

    public void sortByName() {
        //TODO: sort food list by ascending order of "name" field
    }
}
