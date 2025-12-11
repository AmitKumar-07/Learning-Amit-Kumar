package systemDesign.lowLevelDesign.problems.ProducerConsumerProblem;

public class SharedResource {

    private int data;
    private boolean hasData;

    public synchronized void produce(int value) throws InterruptedException {

        while(hasData){
            wait();
        }

        data = value;
        hasData = true;
        System.out.println(data+" : data produced for thread: "+Thread.currentThread().getName());
        notify();
    }

    public synchronized void consumer() throws InterruptedException {
        while(!hasData){
            wait();
        }

        System.out.println(data + " : data consumed by thread: " + Thread.currentThread().getName());
        hasData = false;
        notify();
    }
}
