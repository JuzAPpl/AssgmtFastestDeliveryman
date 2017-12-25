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
    private QueueInterface<Order> orders= new SortedLinkedQueue<>();
    private static int nextID = 1;
    private String accStatus;

    public Affiliate() {
        this.ID = nextID;
        this.ownerName = "";
        this.password = "";
        this.restaurantName = "";
        this.contactNo = "";
        this.menu = new Menu();
        accStatus = ACC_STATUS_DEACTIVATED;
        ++nextID;
    }

    public Affiliate(String ownerName, String password, String restaurantName, String address, String contactNo) {
        this.ID = nextID;
        this.ownerName = ownerName;
        this.password = password;
        this.restaurantName = restaurantName;
        this.contactNo = contactNo;
        this.menu = new Menu();
        accStatus = ACC_STATUS_ACTIVE;
        ++nextID;
    }

    public Affiliate(String ownerName, String restaurantName, String address, String contactNo, Menu menu) {
        this.ID = nextID;
        this.ownerName = ownerName;
        //this.password = password;
        this.restaurantName = restaurantName;
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
    public String getAddress() {
        return new String();
    }

    @Override
    public void setAddress(String address) {
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
                default:

                //go back
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
        return String.format("%5d %10s %15s %20s %10s\n", ID, ownerName, restaurantName, address, contactNo);
    }

    public static Affiliate login(SortedListWithIteratorInterface<AffiliateInterface> affiliate) {
        Scanner reader = new Scanner(System.in);
        boolean validLogin = true;

        do {
            System.out.println("Enter ID: ");
            int ID = Integer.parseInt(reader.nextLine());
            System.out.println("Enter password: ");
            String password = reader.nextLine();

            if (affiliate.getEntry(ID).getID() == ID && affiliate.getEntry(ID).getPassword().equals(password)) {
                System.out.println("Welcome, " + affiliate.getEntry(ID).getOwnerName());
                System.out.println("============================");
                return (Affiliate) affiliate.getEntry(ID);
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
        } catch (ClassNotFoundException | EOFException | FileNotFoundException ex) {

        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
