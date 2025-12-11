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
//        StockObservable lcdStockObservable = new LCDStockObservableImpl();

        //For the Iphone
        NotificationAlertObserver email1 = new EmailNotificationAlertObserverImpl("Amit123@gmail.com", iphoneStockObservable);
        NotificationAlertObserver mobile1 = new MobileNotificationAlertObserverImpl("8419833117", iphoneStockObservable);

        iphoneStockObservable.add(email1);
        iphoneStockObservable.add(mobile1);

        iphoneStockObservable.setStock(15);
        iphoneStockObservable.setStock(20);
        System.out.println(iphoneStockObservable.getStock());
        iphoneStockObservable.setStock(-35);
        iphoneStockObservable.setStock(2);
//        System.out.println("Current iPhone size is "+lcdStockObservable.getStock());
    }
}
