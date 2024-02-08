package Banking_Application;

import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import Banking_Application.MainScreen;

import static Banking_Application.MainScreen.mainScreen;

public class CustomerManagement {
    public static void add_customer(HashMap<Integer, String> customer,
                                    HashMap<Integer, Integer> account_number,
                                    HashMap<Integer, String> account_type,
                                    HashMap<Integer, Integer> account_balance){

//        Customer ID             Customer Name         Account No          Account Type        Account Balance
//        12345                   Sidharth              88604633            Saving              200000
//        22222                   Sarthak               98108791            Saving              10000   -- Deleted
//        89898                   Diya                  93199138            Current             100000

        System.out.println("Please enter a 5 digit number for customer ID: ");
        Scanner input = new Scanner(System.in);
        int customerID = input.nextInt();
      //counting the length of customer ID
        if(String.valueOf(customerID).length() == 5) {

            if (customer.containsKey(customerID)) {
                System.out.println("This ID is already taken. Please try another number.");
                add_customer(customer, account_number, account_type, account_balance);
            } else {
                System.out.println("Please enter customer name: ");
                String customerName = input.next();

                int i = 5;
                while (i > 0) {
                    System.out.println("Please press 'S' to save the details else press 'M' to return to the main screen: ");
                    String action = input.next();
                    if (action.equals("S")) {
                        customer.put(customerID, customerName);
                        mainScreen(customer, account_number, account_type, account_balance);
                    } else if (action.equals("M")) {
                        mainScreen(customer, account_number, account_type, account_balance);
                    } else {
                        System.out.println("Invalid action");
                        i = i - 1;
                    }
                }
                System.out.println("You have exceeded the maximum number of attempts.");
                mainScreen(customer, account_number, account_type, account_balance);
            }

        }
        else {
            System.out.println("Invalid length of customer ID. Please enter a valid ID.");
            add_customer(customer, account_number, account_type, account_balance);
        }
    }

    public static void show_customer(HashMap<Integer, String> customer,
                                     HashMap<Integer, Integer> account_number,
                                     HashMap<Integer, String> account_type,
                                     HashMap<Integer, Integer> account_balance){
        System.out.println("Please enter the customer ID: ");

        Scanner input = new Scanner(System.in);
        int customerID = input.nextInt();

        if(customer.containsKey(customerID)){
            System.out.println("Customer ID: " + customerID);
            System.out.println("Customer Name: " + customer.get(customerID));

            int i = 5;
            while(i > 0) {
                System.out.println("Please press 'M' to go back to the main screen.");
                String action = input.next();
                if (action.equals("M")) {
                    mainScreen(customer, account_number, account_type, account_balance);
                }
                else {
                    System.out.println("Invalid action");
                    i = i - 1;
                }
            }
            mainScreen(customer, account_number, account_type, account_balance);
        }
        else{
            System.out.println("This ID is not present in the database. Kindly enter a valid customer ID.");
            show_customer(customer, account_number, account_type, account_balance);
        }
    }

    public static void show_all_customers(HashMap<Integer, String> customer,
                                          HashMap<Integer, Integer> account_number,
                                          HashMap<Integer, String> account_type,
                                          HashMap<Integer, Integer> account_balance){
        System.out.println("Customer ID          Customer Name");
        for(Map.Entry cust : customer.entrySet()){
            System.out.println(cust.getKey() + "                " + cust.getValue());
        }

        System.out.println("Please press 'M' to go back to the main screen");
        Scanner input = new Scanner(System.in);

        int i = 5;
        while(i > 0) {
            String action = input.nextLine();
            if (action.equals("M")) {
                mainScreen(customer, account_number, account_type, account_balance);
            } else {
                System.out.println("Invalid action");
                i = i - 1;
            }
        }
        mainScreen(customer, account_number, account_type, account_balance);
    }
}
