package systemDesign.lowLevelDesign.DesignPatterns.behavioral.observerDesign.observable;

import systemDesign.lowLevelDesign.DesignPatterns.behavioral.observerDesign.observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class LCDStockObservableImpl implements StockObservable{

    int lcdCount;
    String stockName = "LCD";
    List<NotificationAlertObserver> observerList = new ArrayList<>();

    @Override
    public void add(NotificationAlertObserver notificationAlertObserver) {
        observerList.add(notificationAlertObserver);
    }

    @Override
    public void remove(NotificationAlertObserver notificationAlertObserver) {
        observerList.remove(notificationAlertObserver);
    }

    @Override
    public void notifyToSubscriber() {
        for(NotificationAlertObserver notificationAlertObserver: observerList){
            notificationAlertObserver.update();
        }
    }

    @Override
    public void setStock(int data) {

        if(data>0 && lcdCount == 0){
            lcdCount = data;
            notifyToSubscriber();
        }else {
            lcdCount+=data;
        }
    }

    @Override
    public int getStock() {
        return lcdCount;
    }

    @Override
    public String getStockName(){
        return stockName;
    }
}
