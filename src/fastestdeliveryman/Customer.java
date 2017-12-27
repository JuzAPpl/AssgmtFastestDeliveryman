/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import ADT.LinkedList;
import ADT.ListWithIteratorInterface;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Customer {

    ListWithIteratorInterface<Food> cart = new LinkedList<>();

    public ListWithIteratorInterface<Food> getCart() {
        return cart;
    }

    public void setCart(ListWithIteratorInterface<Food> cart) {
        this.cart = cart;
    }

    public Customer() {

    }

    public void login() {
        System.out.print("Press enter to continue as customer!");
        Scanner in = new Scanner(System.in);
        in.nextLine();

        //TODO: cust id and pw vaidation
        int menuSel;
        do {
            boolean emptyCart = cart.isEmpty();
            //TODO: display list of selection available for customer
            System.out.println("Enter 1: Order food");
            if (!emptyCart) {
                System.out.println("Enter 7: Check out with my ordered items.");
                System.out.println("Enter 8: View my shopping cart");
                System.out.println("Enter 9: Clear my shopping cart");
            }
            System.out.println("Enter 0: Log out");
            System.out.print("Please enter your selection:");
            menuSel = in.nextInt();
            switch (menuSel) {
                case 1:
                    orderFoodMenu();
                    break;
                case 7:
                    if (!emptyCart) {
                        checkOut();
                    }
                    break;
                case 8:
                    if (!emptyCart) {
                        displayCart();
                    }
                    break;
                case 9:
                    if (!emptyCart) {
                        clearCart();
                    }
                    break;
                case 0:
                    System.out.println("You have been logged out successfully.");
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        } while (menuSel != 0);
    }

    private void orderFoodMenu() {
        Scanner in = new Scanner(System.in);

        int menuSel = 0;
        boolean firstRun = true;
        do {
            if (!cart.isEmpty()) {
                //Redirect customer to menu if there is something in the cart
                System.out.println("There is something in your shopping cart. Clear the cart if you want to browse in other restaurants.");
                viewMenu(cart.getEntry(1).getFoodOwner());
                break;
            } else {
                Affiliate selectedAffiliate = null;

                //TODO: display list of selection available for customer
                System.out.println("Enter 1: Browse restaurants");
                System.out.println("Enter 2: Search for food");
                System.out.println("Enter 0: Back to prevous menu");
                System.out.print("Please enter your selection:");
                menuSel = in.nextInt();
                switch (menuSel) {
                    case 1:
                        selectedAffiliate = browseRestaurants();
                        break;
                    case 2:
                        selectedAffiliate = searchFood();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Invalid input!");
                        break;
                }
                if (selectedAffiliate != null) {
                    viewMenu(selectedAffiliate);
                    selectedAffiliate = null;
                    if (!cart.isEmpty()) {
                        break;
                    }
                }
            }
        } while (menuSel != 0);
    }

    private Affiliate browseRestaurants() {

        Scanner scanner = new Scanner(System.in);
        int sel;
        do {
            System.out.println(Affiliate.getHeader());
            System.out.println(Affiliate.affiliates);
            System.out.println("0: Cancel");
            System.out.print("Please enter your selection: ");
            sel = Integer.parseInt(scanner.nextLine());
            if (sel > 0) {
                Iterator iterator = Affiliate.affiliates.getIterator();
                while (iterator.hasNext()) {
                    Affiliate aff = (Affiliate) iterator.next();
                    if (aff.getID() == sel) {
                        return aff;
                    }
                }
            } else if (sel != 0) {
                System.out.println("Invalid input!");
            }
        } while (sel != 0);
        return null;
    }

    private Affiliate searchFood() {
        //Redirect to affiliate if customer wants to order (business rule: one affiliate per order)
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the food name(or part of the food name) you want to search: ");
        String keyword = scanner.nextLine();

        ListWithIteratorInterface<Food> results = new LinkedList<>();
        //Loop through affiliates collection
        Iterator iterator = Affiliate.affiliates.getIterator();
        while (iterator.hasNext()) {
            Affiliate aff = (Affiliate) iterator.next();
            Menu currentMenu = aff.getMenu();

            Iterator foodIterator = currentMenu.getMenu().getIterator();
            while (foodIterator.hasNext()) {
                Food currentFood = (Food) foodIterator.next();
                for (int k = 0; k < currentFood.getName().length() - (keyword.length() - 1); k++) {
                    if (currentFood.getName().substring(k, k + keyword.length()).equalsIgnoreCase(keyword)) {
                        results.add(currentFood);
                        break;
                        //break is required to prevent repeated records when there are 2 matches in a single name
                    }
                }
            }
        }

        if (!results.isEmpty()) {
            //print list of matches found
            iterator = results.getIterator();
            System.out.println(Food.getFoodHeader());
            int count = 0;
            while (iterator.hasNext()) {
                System.out.println(String.format("%-5d", ++count) + ((Food) (iterator.next())).toStringWithoutID());
            }

            iterator = results.getIterator();
            int sel;
            do {
                System.out.println("You will be redirected to the restaurant when a food is selected");
                System.out.print("Please enter your selection(0 to cancel): ");
                sel = Integer.parseInt(scanner.nextLine());

                if (sel > 0 && sel <= results.getNumberOfEntries()) {
                    Food temp = results.getEntry(sel);
                    return temp.getFoodOwner();

                } else if (sel != 0) {
                    System.out.println("Invalid input!");
                }
            } while (sel != 0);
        } else {
            System.out.println("No matching results.");
        }
        return null;
    }

    private void addFoodToCart(Food food) {
        //Show food details
        System.out.println(Food.getFoodHeader());
        System.out.println(food);
        //Prompt user to enter qty(0 to cancel)
        int qty;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter the quantity you want to order(0 to cancel): ");
            qty = scanner.nextInt();
            if (qty < 0) {
                System.out.println("Invalid input!");
            }
        } while (qty < 0);
        //Add food to list using a loop,
        if (qty > 0) {
            for (int i = 0; i < qty; i++) {
                cart.add(food);
            }
            System.out.println(qty + " " + food.getName() + " has been added to your cart.");
        } else {
            System.out.println("Returning to previous menu...\n");
        }

    }

    private void checkOut() {
        //create new order using cart and store it into affiliate
        if (!cart.isEmpty()) {
            Affiliate aff = cart.getEntry(1).getFoodOwner();
            Order newOrder = Order.newOrder(cart);
            aff.getAdHocOrders().enqueue(newOrder);

            System.out.println("Order successful. Estimated arrive time: " + newOrder.getArrivalTime().toLocaleString());
            cart.clear();

        } else {
            System.out.println("You have ordered nothing!");
        }
    }

    public void displayCart() {
        if (!cart.isEmpty()) {
            System.out.println("You have ordered:");
            System.out.println(Food.getFoodHeader());
            double subTotal = 0;
            int currentFoodCount = 0;
            Food previousFood = cart.getEntry(1);
            Food temp = null;
            Iterator it = cart.getIterator();
            while (it.hasNext()) {
                //calculate subtotal
                //count number of food
                temp = (Food) it.next();
                subTotal += temp.getPrice();
                if (previousFood.getID() == temp.getID()) {
                    currentFoodCount++;
                } else {
                    System.out.println(temp + String.format("Quantity: %-10d", currentFoodCount));
                    previousFood = temp;
                    currentFoodCount = 1;
                }
            }
            System.out.println(temp + String.format("Quantity: %-10d", currentFoodCount));
            System.out.println("Sub total: RM" + String.format("%.2f", subTotal));
        } else {
            System.out.println("Your cart is empty. \n");
        }
    }

    private void viewMenu(Affiliate aff) {
        Menu currentMenu = aff.getMenu();
        Scanner scanner = new Scanner(System.in);
        int sel;

        do {

            //show list of food
            System.out.printf(Food.getFoodHeader());
            System.out.println(currentMenu.toString());

            //prompt user to enter selection and add to cart
            System.out.print("Please enter your selection(0 to exit): ");
            sel = Integer.parseInt(scanner.nextLine());

            Iterator temp = currentMenu.getMenu().getIterator();
            Food result;
            boolean found = false;
            while (!found && temp.hasNext()) {
                result = (Food) temp.next();
                if (result.getID() == sel) {
                    addFoodToCart(result);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Invalid input!");
            }
        } while (sel != 0);
    }

    private void clearCart() {
        Scanner scanner = new Scanner(System.in);
        displayCart();
        if (!cart.isEmpty()) {
            char sel;
            do {
                System.out.print("Do you really want to clear your shopping cart?(Y/N): ");
                sel = Character.toUpperCase(scanner.nextLine().charAt(0));
                if (sel == 'Y') {
                    cart.clear();
                } else if (sel != 'N') {
                    System.out.println("Invalid input!\n");
                }

            } while (sel != 'Y' && sel != 'N');
        }
    }
}
