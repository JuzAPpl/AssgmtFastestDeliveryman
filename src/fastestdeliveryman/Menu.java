/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import java.util.Scanner;

/**
 *
 * @author Gan Zhen Jie, Lim Fang Chun
 */
public class Menu implements MenuInterface {

    private Food[] food = new Food[100];
    private int countFood = 0;

    public Menu() {

    }

    public Menu(Food[] menu) {
        //System.arraycopy(this.menu, 0, menu, 0, menu.length);
    }

    @Override
    public void showMenu() {
        //this method will display only status == promotion OR food status == available
        //status == unavailable will not be displayed
        //status == promotion will be displayed first
        //followed by status == available

        System.out.printf("%-5s %30s %-9s %17s\n", "ID", "Food name", "Price(RM)", "Preparation time");
        for (Food food1 : food) {
            food.toString();
            //TODO: display food status == promotion
            //              food status == available
            //Do not display unvailable food
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
        Boolean validInput;

        do {
            //ask affiliate to enter details for new food
            System.out.println("Enter food name: ");
            foodName = reader.nextLine();
            System.out.println("Enter price for this food: ");
            price = Double.parseDouble(reader.nextLine());
            System.out.println("Enter preparation time for this food: ");
            preparationTime = Double.parseDouble(reader.nextLine());

            //check if affiliate enter any empty data
            //if there is any empty data, then prompt error message
            //else proceed to creating new food object
            if (!foodName.equals("") && price > 0 && preparationTime > 0) {
                food[countFood] = new Food(countFood + 1, foodName, price, preparationTime, "Available");
                ++countFood;
                validInput = true;
                System.out.println("The food has been added to your menu");
                System.out.println("Food Details: ");
                System.out.println("======================");
                System.out.println("Food Name:        " + food[countFood].getName());
                System.out.println("Price:            " + food[countFood].getPrice());
                System.out.println("Preparation Time: " + food[countFood].getPreparationTime());
                System.out.println("Status:           " + food[countFood].getStatus());
                System.out.println("======================");
            } else {
                System.out.println("Please do not leave any blank space.");
                validInput = false;
            }
        } while (!validInput);
    }

    @Override
    public void removeFood() {
        //TODO
    }

    @Override
    public boolean setFoodStatus() {
        //TODO: allow affiliate to change food status to available, unvailable or promotion
        Scanner reader = new Scanner(System.in);
        Boolean validInput;
        String newStatus = "";
        int foodID, choiceOfStatus;

        do {
            System.out.println("==================================");
            System.out.println(String.format("%-5s %20s %-7.2s %-10s", "ID", "Food Name", "Price", "Status"));
            for (Food f : food) {
                System.out.println(f);
            }
            System.out.println("==================================");
            System.out.println("Please enter the Food ID to change the status");
            System.out.print("Food ID: ");
            foodID = Integer.parseInt(reader.nextLine());

            if (foodID <= countFood + 1 && foodID >= 1) {
                do {
                    System.out.println("========================================");
                    System.out.println("Please select new status for this food: ");
                    System.out.println("1. Available");
                    System.out.println("2. Promotion");
                    System.out.println("3. Unavailable");
                    System.out.println("-1. Cancel");
                    System.out.println("========================================");
                    System.out.print("Your choice: ");
                    choiceOfStatus = Integer.parseInt(reader.nextLine());
                    if(choiceOfStatus == -1 || (choiceOfStatus >= 1 && choiceOfStatus <= 3))
                        validInput = true;
                    else
                        validInput = false;
                } while (!validInput);
                
                switch (choiceOfStatus) {
                    case 1:
                        newStatus = "Available";
                        break;
                    case 2:
                        newStatus = "Promotion";
                        break;
                    case 3:
                        newStatus = "Unvailable";
                        break;
                    default:
                }
                food[foodID - 1].setStatus(newStatus);
                System.out.println("==========================================");
                System.out.println("Update successfull!");
                System.out.println("The following food status has been updated");
                System.out.println("Food Name:        " + food[foodID - 1].getName());
                System.out.println("Price:            " + food[foodID - 1].getPrice());
                System.out.println("Preparation Time: " + food[foodID - 1].getPreparationTime());
                System.out.println("Status:           " + food[foodID - 1].getStatus());
                System.out.println("==========================================");
                validInput = true;
                return true;
            } else {
                System.out.println("Invalid food ID. Please try again");
                validInput = false;
                return false;
            }
        } while (!validInput);
    }

    @Override
    public String toString() {
        //this toString() method will display all food in menu regardless of status
        String msg = "";
        for (Food f : food) {
            msg += f.toString();
        }
        return msg;
    }
}
