package com.myapp.Notification.service;

import com.myapp.Notification.model.Notification;
import java.util.*;

public class NotificationService {

    private Map<Integer, Notification> notifications = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void notificationMenu() {
        while (true) {
            System.out.println("\n=== Notification Menu ===");
            System.out.println("1. Create Notification");
            System.out.println("2. Read Notification");
            System.out.println("3. Update Notification");
            System.out.println("4. Delete Notification");
            System.out.println("5. View All Notifications");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Notification ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("To User: ");
                    String toUser = scanner.nextLine();

                    System.out.print("Type (Email/SMS): ");
                    String type = scanner.nextLine();

                    System.out.print("Message: ");
                    String message = scanner.nextLine();

                    Notification n = new Notification(id, toUser, message, type);
                    System.out.println(createNotification(n));
                    break;

                case 2:
                    System.out.print("Enter Notification ID to read: ");
                    int readId = scanner.nextInt();
                    Notification notif = readNotification(readId);
                    if (notif != null) {
                        System.out.println(notif);
                    } else {
                        System.out.println("Notification not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter ID of notification to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("New To User: ");
                    String newTo = scanner.nextLine();

                    System.out.print("New Type (Email/SMS): ");
                    String newType = scanner.nextLine();

                    System.out.print("New Message: ");
                    String newMsg = scanner.nextLine();

                    Notification updated = new Notification(updateId, newTo, newMsg, newType);
                    System.out.println(updateNotification(updateId, updated));
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int delId = scanner.nextInt();
                    System.out.println(deleteNotification(delId));
                    break;

                case 5:
                    for (Notification notifAll : getAllNotifications()) {
                        System.out.println(notifAll);
                    }
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public String createNotification(Notification notification) {
        notifications.put(notification.getId(), notification);
        return "Notification created successfully!";
    }

    public Notification readNotification(int id) {
        return notifications.get(id);
    }

    public List<Notification> getAllNotifications() {
        return new ArrayList<>(notifications.values());
    }

    public String updateNotification(int id, Notification newNotification) {
        if (!notifications.containsKey(id)) {
            return "Notification not found!";
        }
        notifications.put(id, newNotification);
        return "Notification updated successfully!";
    }

    public String deleteNotification(int id) {
        if (notifications.remove(id) != null) {
            return "Notification deleted successfully!";
        }
        return "Notification not found!";
    }

    public void notify(String toUser, String message) {
        System.out.println("Notification sent to " + toUser + ": " + message);
    }
}
