package systemDesign.lowLevelDesign.DesignPatterns.singleton;

public class Singleton {
    private static volatile Singleton instance;
    //When a variable is declared volatile, changes made to it by one thread
    // are immediately visible to all other threads.
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

    public void sum(int a, int b){
        System.out.println("sum of "+a+" and "+b+" is equal to "+a+b);
    }
}