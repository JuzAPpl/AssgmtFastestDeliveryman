/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import java.util.Scanner;

/**
 *
 * @author S3113
 */
public class Executive extends Employee {

    public Executive(){
        super();
    }

    public void addStaff() {
            //TODO:Add new staff.
            Scanner scanner = new Scanner(System.in);
            boolean validName = false, validPhoneNo = false;
            String name= "", phoneNo="";
            do{
                if (validName == false){
                System.out.print("Enter new Deliverman name:");
                name = scanner.nextLine();
                validName = validateName(name);
                }
                else if (validPhoneNo == false){
                System.out.print("Enter new Deliverman contact no:");
                phoneNo = scanner.nextLine();
                validPhoneNo = validatePhoneNo(phoneNo);
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
                DeliveryMan deliveryMan = new DeliveryMan(name, "1001", "123abc", 2000, phoneNo);
                System.out.println("New deliveryman "+ name + "is successfully added!");
                System.out.println("==Information of new deliveryman=="+deliveryMan);
                
            }
            else
            {
                System.out.println("You just aborted an adding staff execution! Have a nice day!");
            }

    }

    public void terminateStaff() {
        //TODO:Remove termnated staff
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
        for(int i = 0; i < phoneNo.length(); i++)
        {
            char ch = phoneNo.charAt(i);
            if(!Character.isDigit(ch)&& phoneNo.length() >= 11 && phoneNo.length() == 0)
            {
                return false;
            }
        }
         return true;
    }
    public static void main(String[] Args){
        Executive exec = new Executive();
        exec.addStaff();
    }

}
