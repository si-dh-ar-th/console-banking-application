package Banking_Application;

import java.util.HashMap;

import static Banking_Application.MainScreen.mainScreen;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> customer = new HashMap<>();
        HashMap<Integer, Integer> account_number = new HashMap<>();
        HashMap<Integer, String> account_type = new HashMap<>();
        HashMap<Integer, Integer> account_balance = new HashMap<>();

        mainScreen(customer, account_number, account_type, account_balance);
    }
}