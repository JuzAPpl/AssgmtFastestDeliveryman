/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestdeliveryman;

import ADT.ADTLinkedListInterface;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Chow Swee Tung
 */
public class Executive extends Employee {
    //declaration of initialize variables

    private double allowance;
    private String officeRoomNo;

    //Empty constructor
    public Executive() {
    }

    //A constructor consist super class of variables 
    public Executive(double allowance, String officeRoomNo, String empName, 
            String empID, String empIC, char gender, String contactNo, 
            String address, String password, double salary) {
     super(empName, empID, empIC, gender, contactNo, address, password, salary);
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
     * @param employeeList A list which stores all types of employees.
     */
    //Main menu to allow executive do action
    public void displayMenu(ADTLinkedListInterface<Employee> employeeList) {
        java.util.Scanner scanner = new Scanner(System.in);
        int userSelection = -1;
        while (userSelection != 0) {
            System.out.println(">>>>>>>>>>>>>>MAIN MENU<<<<<<<<<<<<<<<<<<<<");
            System.out.println("Please select an action to perform:");
            System.out.println("1. Add new delivery man");
            System.out.println("2. Search deliveryman");
            System.out.println("3. Display all deliverymen");
            System.out.println("4. View a report of daily order history");
            System.out.println("0. Exit");
            System.out.print("Your selection: ");
            userSelection = scanner.nextInt();

            switch (userSelection) {
                case 1:
                    addStaff(employeeList);
                    break;
                case 2:
                    searchStaff(employeeList);
                    break;
                case 3:
                    displayDeliveryman(employeeList);
                    break;
                case 4:
                    viewReport(employeeList);
                    break;
                default:
                    System.out.println("Sorry, invalid selection.\n");
                    break;
                case 0:
                    break;
            }
        }
    }
//Method to add new employee
    public void addStaff(ADTLinkedListInterface<Employee> employeeList) {
//Variable declaration
        String name = "";
        Character gender = null;
        String address = null;
        String identityCard = null;
        String contactNo = null;

//Assign to check validation
        boolean validName = false, 
                validPhoneNo = false, 
                validGender = false, 
                validAddress = false, 
                validIC = false;

//variable to make selection types of deliveryman after call the method
        int getSelection = deliverymanType();

//Read user input for required data field and call its validate method
        Scanner scanner = new Scanner(System.in);
        System.out.println("===Please Enter New Delivery Man's Details===");
        while (!validName) {
            System.out.print("1. Name: ");
            name = scanner.nextLine();
            validName = validateName(name);
            if (!validName) {
System.out.println("Sorry, invalid name. Name should contains only letters.");
            }
        }
        while (!validGender) {
            System.out.print("2. Gender(M/F): ");
            gender = scanner.nextLine().charAt(0);
            gender = Character.toUpperCase(gender);
            validGender = validateGender(gender);
            if (!validGender) {
                System.out.println("Sorry. Invalid gender.");
            }
        }
        while (!validAddress) {

            System.out.print("3. Address: ");
            address = scanner.nextLine();
            validAddress = validateAddress(address);
            if (!validAddress) {
                System.out.println("Sorry, Invalid address");
            }
        }

        while (!validIC) {
            System.out.print("4. Identity Card(without dash): ");
            identityCard = scanner.nextLine();
            validIC = validateIC(identityCard);
            if (!validIC) {
  System.out.println("Sorry, the identity card number must be all digits.");
            }
        }
        while (!validPhoneNo) {
            System.out.print("5. Contact No: ");
            contactNo = scanner.nextLine();
            validPhoneNo = validateContactNo(contactNo);
            if (!validPhoneNo) {
          System.out.println("Sorry. Invalid phone number format is inserted.");
            }
        }

        //Read user's response to confirm the add new staff process 
   System.out.print("Do you want to add " + name + " as new Deliveryman?(Y/N)");
        char userResponse = ' ';

        while (true) {
            userResponse = scanner.nextLine().charAt(0);
            userResponse = Character.toUpperCase(userResponse);

            if (userResponse != 'Y' && userResponse != 'N') {
     System.out.println("Sorry, invalid input. Please select Y: Yes or N: No.");
            } else if (userResponse == 'Y') {
                if (getSelection == 1) {// selection 1 is ad hoc dlivery man
Employee newEmployee = new AdHocDeliveryMan(name, Employee.generateID(), 
        identityCard, gender, contactNo, address, 1000.00);
                    employeeList.add(newEmployee);
                    System.out.println(newEmployee);
                System.out.println("Successfully added new AdHoc Deliveryman");

                    break;
                } else if (getSelection == 2) {//selection 2 is scheduled order
Employee newEmployee = new ScheduledDeliveryMan(name, Employee.generateID(),
        identityCard, gender, contactNo, address, 1000.00);
                    employeeList.add(newEmployee);
                    System.out.println(newEmployee);
         System.out.println("Successfully added new Scheduled Deliveryman");
                    break;
                }
            } else if (userResponse == 'N') {
         System.out.println("You just aborted an adding staff execution!  XD!");
                break;
            }
        }

    }

//Private choice for Selection of the Types of deliveryman
    private int deliverymanType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which types you want to assign?");
        System.out.println("1. AdHoc Deliveryman");
        System.out.println("2. Scheduled Deliveryman");
        System.out.print("Enter your selection: ");
        int selection = scanner.nextInt();

        if (selection == 1) {
            System.out.println("You are choose Ad-Hoc Deliveryman!");
        } else if (selection == 2) {
            System.out.println("You are choose Scheduled Deliveryman");
        } else {
            System.out.println("Wrong Type !! Please Select Again!!");
            deliverymanType();
        }
        return selection;

    }

//Method to search a staff consist in the employee list
    public void searchStaff(ADTLinkedListInterface<Employee> employeeList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the deliveryman ID: ");
        String searchID = scanner.nextLine();    
        boolean found = false;
        for (int x = 1; x <= employeeList.getTotalEntries(); x++) {
            if (searchID.equals(employeeList.getEntry(x).empID)) {
                found = true;
                Employee pendingStaff = employeeList.getEntry(x);
System.out.println("===INFORMATION OF DELIVERYMAN===");
System.out.println("empID   empName    empIC        gender   salary    "
        + "contactNo    address");
System.out.println("============================================================"
        + "==================");
System.out.println(employeeList.getEntry(x));
System.out.println("==========================================================="
        + "===================");
System.out.println("Please select an action to perform:");
System.out.println("1.Edit Information");
System.out.println("2.Check Routine History");
System.out.println("3.Track Delivery");
System.out.println("4.Remove Deliveryman");
System.out.print("Enter your option:");
                int selection = scanner.nextInt();
                switch (selection) {
                    case 1:
                        editStaff(pendingStaff, employeeList, x);
                        break;
                    case 2:
                        checkRoutineHistory(pendingStaff);
                        break;
                    case 3:
                        retrievePendingDeliveries(pendingStaff);
                        break;
                    case 4:
// A method to remove the deliveryman
                        employeeList.remove(x);
                        System.out.println("Successful to remove");
                        break;
                    default:
                        System.out.println("Invalid input!!");
                        break;
                }

            }
        }
        if (found == false) {
            System.out.println("Sorry, There is no " + searchID + " existed!");
            searchStaff(employeeList);
        }
    }

    //Method to modify contact information and salary
private void editStaff(Employee pendingStaff, 
 ADTLinkedListInterface<Employee> employeeList, int x) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to Edit?");
        System.out.println("1. Edit Contact No");
        System.out.println("2. Edit Address");
        System.out.println("3. Edit Salary");
        System.out.print("Enter your option:");
        int selection = scanner.nextInt();
        switch (selection) {
            case 1: {
                System.out.println("Enter Contact No : ");
                String rewrite = scanner.next();
                if (pendingStaff instanceof AdHocDeliveryMan) {
                    ((AdHocDeliveryMan) pendingStaff).contactNo = rewrite;
                    employeeList.replace(pendingStaff, x);
System.out.println("empID   empName    empIC        gender   salary    "
        + "contactNo    address");
System.out.println("==================================================="
        + "===========================");
System.out.println(employeeList.getEntry(x));
                } else if (pendingStaff instanceof ScheduledDeliveryMan) {
                    ((ScheduledDeliveryMan) pendingStaff).contactNo = rewrite;
                    employeeList.replace(pendingStaff, x);
System.out.println("empID   empName    empIC        gender   salary    "
        + "contactNo    address");
System.out.println("==================================================="
        + "===========================");
System.out.println(employeeList.getEntry(x));
                }
                break;
            }
            case 2: {
                System.out.print("Enter Address : ");
                String rewrite = scanner.next();
                if (pendingStaff instanceof AdHocDeliveryMan) {
                    ((AdHocDeliveryMan) pendingStaff).address = rewrite;
                    employeeList.replace(pendingStaff, x);
System.out.println("empID   empName    empIC        gender   salary    "
        + "contactNo    address");
System.out.println("===================================================="
        + "==========================");
System.out.println(employeeList.getEntry(x));
                } else if (pendingStaff instanceof ScheduledDeliveryMan) {
                    ((ScheduledDeliveryMan) pendingStaff).address = rewrite;
                    employeeList.replace(pendingStaff, x);
System.out.println("empID   empName    empIC        gender   salary    "
        + "contactNo    address");
System.out.println("==================================================="
        + "===========================");
System.out.println(employeeList.getEntry(x));
                }
                break;
            }
            case 3: {
                System.out.print("Enter Salary : ");
                double rewrite = scanner.nextDouble();
                if (pendingStaff instanceof AdHocDeliveryMan) {
                    ((AdHocDeliveryMan) pendingStaff).salary = rewrite;
                    employeeList.replace(pendingStaff, x);
System.out.println("empID   empName    empIC        gender   salary    "
        + "contactNo    address");
System.out.println("==================================================="
        + "===========================");
System.out.println(employeeList.getEntry(x));
                } else if (pendingStaff instanceof ScheduledDeliveryMan) {
                    ((ScheduledDeliveryMan) pendingStaff).salary = rewrite;
                    employeeList.replace(pendingStaff, x);
System.out.println("empID   empName    empIC        gender   salary    "
        + "contactNo    address");
System.out.println("==================================================="
        + "===========================");
System.out.println(employeeList.getEntry(x));
                }
                break;
            }
            default:
                break;
        }
    }

    //Method to view a daily report and able to generate it
    public void viewReport(ADTLinkedListInterface<Employee> employeeList) {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        String datePattern = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
        String currentDate = dateFormat.format(new Date());
        int completeDO = 0;
        int totalDO = 0;

        System.out.println(">>>>>>>>>>>>>>>>.Daily Report<<<<<<<<<<<<<<<<<<<<");
        System.out.println("DATE:" + currentDate);
        System.out.println("Employee ID       Name      Total Delivery Order  ");
        System.out.println("##################################################");
        for (int x = 1; x <= employeeList.getTotalEntries(); x++) {
            Employee staff = employeeList.getEntry(x);
if (staff instanceof AdHocDeliveryMan || staff instanceof ScheduledDeliveryMan){
                if (staff instanceof AdHocDeliveryMan) {
                    completeDO = ((AdHocDeliveryMan) staff).getCompleteDO();
                } else if (staff instanceof ScheduledDeliveryMan) {
                    completeDO = ((ScheduledDeliveryMan) staff).getCompleteDO();
                }
                System.out.println(employeeList.getEntry(x).empID + "            " 
                        + employeeList.getEntry(x).empName
                        + "         " + completeDO);
                totalDO += completeDO;
            }
        }
        System.out.println("There may make " + totalDO + " orders in Today!\n");
        do {
            System.out.print("Do you want to print report(Y/N)?");
            char choice = scanner.next().charAt(0);
            choice = Character.toUpperCase(choice);
            if (choice == 'Y') {
                valid = true;
                try {
                    File ClockInFile = new File("DailyRecord.txt");
                    FileWriter fw = new FileWriter(ClockInFile, true);
                    fw.write(currentDate + "  has " + totalDO + " orders");
                    fw.write("\r\n");
                    fw.close();

                } catch (IOException iox) {
                    //do stuff with exception
                    iox.printStackTrace();
                }
            } else if (choice == 'N') {
                System.out.println("HAVE A NICE DAY    XD");
                valid = true;
            } else {
                System.out.println("Invalid Input!!");
                valid = false;
            }
        } while (valid != true);
    }

    //The method to view all deliveryman in 2 lists
  public void displayDeliveryman(ADTLinkedListInterface<Employee> employeeList) {
        Employee pendingStaff;
    //All Ad-Hoc Deliveryman
        System.out.println("        ===INFORMATION OF Ad-Hoc DELIVERYMAN===");
        System.out.println("empID   empName    empIC        gender   salary   "
                + " contactNo    address");
        System.out.println("=================================================="
                + "============================");
       //Loop to get a object deliveryman
        for (int x = 1; x <= employeeList.getTotalEntries(); x++) {

            if (employeeList.getEntry(x) instanceof AdHocDeliveryMan) {
                pendingStaff = (AdHocDeliveryMan) employeeList.getEntry(x);
                System.out.println(pendingStaff);

            }

        }
     //All Scheduled Deliveryman
        System.out.println("        ===INFORMATION OF Scheduled DELIVERYMAN===");
        System.out.println("empID   empName    empIC        gender   salary    "
                + "contactNo    address");
        System.out.println("===================================================="
                + "==========================");
     //Loop to get a object deliveryman
        for (int x = 1; x <= employeeList.getTotalEntries(); x++) {
            if (employeeList.getEntry(x) instanceof ScheduledDeliveryMan) {
                pendingStaff = (ScheduledDeliveryMan) employeeList.getEntry(x);
                System.out.println(pendingStaff);
            }

        }
    }

//The method to check routine history of deliveryman with 2 types of deliveryman
    public void checkRoutineHistory(Employee pendingStaff) {
        System.out.println("===WORKING RECORD OF DELIVERYMAN===");
        System.out.println("==================================================="
                + "===========================");

        if (pendingStaff instanceof AdHocDeliveryMan) {
            ((AdHocDeliveryMan) pendingStaff).displayRoutineHistory();

        } else if (pendingStaff instanceof ScheduledDeliveryMan) {
            ((ScheduledDeliveryMan) pendingStaff).displayRoutineHistory();
        }
    }

    //Private method to validate name
    private boolean validateName(String name) {
//Return true if the name is a combination of letters and space
//Return false otherwise
        boolean valid = true;

        for (int i = 0; i < name.length(); ++i) {
            Character ch = name.charAt(i);
            if (!Character.isLetter(ch) && !ch.equals(' ')) {
                valid = false;
                break;
            }

        }
        if (name.isEmpty()) {
            valid = false;
        }
        return valid;
    }

    //Private method to validate gender
    private boolean validateGender(char gender) {
//Return true if the gender is 'M' or 'F'
//Return false otherwise
        return gender == 'M' || gender == 'F';
    }

    //Private method to validate address range
    private boolean validateAddress(String address) {
 //Return false if left empty and its length more than 50 
 //Return true otherwise
        boolean valid = true;
        if (address.isEmpty() || address.length() > 50) {
            valid = false;
        }
        return valid;
    }

    //Private method to validate IC
    private boolean validateIC(String identityCard) {
//Return true if the IC length is 12 and all the characters are digit
//Return false otherwise
        boolean valid = true;
        if (identityCard.length() != 12) {
            return false;
        }
        for (int i = 0; i < identityCard.length(); ++i) {
            Character ch = identityCard.charAt(i);
            if (!Character.isDigit(ch)) {
                valid = false;
            }
        }
        return valid;
    }

    //Private method to validate contact number
    private boolean validateContactNo(String contactNo) {
//Return true if the contact number length is 10 or 11
//Return false otherwise
        boolean valid = true;
        if ((contactNo.length() > 11) || contactNo.length() < 10) {
            return false;
        }
        for (int i = 0; i < contactNo.length(); i++) {
            Character ch = contactNo.charAt(i);
            if (!Character.isDigit(ch)) {
                valid = false;
                break;
            }
        }
        return valid;
    }

    //The method to view the pending Delivery Order
    public void retrievePendingDeliveries(Employee pendingStaff) {
        if (pendingStaff instanceof AdHocDeliveryMan) {
            System.out.println("Date          Order ID    Order Status");
            System.out.println("__________________________________________");
            ((AdHocDeliveryMan) pendingStaff).displayCurrentOrder();
        } else if (pendingStaff instanceof ScheduledDeliveryMan) {
            System.out.println("Date          Order ID    Order Status");
            System.out.println("__________________________________________");
            ((ScheduledDeliveryMan) pendingStaff).displayCurrentOrder();
        }

    }
}
