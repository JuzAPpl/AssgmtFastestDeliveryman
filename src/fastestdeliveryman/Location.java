/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import ADT.*;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Location {

    public static ListWithIteratorInterface<Location> map = new LinkedList<>();

    private int index;
    private String locationName;

    private ListWithIteratorInterface<Affiliate> restaurants = new LinkedList<>();

    public Location(int index, String locationName) {
        this.index = index;
        this.locationName = locationName;
    }

    public Location() {

    }

    public int getIndex() {
        return index;
    }

    public String getLocationName() {
        return locationName;
    }

    public String toString() {
        return String.format("%-5d\t%-30s", index, locationName);
    }

    public double getTravelTime(Location loc) {
        //return time used to travel from this location to given location
        return Math.abs(this.index - loc.index) + 1;
    }
    
    public ListWithIteratorInterface getRestaurantsAt(int index){
       Iterator it = map.getIterator();
       Location temp;
        while (it.hasNext()) {
            temp = (Location)it.next();
            if(temp.index == index){
                return temp.restaurants;
            }
        } 
        return null;
    }
    

//    public void selectLocation() {
//        Location local = new Location();
//
//        int location;
//        Scanner scan = new Scanner(System.in);
//        System.out.println("1. Location 1");
//        System.out.println("2. Location 2");
//        System.out.println("3. Location 3");
//        System.out.println("4. Location 4");
//        System.out.println("5. Location 5");
//        System.out.println("6. Location 6");
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
    public static void initializeAffiliateLocation(Affiliate aff) {
        Iterator it = map.getIterator();
        while (it.hasNext()) {
            Location loc = (Location) it.next();
            if (aff.getAddress().getIndex() == loc.getIndex()) {
                loc.restaurants.add(aff);
                break;
            }
        }
    }

    public static Location getLocation() {
        Iterator it = map.getIterator();
        System.out.println(String.format("%-5s\t%-30s", "No", "Location"));
        while (it.hasNext()) {
            //print out list of location
            System.out.println(it.next());

        }

        Location loc = null;
        boolean found = false;
        Scanner in = new Scanner(System.in);
        do {
            //user input: index
            System.out.println("Please enter your selection(0 to cancel): ");
            int sel = in.nextInt();
            if (sel == 0) {
                break;
            }

            it = map.getIterator();

            while (!found && it.hasNext()) {
                //loop through the list once more and return the location if index matches
                loc = (Location) it.next();
                if (sel == loc.getIndex()) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Invalid input. Please try again.\n");
            }
        } while (!found);

        return loc;
    }

    public static void initializeMap() {
        map.add(new Location(1, "Taman Desa Setapak"));
        map.add(new Location(2, "Genting Klang"));
        map.add(new Location(3, "Taman Bunga Raya"));
        map.add(new Location(4, "PV10"));
        map.add(new Location(5, "PV13"));
        map.add(new Location(6, "PV15"));
    }
}
