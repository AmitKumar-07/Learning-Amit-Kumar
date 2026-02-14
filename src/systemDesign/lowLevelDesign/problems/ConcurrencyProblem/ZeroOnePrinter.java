package systemDesign.lowLevelDesign.problems.ConcurrencyProblem;

class ZeroOnePrinter {

    private int n;
    private boolean zeroTurn = true;  // zero prints first

    public ZeroOnePrinter(int n) {
        this.n = n;
    }

    public void printZero() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (!zeroTurn) {
                    wait();
                }
                System.out.print(0 + " ");
                zeroTurn = false;
                notify();
            }
        }
    }

    public void printOne() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (zeroTurn) {
                    wait();
                }
                System.out.print(1 + " ");
                zeroTurn = true;
                notify();
            }
        }
    }
}

class Main2 {
    public static void main(String[] args) {

        ZeroOnePrinter printer = new ZeroOnePrinter(5);

        Thread t1 = new Thread(() -> {
            try {
                printer.printZero();
            } catch (Exception ignored) {}
        });

        Thread t2 = new Thread(() -> {
            try {
                printer.printOne();
            } catch (Exception ignored) {}
        });

        t1.start();
        t2.start();
    }
}