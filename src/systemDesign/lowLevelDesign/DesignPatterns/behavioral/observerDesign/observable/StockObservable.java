package systemDesign.lowLevelDesign.DesignPatterns.behavioral.observerDesign.observable;

import systemDesign.lowLevelDesign.DesignPatterns.behavioral.observerDesign.observer.NotificationAlertObserver;

public interface StockObservable {

    void add(NotificationAlertObserver notificationAlertObserver);
    void remove(NotificationAlertObserver notificationAlertObserver);
    void notifyToSubscriber();
    void setStock(int data);
    int getStock();
    String getStockName();
}
