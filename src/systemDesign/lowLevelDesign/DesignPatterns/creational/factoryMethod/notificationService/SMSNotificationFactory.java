package systemDesign.lowLevelDesign.DesignPatterns.creational.factoryMethod.notificationService;

public class SMSNotificationFactory extends NotificationFactory{

    @Override
    Notification createNotification() {
        return new SMSNotification();
    }
}
