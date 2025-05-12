package com.myapp.transaction.model;

public class Transaction {
    private final int id;
    private final String fromUser;
    private final String toUser;
    private final double amount;

    public Transaction(int id, String fromUser, String toUser, double amount) {
        this.id = id;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getFromUser() {
        return fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + id +
                ", From: " + fromUser +
                ", To: " + toUser +
                ", Amount: " + amount;
    }
}
