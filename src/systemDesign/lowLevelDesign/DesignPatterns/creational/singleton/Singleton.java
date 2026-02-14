package systemDesign.lowLevelDesign.DesignPatterns.creational.singleton;

public class Singleton {
    private static volatile Singleton instance;
    // Volatile: works at the JVM memory model level. When one thread writes to a volatile variable,
    // the value is immediately flushed to main memory, and other threads are forced to read the latest
    // value from main memory instead of using their CPU cache. It also prevents instruction reordering
    // around that variable, which is critical in double-checked locking.

    //Monitor (synchronized): A monitor is an internal lock every Java object has and Singleton.class is
    // also a object of type Class. When you use synchronized, a thread acquires that object's monitor
    // so only one thread can execute that block at a time, ensuring mutual exclusion and thread safety.

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) { // First check
            synchronized (Singleton.class) {
                if (instance == null) { // Second check
                    System.out.println("Creating object of singleton class");
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}