package Banking_Application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import static Banking_Application.CustomerManagement.*;
import static Banking_Application.AccountManagement.*;
import static Banking_Application.Transactions.*;

public class MainScreen {
    public static void mainScreen(HashMap<Integer, String> customer,
                                  HashMap<Integer, Integer> account_number,
                                  HashMap<Integer, String> account_type,
                                  HashMap<Integer, Integer> account_balance) {
        
        System.out.println("------------------------------Main Screen------------------------------");

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Date: " + sdf.format(date));

        System.out.println("-----------------------------------------------------------------------");
        System.out.println();

        System.out.println("---------------------------------Exit----------------------------------");
        System.out.println("----- Enter 0 to exit");

        System.out.println("------------------------For Customer Management------------------------");
        System.out.println("----- Enter 1 to add a new customer");
        System.out.println("----- Enter 2 to see customer details");
        System.out.println("----- Enter 3 to see all the customers");
        System.out.println();

        System.out.println("------------------------For Account Management-------------------------");
        System.out.println("----- Enter 4 to add a new account");
        System.out.println("----- Enter 5 to close an account");
        System.out.println("----- Enter 6 to see account details");
        System.out.println();

        System.out.println("----------------------------For Transactions---------------------------");
        System.out.println("----- Enter 7 to deposit amount");
        System.out.println("----- Enter 8 to withdraw amount");
        System.out.println();

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your desired input: ");
        int action = input.nextInt();

        if (action == 0) {
            System.out.println("You have successfully exited the application");
            System.exit(0);
        } else if (action == 1) {
            add_customer(customer, account_number, account_type, account_balance);
        } else if (action == 2) {
            show_customer(customer, account_number, account_type, account_balance);
        } else if (action == 3) {
            show_all_customers(customer, account_number, account_type, account_balance);
        } else if (action == 4) {
            add_account(customer, account_number, account_type, account_balance);
        } else if (action == 5) {
            delete_account(customer, account_number, account_type, account_balance);
        } else if (action == 6) {
            account_details(customer, account_number, account_type, account_balance);
        } else if (action == 7) {
            deposit(customer, account_number, account_type, account_balance);
        } else if (action == 8) {
            withdraw(customer, account_number, account_type, account_balance);
        }
        else {
            System.out.println("Invalid Input. Please try again.");
            mainScreen(customer, account_number, account_type, account_balance);
        }
    }
}
