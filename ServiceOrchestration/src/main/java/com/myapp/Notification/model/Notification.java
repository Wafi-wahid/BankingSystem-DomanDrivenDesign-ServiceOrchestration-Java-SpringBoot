package com.myapp.Notification.model;

public class Notification {
    private int id;
    private String toUser;
    private String message;
    private String type; // Type of notification (e.g., EMAIL, SMS)

    public Notification(int id, String toUser, String message, String type) {
        this.id = id;
        this.toUser = toUser;
        this.message = message;
        this.type = type;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getToUser() { return toUser; }
    public void setToUser(String toUser) { this.toUser = toUser; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return "Notification{id=" + id + ", toUser='" + toUser + "', message='" + message + "', type='" + type + "'}";
    }
}
