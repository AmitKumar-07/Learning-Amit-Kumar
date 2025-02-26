package systemDesign.lowLevelDesign.DesignPatterns.behavioral.observerDesign.observer;
import systemDesign.lowLevelDesign.DesignPatterns.behavioral.observerDesign.observable.StockObservable;

public class EmailNotificationAlertObserverImpl implements NotificationAlertObserver{

    private final String emailId;
    private StockObservable stockObservable;

    public EmailNotificationAlertObserverImpl(String emailId, StockObservable stockObservable) {
        this.emailId = emailId;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        System.out.println("Total "+ stockObservable.getStock()+ " "+ stockObservable.getStockName()+" is in stock, Please hurry up!!");
        senEmail(emailId);
    }

    void senEmail(String emailId){
        System.out.println("Mail Has been sent to "+ emailId);
    }
}
