/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import java.util.Scanner;
import ADT.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gan Zhen Jie, Lim Fang Chun
 */
public class Menu implements MenuInterface, Serializable {

    private SortedListWithIteratorInterface<Food> linkedFood = new SortedList<>();
    private Food[] food = new Food[100];
    private SortedListInterface<Integer> emptyFoodID = new SortedList();

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
        Iterator temp = linkedFood.getIterator();
        String promotion = "";
        String available = "";
        while (temp.hasNext()) {
            Food currentFood = (Food) temp.next();
            if (currentFood.getStatus(true) == Food.FOOD_PROMOTION) {
                promotion += currentFood;
            }
            if (currentFood.getStatus(true) == Food.FOOD_AVAILABLE) {
                available += currentFood;
            }
        }
        System.out.println(promotion + available);
    }

    public void initializeMenu() throws FileNotFoundException, IOException {
        ObjectInputStream is = null;
        linkedFood.clear();
        try {
            //TODO: read from binary file
            String fileName = "Menu.bin";
            is = new ObjectInputStream(new FileInputStream(fileName));
            while (true) {
                Food temp = (Food) is.readObject();
                linkedFood.add(temp);
            }
        } catch (ClassNotFoundException | EOFException | FileNotFoundException ex) {

        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void saveMenu() throws IOException {
        ObjectOutputStream is = null;
        try {
            String fileName = "Menu.bin";
            is = new ObjectOutputStream(new FileOutputStream(fileName));
            Iterator temp = linkedFood.getIterator();
            while (temp.hasNext()) {
                Food f = (Food) temp.next();

                is.writeObject(f);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
            Food newFood;
            if (!foodName.equals("") && price > 0 && preparationTime > 0 && foodStatus >= 0 && foodStatus <= 2) {
                if (emptyFoodID.isEmpty()) {
                    if (linkedFood.isEmpty()) {
                        newFood = new Food(1, foodName, price, preparationTime, foodStatus);
                    } else {
                        newFood = new Food(linkedFood.getLastEntry().getID() + 1, foodName, price, preparationTime, foodStatus);
                    }
                    linkedFood.add(newFood);
                } else {
                    int nextID = emptyFoodID.remove(1);
                    newFood = new Food(nextID, foodName, price, preparationTime, foodStatus);
                    linkedFood.add(newFood);
                }

                validInput = true;
                System.out.println("====================================");
                System.out.println("The food has been added to your menu");
                System.out.println("Food Details: ");
                System.out.println("======================");
                displayFoodDetail(newFood.getID());
                System.out.println("======================");
            } else {
                System.out.println("Please do not leave any blank space.");
                validInput = false;
            }
        } while (!validInput);
    }

    public void addFood(Food food) {
        //this.food[length++] = food;
    }

    public Food[] getMenu() {
        return food;
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

            validInput = foodID >= 1 && foodID <= linkedFood.getLength();

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
                    Food foodToBeRemoved = getFoodByID(foodID);
                    emptyFoodID.add(foodToBeRemoved.getID());
                    System.out.println("=====================================");
                    System.out.println("The following food has been deleted");
                    displayFoodDetail(foodID);
                    System.out.println("=====================================");
                    linkedFood.remove(foodToBeRemoved);

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

    private Food getFoodByID(int ID) {
        Iterator temp = linkedFood.getIterator();
        Food result;
        while (temp.hasNext()) {
            result = (Food) temp.next();
            if (result.getID() == ID) {
                return result;
            }
        }
        return null;
    }

    public int getLength() {
        return linkedFood.getLength();
    }

    @Override
    public void setFoodDetail() {
        Scanner reader = new Scanner(System.in);
        int choice;
        Boolean validInput = false;

        do {
            System.out.println("==============================");
            System.out.println("Please select an option: ");
            System.out.println("==============================");
            System.out.println("1. Change Food Name");
            System.out.println("2. Change Food Price");
            System.out.println("3. Change Food Preparation Time");
            System.out.println("4. Change Food Status");

            System.out.print("Your choice: ");
            choice = Integer.parseInt(reader.nextLine());
            validInput = choice >= 1 && choice <= 4;

            if (!validInput) {
                System.out.println("================");
                System.out.println("Invalid option");
                System.out.println("Please try again");
                System.out.println("================");
            } else {
                System.out.println("=========================================");
                System.out.println(String.format("%-5s %20s %-7.2s %-10s", "ID", "Food Name", "Price", "Status"));
                System.out.println(linkedFood);
                System.out.println("=========================================");
                switch (choice) {
                    case 1:// case 1: change food name
                        setFoodName();
                        break;
                    case 2:// case 2: change food price
                        setFoodPrice();
                        break;
                    case 3:// case 3: change food preparation time
                        setFoodPreparationTime();
                        break;
                    case 4:// case 4: change food status
                        setFoodStatus();
                        break;
                }
            }
        } while (!validInput);
    }

    private void setFoodStatus() {
        Scanner reader = new Scanner(System.in);
        int foodID;
        int newFoodStatus;

        foodID = getInputFoodID(reader);
        Food foodToBeChanged = getFoodByID(foodID);

        newFoodStatus = Food.getNewFoodStatus();

        foodToBeChanged.setStatus(newFoodStatus);

        updateFoodSuccessMessage(foodToBeChanged.getID());
    }

    private void setFoodName() {
        Scanner reader = new Scanner(System.in);
        int foodID;
        String newFoodName;

        foodID = getInputFoodID(reader);
        Food foodToBeChanged = getFoodByID(foodID);

        System.out.println("New Food Name: ");
        newFoodName = reader.nextLine();

        foodToBeChanged.setName(newFoodName);

        updateFoodSuccessMessage(foodToBeChanged.getID());

    }

    private void setFoodPrice() {
        Scanner reader = new Scanner(System.in);
        int foodID;
        double newFoodPrice;

        foodID = getInputFoodID(reader);
        Food foodToBeChanged = getFoodByID(foodID);
        System.out.println("New Price: ");
        newFoodPrice = Double.parseDouble(reader.nextLine());

        foodToBeChanged.setPrice(newFoodPrice);

        updateFoodSuccessMessage(foodToBeChanged.getID());
    }

    private void setFoodPreparationTime() {
        Scanner reader = new Scanner(System.in);
        int foodID;
        double newPreparationTime;

        foodID = getInputFoodID(reader);
        Food foodToBeChanged = getFoodByID(foodID);
        System.out.println("New Preparation time: ");
        newPreparationTime = Double.parseDouble(reader.nextLine());

        foodToBeChanged.setPreparationTime(newPreparationTime);

        updateFoodSuccessMessage(foodToBeChanged.getID());
    }

    private int getInputFoodID(Scanner reader) throws NumberFormatException {
        boolean found = false;
        int foodID;

        do {
            System.out.println("Please enter the Food ID to change the detail");
            System.out.print("Food ID: ");
            foodID = Integer.parseInt(reader.nextLine());
            found = linkedFood.contains(getFoodByID(foodID));

            if (!found) {
                System.out.println("================");
                System.out.println("Invalid Food ID");
                System.out.println("Please try again");
                System.out.println("================");
            }
        } while (!found);

        return foodID;
    }

    private void updateFoodSuccessMessage(int foodID) {
        System.out.println("==========================================");
        System.out.println("Update successfull!");
        System.out.println("The following food status has been updated");
        displayFoodDetail(foodID);
        System.out.println("==========================================");
    }

    private void displayFoodDetail(int foodID) {
        Food f = getFoodByID(foodID);
        System.out.println(String.format("%-5s %20s %9s %17s %10s\n",
                "ID", "Food Name", "Price", "Preparation time", "Status"));
        System.out.println("ID:               " + f.getID());
        System.out.println("Food Name:        " + f.getName());
        System.out.println("Price:            " + f.getPrice());
        System.out.println("Preparation Time: " + f.getPreparationTime());
        System.out.println("Status:           " + f.getStatus());
    }

    @Override
    public String toString() {
        //this toString() method will display all food in menu regardless of status
        String msg = "";
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
