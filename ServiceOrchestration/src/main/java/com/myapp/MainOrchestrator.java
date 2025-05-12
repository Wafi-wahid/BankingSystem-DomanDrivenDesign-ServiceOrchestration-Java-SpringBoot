package com.myapp;

import com.myapp.transaction.service.TransactionService;
import com.myapp.Notification.service.NotificationService; // Add this import for NotificationService
import java.util.Scanner;

public class MainOrchestrator {

    public static void main(String[] args) {
        boolean exit = false;
        try (Scanner scanner = new Scanner(System.in)) {
            while (!exit) {
                System.out.println("\n--- Service Orchestration Menu ---");
                System.out.println("1. Transaction");
                System.out.println("2. Notification");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> // Calling TransactionService's menu
                        TransactionService.transactionMenu();

                    case 2 -> {
                        // Calling NotificationService's menu
                        NotificationService notificationService = new NotificationService(); // Initialize NotificationService
                        notificationService.notificationMenu(); // Call the notification menu
                    }

                    case 3 -> {
                        System.out.println("Exiting... Goodbye!");
                        exit = true;
                    }

                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}
