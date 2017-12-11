package fastestdeliveryman;

import java.util.Scanner;
import ADT.*;

/**
 *
 * @author Leo
 */
public class FastestDeliveryMan {

    private static final LinkedList<AffiliateInterface> AFFILIATE = new LinkedList<>();
    private static Object currentUser;
    public static int countAffiliate = 0;
    private static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("Welcome to Fastest Delivery Man");
        System.out.println("Please enter a number to select option");
        System.out.println("1. Login as affiliate");
        System.out.println("2. Register");
        System.out.println("-1. Exit");
        System.out.println("Your choice");

        int choice = Integer.parseInt(reader.nextLine());

        switch (choice) {
            case 1:
                currentUser = Affiliate.login(AFFILIATE);
                break;
            case 2:
                Affiliate newAffiliate = Affiliate.registerAffiliate();
                if (newAffiliate != null) {
                    AFFILIATE.add(newAffiliate);
                    currentUser = Affiliate.login(AFFILIATE);
                }
                break;
            case -1:
            default:
                System.out.println("=================================");
                System.out.println("Thank You. Please come back again");
                System.out.println("=================================");
                System.exit(0);
        }

        if (currentUser instanceof Affiliate) {
            Affiliate currentAffiliate = (Affiliate) currentUser;
            currentAffiliate.setMenu();
        } else {
            System.out.println("Invalid ID or password");
        }

        System.out.println("=================================");
        System.out.println("Thank You. Please come back again");
        System.out.println("=================================");
    }

}
