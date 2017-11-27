/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Food implements FoodInterface {

    private int ID;
    private String name;
    private double price;
    private double preparationTime;
    private String status;

    public Food() {
        this.ID = -1;
        this.name = "";
        this.price = -1.0;
        this.preparationTime = -1.0;
        this.status = "";
    }

    public Food(int ID, String name, double price, double preparationTime, String status) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.preparationTime = preparationTime;
        this.status = status;
    }

    //setters and getters
    public int getID(){
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
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    public static String getNewFoodStatus() {
        Scanner reader = new Scanner(System.in);
        String newStatus = "";
        int choiceOfStatus;
        Boolean validInput;

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
            validInput = choiceOfStatus == -1 || (choiceOfStatus >= 1 && choiceOfStatus <= 3);
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
                newStatus = "";
        }
        return newStatus;
    }

    @Override
    public String toString() {
        return String.format("%-5d %20s %9.2f %17s %10s\n", ID, name, price, (getPreparationTime() + " min"), status);
    }
}
