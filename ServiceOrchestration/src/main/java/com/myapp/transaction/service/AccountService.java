package com.myapp.transaction.service;

public class AccountService {

    public boolean hasSufficientBalance(String user, double amount) {
        return amount <= 1000; // Mock limit
    }

    public void transfer(String fromUser, String toUser, double amount) {
        // Simulate transfer logic
        System.out.println("Transferred $" + amount + " from " + fromUser + " to " + toUser);
    }
}