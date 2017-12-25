/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import ADT.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class TestCustomer {

    /**
     * @param args the command line arguments
     */
<<<<<<< HEAD:src/fastestdeliveryman/TestCustomer.java
    public static void main(String[] args) {
        Customer cust = new Customer();
        cust.login();
//        LinkedList<AffiliateInterface> a = new LinkedList<>();
=======
    public static void main(String[] args) throws IOException {
        //Customer cust = new Customer();
        //cust.login();
//        SortedList<AffiliateInterface> a = new SortedList<>();
>>>>>>> Sprint-3-LimFangChun:src/fastestdeliveryman/TestDisplayMenu.java
//        a.add(new Affiliate("kappa", "123", "333", "222", "111"));
//        a.add(new Affiliate("keepo", "123", "resName", "address", "contact"));
//        System.out.println(a);

//        LinkedList<Food> a = new LinkedList<>();
//        a.add(new Food(1, "Cake", 2, 3, 0));
//        a.add(new Food(2, "Coke", 3, 1, 1));
//        System.out.println(a);
<<<<<<< HEAD:src/fastestdeliveryman/TestCustomer.java
=======

//            LinkedFoodListInterface<Food> a = new LinkedList<>();
//            a.add(new Food(1, "Cake", 2, 3, 1));
//            System.out.println(a.getFoodByID(1));
//        MenuInterface a = new Menu();
//        a.addFood();
//        a.addFood();
//        a.addFood();
//        a.setFoodDetail();
//        a.setFoodDetail();
//        a.setFoodDetail();
//        a.setFoodDetail();
//        System.out.println(a);
//        ListWithIteratorInterface<Food> f = new LinkedList();
//        f.add(new Food(1, "Cake", 2, 3, 1));
//        f.add(new Food(2, "Coke", 3, 1, 1));
//        
//        Iterator g = f.getIterator();
//        while(g.hasNext()){
//            Food aa = (Food) g.next();
//            System.out.println(aa.getID());
//        }
//        String fileName = "test.bin";
//        Food f = new Food(1, "Cake", 2, 3, 1);
//        Food f2 =  new Food(2, "Coke", 3, 1, 1);
//        try {
//            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
//            os.writeObject(f);
//            os.writeObject(f2);
//            os.close();
//            ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
//            
//            Food asd = (Food) is.readObject();
//            System.out.println(asd);
//            Food aaa = (Food) is.readObject();
//            System.out.println(aaa);
//            is.close();
//        } catch (FileNotFoundException | ClassNotFoundException ex) {
//            Logger.getLogger(TestDisplayMenu.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Menu a = new Menu();
//        a.addFood();
//        a.saveMenu();
//        a.initializeMenu();
//        System.out.println(a);
//        TestDisplayMenu a = new TestDisplayMenu();
//        a.start();

//        SortedListInterface<Food> a = new SortedList();
//        Food f1 = new Food(2, "Coke", 3, 1, 1);
//        Food f2 = new Food(1, "Cake", 2, 3, 1);
//        Food f3 = new Food(4, "nani", 3, 1, 1);
//        Food f4 = new Food(3, "4896", 3, 1, 1);
//        a.add(f1);
//        a.add(f2);
//        a.add(f3);
//        a.add(f4);
//        System.out.println(a);
//        System.out.println("length = " + a.getLength());
//        
//        a.remove(f1);
//        System.out.println(a);
//        System.out.println("length = " + a.getLength());
    }

    int sec = 5;
    Timer t = new Timer();
    TimerTask task = new TimerTask() {
        public void run() {
            if (sec == 0) {
                t.cancel();
                t.purge();
                return;
            }
            System.out.println(sec);
            sec--;       
        }
    };

    public void start() {
        
        t.scheduleAtFixedRate(task, 1000, 1000);
>>>>>>> Sprint-3-LimFangChun:src/fastestdeliveryman/TestDisplayMenu.java
    }
}
