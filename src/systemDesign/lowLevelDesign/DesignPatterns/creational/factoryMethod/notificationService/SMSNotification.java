package systemDesign.lowLevelDesign.DesignPatterns.creational.factoryMethod.notificationService;

public class SMSNotification implements Notification{

    @Override
    public void sendNotification(String message) {
        System.out.println("Sms: "+ message);
    }
}
