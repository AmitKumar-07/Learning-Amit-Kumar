package systemDesign.lowLevelDesign.DesignPatterns.behavioral.observerDesign;

import systemDesign.lowLevelDesign.DesignPatterns.behavioral.observerDesign.observable.IphoneStockObservableImpl;
import systemDesign.lowLevelDesign.DesignPatterns.behavioral.observerDesign.observable.LCDStockObservableImpl;
import systemDesign.lowLevelDesign.DesignPatterns.behavioral.observerDesign.observable.StockObservable;
import systemDesign.lowLevelDesign.DesignPatterns.behavioral.observerDesign.observer.EmailNotificationAlertObserverImpl;
import systemDesign.lowLevelDesign.DesignPatterns.behavioral.observerDesign.observer.MobileNotificationAlertObserverImpl;
import systemDesign.lowLevelDesign.DesignPatterns.behavioral.observerDesign.observer.NotificationAlertObserver;

public class AmazonStore {

    public static void main(String[] args) {



        StockObservable iphoneStockObservable = new IphoneStockObservableImpl();
        StockObservable lcdStockObservable = new LCDStockObservableImpl();

        //For the Iphone
        NotificationAlertObserver email1 = new EmailNotificationAlertObserverImpl("Amit123@gmail.com", iphoneStockObservable);
        NotificationAlertObserver email2 = new EmailNotificationAlertObserverImpl("Guru123@gmail.com", iphoneStockObservable);
        NotificationAlertObserver mobile1 = new MobileNotificationAlertObserverImpl("8419833117", iphoneStockObservable);

        iphoneStockObservable.add(email1);
        iphoneStockObservable.add(email2);
        iphoneStockObservable.add(mobile1);
        iphoneStockObservable.remove(email2);

        //For the LCD
        NotificationAlertObserver email3 = new EmailNotificationAlertObserverImpl("Amit123@gmail.com", lcdStockObservable);
        NotificationAlertObserver email4 = new EmailNotificationAlertObserverImpl("Guru123@gmail.com", lcdStockObservable);
        NotificationAlertObserver mobile2 = new MobileNotificationAlertObserverImpl("8419833117", lcdStockObservable);
        lcdStockObservable.add(email3);
        lcdStockObservable.add(email4);
        lcdStockObservable.add(mobile2);

        lcdStockObservable.setStock(12);
        iphoneStockObservable.setStock(15);
//        System.out.println("Current iPhone size is "+lcdStockObservable.getStock());
    }
}
