/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myapp.transaction.service;

/**
 *
 * @author Dell
 */
public class AccountService {
  
    public boolean hasSufficientBalance(String user, double amount) {
        return amount <= 1000; // Mock limit
    }

    public void transfer(String fromUser, String toUser, double amount) {
        // Simulate transfer
    }
}


