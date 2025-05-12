package com.myapp.transaction.controller;

import com.myapp.transaction.model.Transaction;
import com.myapp.transaction.service.TransactionService;

import java.util.Scanner;

public class TransactionController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransactionService service = new TransactionService();

        while (true) {
            System.out.println("\n=== Transaction Menu ===");
            System.out.println("1. Create Transaction");
            System.out.println("2. Read Transaction");
            System.out.println("3. Update Transaction");
            System.out.println("4. Delete Transaction");
            System.out.println("5. View All Transactions");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Transaction ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("From User: ");
                    String fromUser = scanner.nextLine();
                    System.out.print("To User: ");
                    String toUser = scanner.nextLine();
                    System.out.print("Amount: ");
                    double amount = scanner.nextDouble();
                    Transaction t = new Transaction(id, fromUser, toUser, amount);
                    System.out.println(service.createTransaction(t));
                    break;

                case 2:
                    System.out.print("Enter Transaction ID to read: ");
                    int readId = scanner.nextInt();
                    Transaction tx = service.readTransaction(readId);
                    if (tx != null) {
                        System.out.println("ID: " + tx.getId() + ", From: " + tx.getFromUser() +
                                ", To: " + tx.getToUser() + ", Amount: " + tx.getAmount());
                    } else {
                        System.out.println("Transaction not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter ID of transaction to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("New From User: ");
                    String newFrom = scanner.nextLine();
                    System.out.print("New To User: ");
                    String newTo = scanner.nextLine();
                    System.out.print("New Amount: ");
                    double newAmount = scanner.nextDouble();
                    Transaction newTx = new Transaction(updateId, newFrom, newTo, newAmount);
                    System.out.println(service.updateTransaction(updateId, newTx));
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int delId = scanner.nextInt();
                    System.out.println(service.deleteTransaction(delId));
                    break;

                case 5:
                    System.out.println("All Transactions:");
                    for (Transaction transaction : service.getAllTransactions()) {
                        System.out.println("ID: " + transaction.getId() + ", From: " + transaction.getFromUser()
                                + ", To: " + transaction.getToUser() + ", Amount: " + transaction.getAmount());
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
