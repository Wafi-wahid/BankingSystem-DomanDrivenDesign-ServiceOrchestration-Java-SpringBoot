/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myapp.transaction.service;
import com.myapp.transaction.model.Transaction;
import java.util.HashMap;
import java.util.Map;

import java.util.*;
/**
 *
 * @author Dell
 */
public class TransactionService {
    private Map<Integer, Transaction> transactions = new HashMap<>();
    private UserService userService = new UserService();
    private AccountService accountService = new AccountService();
    private NotificationService notificationService = new NotificationService();

    public String createTransaction(Transaction tx) {
        if (!userService.exists(tx.getFromUser()) || !userService.exists(tx.getToUser())) {
            return "User not found!";
        }
        if (!accountService.hasSufficientBalance(tx.getFromUser(), tx.getAmount())) {
            return "Insufficient balance!";
        }

        transactions.put(tx.getId(), tx);
        accountService.transfer(tx.getFromUser(), tx.getToUser(), tx.getAmount());
        notificationService.notify(tx.getToUser(), "You received $" + tx.getAmount());

        return "Transaction completed successfully.";

    }

    public Transaction readTransaction(int id) {
        return transactions.get(id);
    }

    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions.values());
    }

    public String updateTransaction(int id, Transaction newTx) {
        if (!transactions.containsKey(id)) return "Transaction not found!";
        transactions.put(id, newTx);
        return "Transaction updated.";
    }

    public String deleteTransaction(int id) {
        if (transactions.remove(id) != null) return "Transaction deleted.";
        return "Transaction not found!";
    }
}


