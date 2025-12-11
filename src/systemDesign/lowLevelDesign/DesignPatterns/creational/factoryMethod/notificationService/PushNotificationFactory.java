package systemDesign.lowLevelDesign.DesignPatterns.creational.factoryMethod.notificationService;

public class PushNotificationFactory extends NotificationFactory{

    @Override
    Notification createNotification() {
        return new PushNotification();
    }
}
