package comparethread;

public class CompareThread {
    public static long time, synchroStart, synchroEnd, normalStart, normalEnd;
    public static void main(String[] args) throws InterruptedException {

        Thread t1;
        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchroStart = System.nanoTime(); 
                synchronized (this) {
                    for (int i = 1; i <= 10000; i++) {
                        Thread.currentThread().getName();
                    }
                    synchroEnd = System.nanoTime();
                    time = (synchroEnd - synchroStart);
                    System.out.printf("Synchronized thread = %.8f seconds%n", time / 1000000.0);

                }
            }
        });
        Thread t2;
        t2 = new Thread(() -> {            
            normalStart = System.nanoTime();
            for (int i = 1; i <= 10000; i++) {
                Thread.currentThread().getName();
            }
            normalEnd = System.nanoTime();
            time = (normalEnd - normalStart);
            System.out.printf("Normal thread = %.8f seconds%n", time / 1000000.0);
        });
        t1.start();
        t2.start();
    }
}
