package systemDesign.lowLevelDesign.problems.ProducerConsumerProblem;

public class Main {

    public static void main(String[] args) {

        SharedResource sr = new SharedResource();
        // Single producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    sr.produce(i);
                    Thread.sleep(400);
                }
            } catch (InterruptedException e) {
                System.out.println("exception occurred");
            }
        }, "Producer");

        // Single consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    sr.consumer();
                    Thread.sleep(700);
                }
            } catch (InterruptedException e) {
                System.out.println("exception occurred");
            }
        }, "Consumer");

        producer.start();
        consumer.start();

        //multiple producer and consumer
//         try{
//             for(int i=0;i<5;i++) {
//                 int finalI = i;
//                 Thread t1 = new Thread(() -> {
//                     try {
//                         sr.produce(finalI);
//                     } catch (InterruptedException e) {
//                         throw new RuntimeException(e);
//                     }
//                 });
//                 Thread t2 = new Thread(() -> {
//                     try {
//                         sr.consumer();
//                     } catch (InterruptedException e) {
//                         throw new RuntimeException(e);
//                     }
//                 });
//                 t1.start();
//                 t2.start();
//             }
//            } catch (Exception ex){
//                 System.out.println("exception occurred");
//         }
    }
}
