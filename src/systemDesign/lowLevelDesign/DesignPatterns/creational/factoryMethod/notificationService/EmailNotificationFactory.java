package systemDesign.lowLevelDesign.DesignPatterns.creational.factoryMethod.notificationService;

public class EmailNotificationFactory extends NotificationFactory{

    @Override
    Notification createNotification() {
        return new EmailNotification();
    }
}
