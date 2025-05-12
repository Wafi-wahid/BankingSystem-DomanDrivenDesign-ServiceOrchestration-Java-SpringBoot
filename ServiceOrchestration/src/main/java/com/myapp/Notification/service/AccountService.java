package com.myapp.notification.service;

public class AccountService {

    // Sample method to check if a user has enough balance
    public boolean hasSufficientBalance(String user, double amount) {
        // You can modify this to check the balance from a database or another system
        // Here we assume user "maria" has a balance of 500
        if (user.equals("maria") && amount <= 500) {
            return true;
        }
        return false;
    }

    // Sample method for transferring funds
    public void transfer(String fromUser, String toUser, double amount) {
        // Perform the transfer logic here (e.g., update user balances)
        System.out.println("Transferring " + amount + " from " + fromUser + " to " + toUser);
    }
}
