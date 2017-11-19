
package fastestdeliveryman;

import java.util.Scanner;

/**
 *
 * @author Leo
 */
public class FastestDeliveryMan {
    
    private static AffiliateInterface[] affiliate = new Affiliate[100];
    private static Object currentUser;
    private static int countAffiliate = 0;
    private static Scanner reader = new Scanner(System.in);
    
    public static void registerAffiliate(){
        //this method is for restaurant onwer to register as an affiliate
        
        Scanner reader = new Scanner(System.in);
        
        String ownerName, restaurantName, address, contactNo, password;
        
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
        
        if(!ownerName.equals("") && !restaurantName.equals("") && !address.equals("")){
            affiliate[countAffiliate] = new Affiliate(ownerName, password, restaurantName, address, contactNo);
            //continue here
            //save in to .dat file
        }
        else{
            System.out.println("Please do not leave blank");
        }
    }
    
    public static void login(){
        System.out.println("Enter ID: ");
        int ID = Integer.parseInt(reader.nextLine());
        System.out.println("Enter password: ");
        String password  = reader.nextLine();
        
        for(int i = 0 ; i < countAffiliate ; ++i){
            if(affiliate[i].getID() == ID && affiliate[i].getPassword().equals(password)){
                currentUser = affiliate[i];
                return;
            }
        }
    }
    
    public static void displayAffiliateChoice(){
        System.out.println("Welcome, ");
        System.out.println("Please enter a number to select option");
        System.out.println("1. Display items in menu");
        System.out.println("2. Add an item to menu");
        System.out.println("3. Remove an item from menu");
        System.out.println("4. Change status of item in menu");
        System.out.println("-1. Exit");
        System.out.println("Your choice: ");
        int choice = Integer.parseInt(reader.nextLine());
        
        switch(choice){
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case -1:
            default:
                System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Welcome to Fastest Delivery Man");
        System.out.println("Please enter a number to select option");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("-1. Exit");
        System.out.println("Your choice");
        
        int choice = Integer.parseInt(reader.nextLine());
        
        switch(choice){
            case 1:
                login();
                break;
            case 2:
                registerAffiliate();
                break;
            case -1:
            default:
                System.exit(0);
        }
        
        //registerAffiliate();
        //System.out.println(affiliate.toString());
    }
    
}
