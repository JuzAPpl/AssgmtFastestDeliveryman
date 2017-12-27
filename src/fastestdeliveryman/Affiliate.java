/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import ADT.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 * @author Lim Fang Chun
 */
public class Affiliate implements AffiliateInterface, Serializable {

    public final static String ACC_STATUS_ACTIVE = "Active";
    public final static String ACC_STATUS_DEACTIVATED = "Deactivated";

    private int ID;
    private String ownerName;
    private String password;
    private Location address;
    private String restaurantName;
    private String contactNo;
    private Menu menu;
    private QueueInterface<Order> adHocOrders = new SortedLinkedQueue<>();
    private static int nextID = 1;
    private String accStatus;
    public static SortedListWithIteratorInterface<AffiliateInterface> affiliates = new SortedList<>();

    public Affiliate() throws IOException {
        this.ID = nextID;
        this.ownerName = "";
        this.password = "";
        this.restaurantName = "";
        this.contactNo = "";
        this.menu = new Menu();
        accStatus = ACC_STATUS_DEACTIVATED;
        ++nextID;
    }

    public Affiliate(String ownerName, String password, String restaurantName, String address, String contactNo) throws IOException {
        this.ID = nextID;
        this.ownerName = ownerName;
        this.password = password;
        this.restaurantName = restaurantName;
        this.contactNo = contactNo;
        this.menu = new Menu();
        accStatus = ACC_STATUS_ACTIVE;
        ++nextID;
    }
    
    public Affiliate(String ownerName, String restaurantName, Location address, String contactNo, Menu menu) {
        this.ID = nextID;
        this.ownerName = ownerName;
        //this.password = password;
        this.restaurantName = restaurantName;
        this.address = address;
        this.contactNo = contactNo;
        this.menu = menu;
        accStatus = ACC_STATUS_ACTIVE;
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
    public Location getAddress() {
        return address;
    }

    @Override
    public void setAddress() {
        this.address = Location.getLocation();
    }

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

    public String getAccStatus() {
        return accStatus;
    }

    public void setAccStatus(String accStatus) {
        this.accStatus = accStatus;
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

    public QueueInterface<Order> getAdHocOrders() {
        return adHocOrders;
    }

    public void setAdHocOrders(QueueInterface<Order> adHocOrders) {
        this.adHocOrders = adHocOrders;
    }

    @Override
    public Menu getMenu() {
        //this method will return an object Menu
        return menu;
    }

    @Override
    public void setMenu() {
        Scanner reader = new Scanner(System.in);
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
                    menu.setFoodDetail();
                    break;
                case 4:
                    System.out.println(menu.toString());
                    break;
                case -1:
//                default: {
//                    try {
//                        Menu.saveMenu(menu.getMenu());
//                        //go back
//                    } catch (IOException ex) {
//                        Logger.getLogger(Affiliate.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
            }

            System.out.println("====================================================");
            System.out.println("Do you want to continue modifying your menu? (Y/N): ");
            char cont = reader.next().charAt(0);
            cont = Character.toUpperCase(cont);
            validChoice = cont == 'N';
        } while (!validChoice);
    }

    @Override
    public String toString() {
        return String.format("%5d %10s %15s %20s %20s\n", ID, ownerName, restaurantName, address, contactNo);
    }

    public static String getHeader() {
        return String.format("%5s %10s %15s %20s %20s\n", "ID", "Owner", "Restaurant Name", "Location", "Contact number");
    }

    public static Affiliate login(SortedListWithIteratorInterface<AffiliateInterface> affiliate) {
        Scanner reader = new Scanner(System.in);
        boolean validLogin = true;

        do {
            System.out.println("Enter ID: ");
            int ID = Integer.parseInt(reader.nextLine());
            System.out.println("Enter password: ");
            String password = reader.nextLine();

            Iterator temp = affiliate.getIterator();
            while (temp.hasNext()) {
                Affiliate currentAffiliate = (Affiliate) temp.next();
                if (currentAffiliate.getID() == ID && currentAffiliate.getPassword().equals(password)) {
                    System.out.println("Welcome, " + affiliate.getEntry(ID).getOwnerName());
                    System.out.println("============================");
                    return (Affiliate) affiliate.getEntry(ID);
                }
            }

            System.out.println("======================");
            System.out.println("Invalid ID or password");
            System.out.println("Please try again");
            System.out.println("======================");
            validLogin = false;
        } while (!validLogin);
        return null;
    }

    public static Affiliate registerAffiliate() throws IOException {
        //this method is for restaurant onwer to register as an affiliate
        //if the restaurant onwer registered succesfull
        //he/she will required to login with new given ID

        Scanner reader = new Scanner(System.in);
        String ownerName, restaurantName, address, contactNo, password;
        Boolean validRegistration = true;

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
                System.out.println("============================================================");
                System.out.println("Registration successfull! Please login with the following ID");
                System.out.println("Your ID: " + newAffiliate.ID);
                System.out.println("============================================================");

                return newAffiliate;
                //continue here
                //save in to .dat file

            } else {
                System.out.println("===============================");
                System.out.println("Please do not leave blank space");
                System.out.println("===============================");
                validRegistration = false;
            }
        } while (!validRegistration);
        return null;
    }

    public static void saveAffiliate(SortedListWithIteratorInterface<AffiliateInterface> newAffiliate) throws IOException {
        ObjectOutputStream is = null;
        try {
            String fileName = "Affiliate.bin";
            is = new ObjectOutputStream(new FileOutputStream(fileName));
            Iterator temp = newAffiliate.getIterator();
            while (temp.hasNext()) {
                Affiliate currentAffiliate = (Affiliate) temp.next();
                is.writeObject(currentAffiliate);
            }
        } catch (FileNotFoundException ex) {

        } finally {
            try {
                is.close();
            } catch (IOException | NullPointerException ex) {

            }
        }
    }

    public static void initializeAffiliate(SortedListWithIteratorInterface<AffiliateInterface> affiliate) throws IOException {
        ObjectInputStream is = null;
        try {
            //TODO: read from binary file
            String fileName = "Affiliate.bin";
            is = new ObjectInputStream(new FileInputStream(fileName));
            while (true) {
                Affiliate temp = (Affiliate) is.readObject();
                affiliate.add(temp);
            }
        } catch (ClassNotFoundException | EOFException | FileNotFoundException | InvalidClassException ex) {

        } finally {
            try {
                is.close();
            } catch (IOException | NullPointerException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void initializeAffiliate() { 
        ListWithIteratorInterface locations = Location.map;
        //Dummy data: to be replaced after implementation of reading objects from binary files
        Food food1 = new Food(1, "Delicious Kuey Teow", 4.99, 5, Food.FOOD_UNAVAILABLE);
        Food food2 = new Food(2, "East DonDong Fried Chicken", 9.99, 7.6, Food.FOOD_AVAILABLE);
        Food food3 = new Food(3, "Super Mega Jumbo Burger", 8.79, 10, Food.FOOD_PROMOTION);

        Food[] foodArr0 = {food1, food2, food3};
        Menu menu0 = new Menu(foodArr0);

        Affiliate affiliate0 = new Affiliate("East DonDong", "Mac DonDong's", (Location)locations.getEntry(2), "011-2334567", menu0);

        Food food4 = new Food(1, "Very Delicious Kuey Teow", 4.99, 5, Food.FOOD_UNAVAILABLE);
        Food food5 = new Food(2, "West DonDong Fried Chicken", 9.99, 7.6, Food.FOOD_AVAILABLE);
        Food food6 = new Food(3, "Super Mega Giga Jumbo Burger", 8.79, 10, Food.FOOD_PROMOTION);

        Food[] foodArr1 = {food4, food5, food6};
        Menu menu1 = new Menu(foodArr1);

        Affiliate affiliate1 = new Affiliate("West DonDong", "Mac DinDing's", (Location)locations.getEntry(4), "011-2334567", menu1);
        
        food1.setFoodOwner(affiliate0);
        food2.setFoodOwner(affiliate0);
        food3.setFoodOwner(affiliate0);
        food4.setFoodOwner(affiliate1);
        food5.setFoodOwner(affiliate1);
        food6.setFoodOwner(affiliate1);
        //End of dummy data
        Affiliate.affiliates.add(affiliate0);
        Affiliate.affiliates.add(affiliate1);
        
        Location.initializeAffiliateLocation(affiliate0);
        Location.initializeAffiliateLocation(affiliate1);
    }

    @Override
    public int compareTo(AffiliateInterface t) {
        if (this.ID == t.getID()) {
            return 0;
        } else if (this.ID > t.getID()) {
            return 1;
        } else {
            return -1;
        }
    }
}
