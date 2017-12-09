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
 * @author Gan Zhen Jie
 */

public class Food implements FoodInterface {

    public static final int FOOD_UNAVAILABLE = 0;
    public static final int FOOD_AVAILABLE = 1;
    public static final int FOOD_PROMOTION = 2;

    private int ID;
    private String name;
    private double price;
    private double preparationTime;

    private int status; //0: unavailable, 1: available, 2: promotion

    public Food() {
        this(-1, "", -1.0, -1.0, 0);
    }

    public Food(int ID, String name, double price, double preparationTime, int status) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.preparationTime = preparationTime;
        this.status = status;
    }

    //setters and getters
    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPreparationTime(double preparationTime) {
        this.preparationTime = preparationTime;
    }

    @Override
    public String getPreparationTime() {
        return String.format("%.1f", preparationTime);
    }

    @Override
    public String toString() {
        return String.format("%-5d %20s %9.2f %17s %10s\n", ID, name, price, (getPreparationTime() + " min"), getStatus());
    }

    @Override
    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String getStatus() {
        String status;
        switch (this.status) {
            case FOOD_UNAVAILABLE:
                status = "Unavailable";
                break;
            case FOOD_AVAILABLE:
                status = "Available";
                break;
            case FOOD_PROMOTION:
                status = "Promotion";
                break;
            default:
                status = "";
                break;
        }
        return status;
    }
    
    public int getStatus(boolean inInteger){
        return status;
    }
    
    public static int getNewFoodStatus() {
        Scanner reader = new Scanner(System.in);
        int newStatus = Food.FOOD_AVAILABLE;
        int choiceOfStatus;
        Boolean validInput;

        do {
            System.out.println("========================================");
            System.out.println("Please select new status for this food: ");
            System.out.println("1. Available");
            System.out.println("2. Promotion");
            System.out.println("3. Unavailable");
            System.out.println("========================================");
            System.out.print("Your choice: ");
            choiceOfStatus = Integer.parseInt(reader.nextLine());

            validInput = (choiceOfStatus >= 1 && choiceOfStatus <= 3);

            if (!validInput) {
                System.out.println("===================");
                System.out.println("Invalid choice");
                System.out.println("Please try again");
                System.out.println("===================");
            }
        } while (!validInput);

        switch (choiceOfStatus) {
            case 1:
                newStatus = FOOD_AVAILABLE;
                break;
            case 2:
                newStatus = FOOD_PROMOTION;
                break;
            case 3:
                newStatus = FOOD_UNAVAILABLE;
                break;
        }
        return newStatus;
    }
}
