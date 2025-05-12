package com.myapp.Notification.controller;

import com.myapp.Notification.model.Notification;
import com.myapp.Notification.service.NotificationService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NotificationController {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NotificationService service = new NotificationService();

        while (true) {
            System.out.println("\n=== Notification Menu ===");
            System.out.println("1. Create Notification");
            System.out.println("2. Read Notification");
            System.out.println("3. Update Notification");
            System.out.println("4. Delete Notification");
            System.out.println("5. View All Notifications");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // clear buffer
                continue;
            }

            switch (choice) {
                case 1:
                    // ✅ Create Notification
                    System.out.print("Enter Notification ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    System.out.print("To User: ");
                    String toUser = scanner.nextLine();

                    System.out.print("Type (Email/SMS): ");
                    String type = scanner.nextLine();

                    System.out.print("Message: ");
                    String message = scanner.nextLine();

                    Notification n = new Notification(id, toUser, message, type);
                    System.out.println(service.createNotification(n));
                    break;

                case 2:
                    // ✅ Read Notification
                    System.out.print("Enter Notification ID to read: ");
                    int readId = scanner.nextInt();
                    Notification readNotif = service.readNotification(readId);
                    if (readNotif != null) {
                        System.out.println("ID: " + readNotif.getId() +
                                ", To: " + readNotif.getToUser() +
                                ", Type: " + readNotif.getType() +
                                ", Message: " + readNotif.getMessage());
                    } else {
                        System.out.println("Notification not found!");
                    }
                    break;

                case 3:
                    // ✅ Update Notification
                    System.out.print("Enter ID of notification to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    System.out.print("New To User: ");
                    String newToUser = scanner.nextLine();

                    System.out.print("New Type (Email/SMS): ");
                    String newType = scanner.nextLine();

                    System.out.print("New Message: ");
                    String newMsg = scanner.nextLine();

                    Notification updated = new Notification(updateId, newToUser, newMsg, newType);
                    System.out.println(service.updateNotification(updateId, updated));
                    break;

                case 4:
                    // ✅ Delete Notification
                    System.out.print("Enter ID to delete: ");
                    int delId = scanner.nextInt();
                    System.out.println(service.deleteNotification(delId));
                    break;

                case 5:
                    // ✅ View All Notifications
                    System.out.println("All Notifications:");
                    for (Notification notif : service.getAllNotifications()) {
                        System.out.println("ID: " + notif.getId() +
                                ", To: " + notif.getToUser() +
                                ", Type: " + notif.getType() +
                                ", Message: " + notif.getMessage());
                    }
                    break;

                case 0:
                    // ✅ Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
