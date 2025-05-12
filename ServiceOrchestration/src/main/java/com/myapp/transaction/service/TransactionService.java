package com.myapp.transaction.service;

import com.myapp.transaction.model.Transaction;
import java.util.*;

public class TransactionService {
    private final Map<Integer, Transaction> transactions = new HashMap<>();
    private final AccountService accountService = new AccountService();

    // Create Transaction
    public String createTransaction(Transaction tx) {
        if (accountService.hasSufficientBalance(tx.getFromUser(), tx.getAmount())) {
            accountService.transfer(tx.getFromUser(), tx.getToUser(), tx.getAmount());
            transactions.put(tx.getId(), tx);
            return "Transaction created successfully.";
        }
        return "Insufficient balance!";
    }

    // Read Transaction
    public Transaction readTransaction(int id) {
        return transactions.get(id);
    }

    // Update Transaction
    public String updateTransaction(int id, Transaction newTx) {
        if (transactions.containsKey(id)) {
            transactions.put(id, newTx);
            return "Transaction updated successfully.";
        }
        return "Transaction not found.";
    }

    // Delete Transaction
    public String deleteTransaction(int id) {
        return transactions.remove(id) != null ? "Deleted successfully." : "Transaction not found.";
    }

    // Get all Transactions
    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions.values());
    }

    // Menu for managing transactions
    public static void transactionMenu() {
        TransactionService service = new TransactionService();
        Scanner scanner = new Scanner(System.in);
        boolean back = false;

        while (!back) {
            System.out.println("\n--- Transaction Service Menu ---");
            System.out.println("1. Create Transaction");
            System.out.println("2. Read Transaction");
            System.out.println("3. Update Transaction");
            System.out.println("4. Delete Transaction");
            System.out.println("5. Show All Transactions");
            System.out.println("6. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("From user: ");
                    String from = scanner.nextLine();
                    System.out.print("To user: ");
                    String to = scanner.nextLine();
                    System.out.print("Amount: ");
                    double amt = Double.parseDouble(scanner.nextLine());
                    String result = service.createTransaction(new Transaction(id, from, to, amt));
                    System.out.println(result);
                }
                case 2 -> {
                    System.out.print("Enter transaction id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    Transaction tx = service.readTransaction(id);
                    // Printing the transaction properly
                    System.out.println(tx != null ? tx.toString() : "Transaction not found.");
                }
                case 3 -> {
                    System.out.print("Enter id to update: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("From user: ");
                    String from = scanner.nextLine();
                    System.out.print("To user: ");
                    String to = scanner.nextLine();
                    System.out.print("New amount: ");
                    double amt = Double.parseDouble(scanner.nextLine());
                    String res = service.updateTransaction(id, new Transaction(id, from, to, amt));
                    System.out.println(res);
                }
                case 4 -> {
                    System.out.print("Enter id to delete: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    String res = service.deleteTransaction(id);
                    System.out.println(res);
                }
                case 5 -> {
                    // Show all transactions
                    service.getAllTransactions().forEach(tx -> System.out.println(tx.toString()));
                }
                case 6 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
