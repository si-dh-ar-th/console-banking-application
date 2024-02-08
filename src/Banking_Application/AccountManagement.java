package Banking_Application;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static Banking_Application.MainScreen.mainScreen;

public class AccountManagement {
    public static void add_account(HashMap<Integer, String> customer,
                                   HashMap<Integer, Integer> account_number,
                                   HashMap<Integer, String> account_type,
                                   HashMap<Integer, Integer> account_balance){

        System.out.println("Please enter your 5 digit customer ID: ");
        Scanner input = new Scanner(System.in);
        int customerID = input.nextInt();

        if(!customer.containsKey(customerID)){
            int i = 5;
            while (i > 0) {
                System.out.println("Invalid customer ID. Please press 'R' to retry or " +
                        "press 'M' to go back to the main screen.");
                String flow = input.next();
                if (flow.equals("R")) {
                    add_account(customer, account_number, account_type, account_balance);
                } else if (flow.equals("M")) {
                    mainScreen(customer, account_number, account_type, account_balance);
                } else {
                    System.out.println("Invalid input");
                    i = i - 1;
                }
            }
        }
        else {
            System.out.println("Please enter your 8 digit account number: ");
            int number = input.nextInt();

            if (String.valueOf(number).length() == 8){

                if (account_number.containsKey(number)) {
                    System.out.println("This account is already linked to a customer ID");
                } else {
                    System.out.println("Please enter the account type (Saving/Current): ");
                    String type = input.next();

                    System.out.println("Enter account balance: ");
                    int balance = input.nextInt();

                    int i = 5;
                    while (i > 0) {
                        System.out.println("Please press 'S' to save the details else press 'M' to return to the main screen");
                        String action = input.next();
                        if (action.equals("S")) {
                            account_number.put(number, customerID);
                            account_type.put(number, type);
                            account_balance.put(number, balance);
                            mainScreen(customer, account_number, account_type, account_balance);
                        } else if (action.equals("M")) {
                            mainScreen(customer, account_number, account_type, account_balance);
                        } else {
                            System.out.println("Invalid action");
                            i = i - 1;
                        }
                    }
                    mainScreen(customer, account_number, account_type, account_balance);
                }

            }
            else {
                System.out.println("Invalid length of account number. Please enter a valid account number.");
                add_account(customer, account_number, account_type, account_balance);
            }
        }
    }

    public static void delete_account(HashMap<Integer, String> customer,
                                      HashMap<Integer, Integer> account_number,
                                      HashMap<Integer, String> account_type,
                                      HashMap<Integer, Integer> account_balance){

        System.out.println("Please enter the 8 digit account number: ");

        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        if(account_number.containsKey(number)){
            int i = 5;
            while(i > 0) {
                System.out.println("Press 'D' to delete the account else " +
                                   "press 'M' to go back to the main screen.");
                String action = input.next();

                if (action.equals("D")) {
                    account_number.remove(number);
                    account_type.remove(number);
                    account_balance.remove(number);
                    mainScreen(customer, account_number, account_type, account_balance);
                }
                else if (action.equals("M")) {
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
            System.out.println("Invalid account number. Kindly enter a valid 8 digit number.");
            delete_account(customer, account_number, account_type, account_balance);
        }
    }

    public static void account_details (HashMap<Integer, String> customer,
                                        HashMap<Integer, Integer> account_number,
                                        HashMap<Integer, String> account_type,
                                        HashMap<Integer, Integer> account_balance){

        System.out.println("Please enter the 8 digit account number: ");

        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        if(account_number.containsKey(number)) {
            int j = 5;
            while(j > 0) {
                System.out.println("Please enter the account balance: ");
                int balance = input.nextInt();
                if (balance == account_balance.get(number)) {
                    int i = 5;
                    while (i > 0) {
                        System.out.println("Press 'S' to show account details, else press 'M' to go back to main screen: ");
                        String action = input.next();
                        if (action.equals("S")) {
                            System.out.println("Account Number          Customer ID          Account Type          Amount");
                            System.out.println(number + "                   " + account_number.get(number) +
                                    "                " + account_type.get(number) + "             " +
                                    account_balance.get(number));

                            System.out.println(" ");
                            break;
                        } else if (action.equals("M")) {
                            mainScreen(customer, account_number, account_type, account_balance);
                        } else {
                            System.out.println("Invalid action");
                            i = i - 1;
                        }
                    }
                    mainScreen(customer, account_number, account_type, account_balance);
                } else {
                    System.out.println("The entered balance does not match the account balance. " +
                                       "Press any key to try again or press 'M' to go back to main screen");
                    String flow = input.next();

                    if(flow.equals("M")){
                        mainScreen(customer, account_number, account_type, account_balance);
                    }else {
                        System.out.println("Please enter the account balance: ");
                        j = j - 1;
                    }
                }
            }
            mainScreen(customer, account_number, account_type, account_balance);
        }
        else{
            System.out.println("Invalid account number. Press any key to try again or " +
                               "press 'M' to go back to main screen");
            String flow = input.next();

            if(flow.equals("M")){
                mainScreen(customer, account_number, account_type, account_balance);
            }else {
                account_details(customer, account_number, account_type, account_balance);
            }
        }
    }
}
