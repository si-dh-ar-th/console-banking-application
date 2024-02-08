package Banking_Application;

import java.util.HashMap;
import java.util.Scanner;

import static Banking_Application.MainScreen.mainScreen;

public class Transactions {
    public static void withdraw (HashMap<Integer, String> customer,
                                 HashMap<Integer, Integer> account_number,
                                 HashMap<Integer, String> account_type,
                                 HashMap<Integer, Integer> account_balance){

        System.out.println("Please enter the 8 digit account number: ");

        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        if(account_number.containsKey(number)) {
            System.out.println("Please enter the amount to withdraw: ");
            int amount = input.nextInt();

            if (amount <= account_balance.get(number)) {
                int i = 5;
                while (i > 0) {
                    System.out.println("Press 'S' to confirm the transaction, " +
                            "else press 'M' to go back to the main screen");
                    String action = input.next();
                    if (action.equals("S")) {
                        account_balance.replace(number, account_balance.get(number) - amount);
                        System.out.println("Account Number          Customer ID          Account Type          Amount");
                        System.out.println(number + "                " + account_number.get(number) +
                                "                " + account_type.get(number) + "                " +
                                account_balance.get(number));
                        break;
                    } else if (action.equals("M")) {
                        mainScreen(customer, account_number, account_type, account_balance);
                    } else {
                        System.out.println("Invalid action");
                        i = i - 1;
                    }
                }
                System.out.println(" ");
                mainScreen(customer, account_number, account_type, account_balance);
            } else {
                System.out.println("Insufficient balance");
                mainScreen(customer, account_number, account_type, account_balance);
            }
        }
        else{
            System.out.println("Invalid account number. Press any key to try again or press 'M' to go back to main screen");
            String flow = input.next();

            if(flow.equals("M")){
                mainScreen(customer, account_number, account_type, account_balance);
            }else {
                withdraw(customer, account_number, account_type, account_balance);
            }
        }
    }

    public static void deposit (HashMap<Integer, String> customer,
                                HashMap<Integer, Integer> account_number,
                                HashMap<Integer, String> account_type,
                                HashMap<Integer, Integer> account_balance){

        System.out.println("Please enter the 8 digit account number: ");

        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        if(account_number.containsKey(number)) {
            System.out.println("Please enter the amount to deposit: ");
            int amount = input.nextInt();

            int i = 5;
            while (i > 0) {
                System.out.println("Press 'S' to confirm the transaction, " +
                        "else press 'M' to go back to the main screen");
                String action = input.next();
                if (action.equals("S")) {
                    account_balance.replace(number, account_balance.get(number) + amount);
                    System.out.println("Account Number          Customer ID          Account Type          Amount");
                    System.out.println(number + "                " + account_number.get(number) +
                            "                " + account_type.get(number) + "                 " +
                            account_balance.get(number));
                    break;
                } else if (action.equals("M")) {
                    mainScreen(customer, account_number, account_type, account_balance);
                } else {
                    System.out.println("Invalid action");
                    i = i - 1;
                }
            }
            System.out.println(" ");
            mainScreen(customer, account_number, account_type, account_balance);
        }
        else{
            System.out.println("Invalid account number. Please try again or press 'M' to go back to main screen");
            String flow = input.next();

            if(flow.equals("M")){
                mainScreen(customer, account_number, account_type, account_balance);
            }else {
                deposit(customer, account_number, account_type, account_balance);
            }
        }
    }
}
