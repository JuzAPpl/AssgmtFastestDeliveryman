/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import ADT.ListInterface;
import java.util.Scanner;

/**
 *
 * @author Ng Pei Xiang
 */
public class Executive extends Employee{
    private double allowance;
    private String officeRoomNo;

    public Executive() {
    }

    public Executive(double allowance, String officeRoomNo, String empName, String empID, String empIC, char gender, String contactNo, String address, double salary) {
        super(empName, empID, empIC, gender, contactNo, address, salary);
        this.allowance = allowance;
        this.officeRoomNo = officeRoomNo;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public String getOfficeRoomNo() {
        return officeRoomNo;
    }

    public void setOfficeRoomNo(String officeRoomNo) {
        this.officeRoomNo = officeRoomNo;
    }
    
    /**
     *
     * @param employeeList
     * A method to allow executive to select a function to execute
     * Last edited: 17/12/2017
     * Last edited by: Ng Pei Xiang
     */
    public void displayMenu(ListInterface<Employee> employeeList){        
        java.util.Scanner scanner = new Scanner(System.in);
        int userSelection = -1;        
        while(userSelection != 0){
            System.out.println("Please select an action to perform:");
            System.out.println("1. Add new delivery man");
            System.out.println("2. Update delivery man's information");
            System.out.println("3. Track delivery");
            System.out.println("0. Exit\n");
            System.out.print("Your selection: ");
            userSelection = scanner.nextInt();
        
            switch(userSelection)
            {
                case 1: addStaff(employeeList);
                break;
                case 2: editStaff(employeeList);
                break;
//                case 3: retrievePendingDeliveries();
//                break;
                default: System.out.println("Sorry, invalid selection.\n"); 
                break;
                case 0: break;
            }
        }
    }
    
    /**
     *
     * @param employeeList
     * A method allow the executive to add a new delivery man to the existing employee list
     * Last edited: 17/12/2017
     * Last edited by: Ng Pei Xiang
     */
    public void addStaff(ListInterface<Employee> employeeList){
        //TODO:Add new staff.
        //Variable declaration
        String name = "";
        Character gender;
        Integer age;
        String identityCard;
        String contactNo;
        boolean validName=false, validPhoneNo=false, validGender=false, validAge=false, validIC=false;
        
        //Read user input for required data field
        Scanner scanner = new Scanner(System.in);               
        System.out.println("===Please Enter New Delivery Man's Details===");
        while(!validName){
            System.out.print("1. Name: ");
            name = scanner.nextLine();
            validName = validateName(name);
            if (!validName)
                System.out.println("Sorry, invalid name is detected. Name should contains only letters.");
        }        
        while(!validGender){
            System.out.print("2. Gender(M/F): ");
            gender = scanner.next().charAt(0);
            gender = Character.toUpperCase(gender);
            validGender = validateGender(gender);
            if (!validGender)
                System.out.println("Sorry. Invalid gender.");
        }
        while(!validAge){
            System.out.print("3. Age: ");
            age = scanner.nextInt();
            validAge = validateAge(age);
            if(!validAge)
                System.out.println("Sorry, the age of delivery man must be at least 18 and at most 55.");
        }
        while(!validIC)
        {
            System.out.print("4. Identity Card(without dash): ");
            identityCard = scanner.nextLine();
            validIC = validateIC(identityCard);
            if(!validIC)
                System.out.println("Sorry, the identity card number must be all digits.");
        }
        while(!validPhoneNo)
        {
            System.out.print("5. Contact No: ");
            contactNo = scanner.nextLine();
            validPhoneNo = validateContactNo(contactNo);
            if(!validPhoneNo){
                System.out.println("Sorry. Invalid phone number format is inserted.");
            }
        }
        //Read user's response to confirm the add new staff process 
        System.out.print("Do you want to add " + name + " as new Deliveryman?(Y/N)");
        char userResponse = ' ';
        while(userResponse != 'Y' && userResponse != 'N'){
            userResponse = scanner.next().charAt(0);
            userResponse = Character.toUpperCase(userResponse); 
            System.out.println("Sorry, invalid input. Please select Y: Yes or N: No.");
        }
        if (userResponse == 'Y'){
//            Employee newDeliveryMan = new DeliveryMan();
//            employeeList.add(newDeliveryMan);
//            System.out.println("New deliveryman "+ name + "is successfully added!");
//            System.out.println("==Information of new deliveryman==\n" + newDeliveryMan);

        }else{
            System.out.println("You just aborted an adding staff execution! Have a nice day!");
        }
    }
    
    /**
     *
     * @param employeeList
     * A method allow the executive to edit the existing delivery man contact information
     * Last edited: 17/12/2017
     * Last edited by: Ng Pei Xiang 
     */
    public void editStaff(ListInterface<Employee> employeeList){
        
    }
    
//    public void retrievePendingDeliveries(ListInterface<Employee> deliveryManList){
//        int count =0;
//        if(deliveryManList.getNumberOfEntries() != 0){
//            System.out.println("===Delivery Man Tracking===");
//            System.out.println("Please select a delivery man to continue: ");
//            for(int i=1; i<= deliveryManList.getNumberOfEntries(); i++)
//            {
//                DeliveryMan tempDeliveryman = (DeliveryMan)deliveryManList.getEntry(i);
//                System.out.println(++count + ". " + tempDeliveryman.toString());
//            }
//            java.util.Scanner scanner = new Scanner(System.in);
//            System.out.print("Your selection: ");
//            int userSelection = scanner.nextInt();
//            
//            if(userSelection >=0 && userSelection <= deliveryManList.getNumberOfEntries())
//            {
//                DeliveryMan targetDeliveryman = (DeliveryMan)deliveryManList.getEntry(userSelection);
//                Order currentOrder = targetDeliveryman.getCurrentOrder();
//                Food[] foodList;
//                
//                foodList = currentOrder.getOrderedFood();
//                System.out.println("Delivery Man: " + targetDeliveryman.getEmployeeName());
//                System.out.println("Status: " + targetDeliveryman.getStatus());
//                System.out.println("===Food Order Details===");
//                System.out.println("Order No: " + targetDeliveryman.getCurrentOrder().getOrderNum());
//                System.out.println("Food Ordered:");
//                
//                for(Food x: foodList)
//                    System.out.println(x);
//            }
//            else
//            {
//                System.out.println("Invalid Selection.");
//            }
//        }
//        else{
//            System.out.println("No deliveryman is detected!");
//        }
//    }
    
    public void generateReport(){
        
    }         
    
    //Private method to validate name
    private boolean validateName(String name) {
        //TODO: Check the name whether it is a letter or space
        //Return true if the name is a combination of letters and space
        //Return false otherwise
        boolean valid = true;
        for(int i = 0; i < name.length(); i++){
            Character ch = name.charAt(i);
            if(!Character.isLetter(ch)||!ch.equals(' ')){
                valid = false;
                break;
            }                      
        }
        return valid;
    }
    
    //Private method to validate gender
    private boolean validateGender(char gender) {
        //TODO: Check the gender whether it is 'M' or 'F'
        //Return true if the gender is 'M' or 'F'
        //Return false otherwise
        return gender =='M'||gender =='F';
    }
    
    //Private method to validate age range
    private boolean validateAge(Integer age) {
        //TODO: Check the age whether the age entered is between 18 and 55
        //Return true if the age is above 18 and below 55
        //Return false otherwise
        return age >= 18 && age <= 55;
    }
    
    //Private method to validate IC
    private boolean validateIC(String identityCard) {
        //TODO: Check the IC number wether the length is 12 or the characters entered are digits
        //Return true if the IC length is 12 and all the characters are digit
        //Return false otherwise
        boolean valid = true;
        if (identityCard.length() != 12){
            return false;
        }
        for(int i=0; i<identityCard.length(); ++i){
             Character ch = identityCard.charAt(i);
             if (!Character.isDigit(ch)){
                 valid = false;
             }
        }
        return valid;
    }

    //Private method to validate contact number
    private boolean validateContactNo(String contactNo) {
        //TODO: Check the contact number whether the length is 10 or 11 and the characters entered are digit
        //Return true if the contact number length is 10 or 11 and also all the characters are digit
        //Return false otherwise
        boolean valid = true;
        if ((contactNo.length()>11) && contactNo.length()<10){
            return false;
        }
        for(int i = 0; i < contactNo.length(); i++){
            Character ch = contactNo.charAt(i);
            if(!Character.isDigit(ch)){
                valid = false;
                break;
            }
        }
         return valid;    
    }

    
}
