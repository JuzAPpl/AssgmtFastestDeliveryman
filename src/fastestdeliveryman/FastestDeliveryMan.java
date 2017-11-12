
package fastestdeliveryman;

import java.util.*;

/**
 *
 * @author Leo
 */
public class FastestDeliveryMan {
    
    private static AffiliateInterface affiliate;
    
    public static void registerAffiliate(){
        //this method is for restaurant onwer to register as an affiliate
        
        Scanner reader = new Scanner(System.in);
        
        String ownerName, restaurantName, address, contactNo;
        
        System.out.println("Enter owner name: ");
        ownerName = reader.nextLine();
        System.out.println("Enter restaurant name: ");
        restaurantName = reader.nextLine();
        System.out.println("Enter address of restaurant: ");
        address = reader.nextLine();
        System.out.println("Enter contact number: ");
        contactNo = reader.nextLine();
        
        if(!ownerName.equals("") && !restaurantName.equals("") && !address.equals("")){
            affiliate = new Affiliate(ownerName, restaurantName, address, contactNo);
            //continue here
            //save in to .dat file
        }
        else{
            System.out.println("Please do not leave blank");
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        registerAffiliate();
        System.out.println(affiliate.toString());
    }
    
}
