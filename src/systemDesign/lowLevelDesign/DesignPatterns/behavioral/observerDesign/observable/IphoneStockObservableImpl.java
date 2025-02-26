package systemDesign.lowLevelDesign.DesignPatterns.behavioral.observerDesign.observable;

import systemDesign.lowLevelDesign.DesignPatterns.behavioral.observerDesign.observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneStockObservableImpl implements StockObservable{

    int iPhoneCount;//object which are being observed
    String stockName = "Iphone";
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

        for(NotificationAlertObserver notificationAlertObserver : observerList){
            notificationAlertObserver.update();
        }
    }

    @Override
    public void setStock(int data) {

        if(data>0 && iPhoneCount == 0){
            iPhoneCount = data;
            notifyToSubscriber();
        }else {
            iPhoneCount+=data;
        }
    }

    @Override
    public int getStock() {
        return iPhoneCount;
    }

    @Override
    public String getStockName(){
        return stockName;
    }
}
