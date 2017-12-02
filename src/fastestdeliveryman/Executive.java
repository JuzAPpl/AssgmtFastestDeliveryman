/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import java.util.Scanner;


/**
 *
 * @author Ng Pei Xiang
 */
public class Executive extends Employee {
    
    

    public Executive(){
        super();
    }

    public void addStaff() {
            //TODO:Add new staff.
            Scanner scanner = new Scanner(System.in);
            boolean validName=false, validPhoneNo=false, validGender=false, validAge=false, validIC=false;
            String name= "", phoneNo="", address="",identityCard="";
            char gender = ' ';
            int age = 0;
            System.out.println("===Please Enter New Delivery Man's Details===");
            do{
                if (validName == false)
                {
                    System.out.print("1. Name: ");
                    name = scanner.nextLine();
                    validName = validateName(name);
                    if (!validName)
                        System.out.println("Sorry, invalid name is detected. Name should contains only letters.");
                }
                else if(validGender==false)
                {
                    System.out.print("2. Gender(M/F): ");
                    gender = scanner.next().charAt(0);
                    gender = Character.toUpperCase(gender);
                    validGender = validateGender(gender);
                    if (validGender == false)
                        System.out.println("Sorry. Invalid gender.");
                            
                }
                else if(validAge==false)
                {
                    System.out.print("3. Age: ");
                    
                    age = scanner.nextInt();
                    validAge = validateAge(age);
                    if(!validAge)
                        System.out.println("Sorry, the age of delivery man must be at least 18 and at most 55.");
                
                   
         
                }
                else if(validIC==false)
                {
                    System.out.print("4. Identity Card(without dash): ");
                    identityCard = scanner.nextLine();
                    validIC = validateIC(identityCard);
                    if(!validIC)
                        System.out.println("Sorry, the identity card number must be all digits.");
                }
                else if (validPhoneNo == false)
                {
                    System.out.print("5. Contact No: ");
                    phoneNo = scanner.nextLine();
                    validPhoneNo = validatePhoneNo(phoneNo);
                    if(!validPhoneNo)
                    {
                        System.out.println("Sorry. Invalid phone number format is inserted.");
                    }
                }
            }while(validName == false || validPhoneNo == false);
            
            System.out.print("Do you want to add " + name + " as new Deliveryman?(Y/N)");
            char userResponse = scanner.next().charAt(0);
            userResponse = Character.toUpperCase(userResponse);
            
            while(userResponse != 'Y' && userResponse != 'N')
            {
                System.out.println("Sorry, invalid input. Please select Y: Yes or N: No.");
                userResponse = scanner.next().charAt(0);
                userResponse = Character.toUpperCase(userResponse); 
            }
            if (userResponse == 'Y')
            {
                DeliveryMan deliveryMan = new DeliveryMan(name, identityCard, gender, age, phoneNo, address,"1001", "123abc", 2000.0);
                System.out.println("New deliveryman "+ name + "is successfully added!");
                System.out.println("==Information of new deliveryman==\n" + deliveryMan);
                
            }
            else
            {
                System.out.println("You just aborted an adding staff execution! Have a nice day!");
            }

    }

    
    public void editStaff(Employee[] deliveryman)
    {
        
        Scanner scanner = new Scanner(System.in);
        DeliveryMan targerDeliveryman = new DeliveryMan();
        boolean targetFound = false;
        for(Employee x: deliveryman)
        {
            if(x instanceof DeliveryMan)
            System.out.println(x);
        }
        System.out.print("Please key in deliveryman's employee id to continue: ");
        String empID = scanner.nextLine();
        for(Employee x: deliveryman)
        {
            if(x.getEmployeeID().equals(empID));
            {
                if(x instanceof DeliveryMan)
                {
                    targerDeliveryman = (DeliveryMan) x;
                    targetFound = true;
                }
                
            }
        }
        if(targetFound){
            System.out.println("Please select an option to edit: ");
            System.out.println("1. Contact Number");
            System.out.println("2. Address");
            System.out.println("-1. Exit");
            int userSelection = scanner.nextInt();

            switch(userSelection)
            {
                case 1: editContactNo(targerDeliveryman);
                    break;
                case 2:editAddress(targerDeliveryman);
                    break;
                default:
                    break;
            }
        }
        else
        {
            System.out.println("Do you want to continue?");
        }
        
    }
    
    public void displayMenu(Employee[] deliveryman)
    {
        int userSelection=0;
        do{
            System.out.println("Please select an action to perform:");
            System.out.println("1. Add new delivery man");
            System.out.println("2. Update delivery man's information");
            System.out.println("-1. Exit");
        
            java.util.Scanner scanner = new Scanner(System.in);
            userSelection = scanner.nextInt();
            switch(userSelection)
            {
                case 1: addStaff();
                break;
                case 2: editStaff(deliveryman);
                break;
                case -1: break;
                default: System.out.println("Sorry, invalid selection."); 
                break;
                
            }
        }while(userSelection!=-1);
        
    }
    
    private boolean validateName(String name){
        
        
        for(int i = 0; i < name.length(); i++)
        {
            char ch = name.charAt(i);
            if(!Character.isLetter(ch)&& ch != ' ')
            {
                return false;
            }
                      
        }
        return true;
    }
    private boolean validatePhoneNo(String phoneNo){
        //Private method for validating phone number input
        for(int i = 0; i < phoneNo.length(); i++)
        {
            char ch = phoneNo.charAt(i);
            if(!Character.isDigit(ch)&& (phoneNo.length() > 11) && phoneNo.length() != 0)
            {
                return false;
            }
        }
         return true;
    }
    private boolean validateAge(int age) {
        return (age>=18&&age<=55);
    }
    
    private boolean validateGender(char gender) {
        return (gender =='M'||gender =='F');
    }

    private boolean validateIC(String identityCard) {
       
        for(int i=0; i<identityCard.length(); ++i)
        {
             char ch = identityCard.charAt(i);
             if (!Character.isDigit(ch))
             {
                 return false;
             }
        }
        return true;
    }

    private void editContactNo(DeliveryMan deliveryman) {
        Scanner scanner = new Scanner(System.in);
        boolean validPhoneNo = false;
        System.out.println("Current contact number: " + deliveryman.getContactNo());
        do{
            System.out.print("Please enter new contact number: ");
            String phoneNo = scanner.nextLine();
            validPhoneNo = validatePhoneNo(phoneNo);
            if(!validPhoneNo)
            {
                System.out.println("Sorry. Invalid phone number format is inserted.");
            }
        }while (validPhoneNo == false);
    }

    private void editAddress(DeliveryMan deliveryman) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
