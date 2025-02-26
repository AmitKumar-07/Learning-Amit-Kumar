import java.util.concurrent.locks.ReentrantLock;

public class Resource {

    boolean isAvailable;
    void produce(ReentrantLock reentrantLock){
        try{
            reentrantLock.lock();
            System.out.println("lock acquired by thread: "+ Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
            System.out.println("lock release by thread: "+ Thread.currentThread().getName());
        }catch (Exception ex){

        }
        finally {
            reentrantLock.unlock();
        }
    }
}
