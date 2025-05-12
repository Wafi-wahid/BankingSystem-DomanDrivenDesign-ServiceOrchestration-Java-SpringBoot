package com.myapp.Notification.test;

import com.myapp.Notification.model.Notification;
import com.myapp.Notification.service.NotificationService;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NotificationServiceTest {

    @Test
    public void testSendEmailNotification() {
        NotificationService service = new NotificationService();
        String result = service.createNotification(new Notification(1, "User1", "Welcome to the system!", "EMAIL"));
        assertEquals("Notification created.", result);
    }

    @Test
    public void testSendSMSNotification() {
        NotificationService service = new NotificationService();
        String result = service.createNotification(new Notification(2, "User2", "Your OTP is 1234", "SMS"));
        assertEquals("Notification created.", result);
    }

    @Test
    public void testDeleteNotification() {
        NotificationService service = new NotificationService();
        service.createNotification(new Notification(3, "User3", "This is a test delete", "EMAIL"));
        String result = service.deleteNotification(3);
        assertEquals(true, result);
    }

    @Test
    public void testReadNotification() {
        NotificationService service = new NotificationService();
        service.createNotification(new Notification(4, "User4", "Read this message", "SMS"));
        Notification n = service.readNotification(4);
        assertEquals("User4", n.getToUser());
    }
}

