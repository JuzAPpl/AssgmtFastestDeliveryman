/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import ADT.*;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Location {

    public static ListInterface<Location> map;
    
    private int index;
    private String locationName;

    private ListInterface<Affiliate> restaurants = new LinkedList<>();
     private QueueInterface<DeliveryOrder> deliveryRequestQueue = new LinkedQueue<>();

    public Location(int index, String locationName) {

        this.index = index;
        this.locationName = locationName;
    }

    public Location() {

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getLocationName() {
        return locationName;
    }
      public DeliveryOrder assignDeliveryOrder(){
        return deliveryRequestQueue.dequeue();
    }

    // ???
//    public void selectLocation() {
//        Location local = new Location();
//
//        int location;
//        Scanner scan = new Scanner(System.in);
//        System.out.println("\nAdding The Scheduled Order");
//        System.out.println("1. Location 1");
//        System.out.println("2. Location 2");
//        System.out.println("3. Location 3");
//        System.out.println("4. Location 4");
//        System.out.println("5. Location 5");
//        System.out.println("6. Location 6");
//        System.out.println("Please select the day(s) you want to make order: ");
//        location = scan.nextInt();
//        switch (location) {
//            case 1:
//                local.setAddress("Location 1");
//                local.setIndex(location);
//                break;
//            case 2:
//                local.setAddress("Location 2");
//                local.setIndex(location);
//                break;
//            case 3:
//                local.setAddress("Location 3");
//                local.setIndex(location);
//                break;
//            case 4:
//                local.setAddress("Location 4");
//                local.setIndex(location);
//                break;
//            case 5:
//                local.setAddress("Location 5");
//                local.setIndex(location);
//                break;
//            case 6:
//                local.setAddress("Location 6");
//                local.setIndex(location);
//                break;
//            default:
//        }
//    }
    
    public static void initializeAffiliates(){
        //TODO: load affiliates from binary file and add them into the map
        
    }
}
