package systemDesign.lowLevelDesign.DesignPatterns.creational.factoryMethod.notificationService;

public class Main {

    public static void main(String[] args) {

        NotificationFactory email = new EmailNotificationFactory();
        email.createNotification().sendNotification("email sent to amit");

        NotificationFactory sms = new SMSNotificationFactory();
        sms.createNotification().sendNotification("sms sent to amit");

        //let say now we want to integrate push notification then we are following open and close principle
        //so we add push notification class but will not modify existing class

        NotificationFactory push = new PushNotificationFactory();
        push.createNotification().sendNotification("push sent to amit");
    }
}
