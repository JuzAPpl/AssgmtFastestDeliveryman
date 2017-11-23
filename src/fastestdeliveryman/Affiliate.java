/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import java.util.Scanner;

/**
 *
 * @author Leo
 */
public class Affiliate implements AffiliateInterface {

    private int ID;
    private String ownerName;
    private String password;
    private String address;
    private String restaurantName;
    private String contactNo;
    private Menu menu;
    private static int nextID = 1;

    public Affiliate() {
        this.ID = nextID;
        this.ownerName = "";
        this.password = "";
        this.restaurantName = "";
        this.address = "";
        this.contactNo = "";
        this.menu = new Menu();
        ++nextID;
    }

    public Affiliate(String ownerName, String password, String restaurantName, String address, String contactNo) {
        this.ID = nextID;
        this.ownerName = ownerName;
        this.password = password;
        this.restaurantName = restaurantName;
        this.address = address;
        this.contactNo = contactNo;
        this.menu = new Menu();
        ++nextID;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getRestaurantName() {
        return restaurantName;
    }

    @Override
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    @Override
    public String getContactNo() {
        return contactNo;
    }

    @Override
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public int displayChoice() {
        Scanner reader = new Scanner(System.in);
        int choice;
        //display options to affiliate and ask user to select an option
        System.out.println("===========================");
        System.out.println("Please select an option: ");
        System.out.println("1. Add food to menu");
        System.out.println("2. Remove food to menu");
        System.out.println("3. Set status of food");
        System.out.println("4. Display all food in menu");
        System.out.println("-1. Exit");
        System.out.println("===========================");
        System.out.print("Your choice: ");
        choice = reader.nextInt();

        return choice;
    }

    @Override
    public Menu getMenu() {
        //this method will return an object Menu
        return menu;
    }

    @Override
    public void setMenu() {
        boolean validChoice = true;
        int choice;

        do {
            choice = displayChoice();
            switch (choice) {
                case 1:
                    menu.addFood();
                    break;
                case 2:
                    menu.removeFood();
                    break;
                case 3:
                    menu.setFoodStatus();
                    break;
                case 4:
                    menu.showMenu();
                    break;
                case -1:
                default:
                    validChoice = false;
                //go back
            }
        } while (!validChoice);
    }

    @Override
    public String toString() {
        return String.format("%5d %10s %15s %20s %10s", ID, ownerName, restaurantName, address, contactNo);
    }

    public static Affiliate login(AffiliateInterface[] affiliate) {
        Boolean validLogin = false;
        Scanner reader = new Scanner(System.in);

        do {
            System.out.println("Enter ID: ");
            int ID = Integer.parseInt(reader.nextLine());
            System.out.println("Enter password: ");
            String password = reader.nextLine();

            for (int i = 0; i < nextID - 1; ++i) {
                if (affiliate[i].getID() == ID && affiliate[i].getPassword().equals(password)) {
                    validLogin = true;
                    System.out.println("Welcome, " + affiliate[i].getOwnerName());
                    System.out.println("============================");
                    return (Affiliate) affiliate[i];
                }
            }
            return null;
        } while (!validLogin);
    }

    public static Affiliate registerAffiliate() {
        //this method is for restaurant onwer to register as an affiliate
        //if the restaurant onwer registered succesfull
        //he/she will required to login with new given ID
        
        Scanner reader = new Scanner(System.in);
        String ownerName, restaurantName, address, contactNo, password;
        Boolean validRegistration;

        do {
            System.out.println("Enter owner name: ");
            ownerName = reader.nextLine();
            System.out.println("Enter password: ");
            password = reader.nextLine();
            System.out.println("Enter restaurant name: ");
            restaurantName = reader.nextLine();
            System.out.println("Enter address of restaurant: ");
            address = reader.nextLine();
            System.out.println("Enter contact number: ");
            contactNo = reader.nextLine();

            if (!ownerName.equals("") && !restaurantName.equals("") && !address.equals("")) {
                Affiliate newAffiliate = new Affiliate(ownerName, password, restaurantName, address, contactNo);
                System.out.println("===============================");
                System.out.println("Registration successfull! Please login with the following ID");
                System.out.println("Your ID: " + newAffiliate.ID);
                System.out.println("===============================");
                validRegistration = true;
                return newAffiliate;
                //continue here
                //save in to .dat file
            } else {
                System.out.println("===============================");
                System.out.println("Please do not leave blank space");
                System.out.println("===============================");
                validRegistration = false;
                return null;
            }
        } while (!validRegistration);
    }
}
