/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myapp.transaction.model;

/**
 *
 * @author Dell
 */
public class Transaction {
 
    private int id;
    private String fromUser;
    private String toUser;
    private double amount;

    public Transaction(int id, String fromUser, String toUser, double amount) {
        this.id = id;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.amount = amount;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFromUser() { return fromUser; }
    public void setFromUser(String fromUser) { this.fromUser = fromUser; }
    public String getToUser() { return toUser; }
    public void setToUser(String toUser) { this.toUser = toUser; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}

