package systemDesign.lowLevelDesign.DesignPatterns.singleton;

public class Main {

    public static void main(String[] args) {

        // The Singleton Design Pattern is a creational design pattern that ensures a
        // class has only one instance and provides a global point of access to it.
        // It is used when you need exactly one object to coordinate actions across the system.
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1=Singleton.getInstance();
        Singleton singleton2=Singleton.getInstance();
        singleton.sum(4,9);
        singleton1.sum(6,9);
        singleton2.sum(1,9);
    }
}
