package systemDesign.lowLevelDesign.DesignPatterns.behavioral.observerDesign.observer;

import systemDesign.lowLevelDesign.DesignPatterns.behavioral.observerDesign.observable.StockObservable;

public class MobileNotificationAlertObserverImpl implements NotificationAlertObserver{

    private String mobileNo;
    private StockObservable stockObservable;

    public MobileNotificationAlertObserverImpl(String mobileNo,StockObservable stockObservable){
        this.mobileNo = mobileNo;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        System.out.println("Total "+ stockObservable.getStock()+ " "+ stockObservable.getStockName()+" is in stock, Please hurry up!!");
        System.out.println("Message has been sent to "+mobileNo);
    }
}
