package myatomicinteger;

public class TestInteger {
    private static MyAtomicInteger counter = new MyAtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("T1:" + Thread.currentThread().getName());
                int i = 0;
                while (i < 2_000_000) {
                    counter.increment();
                    i++;
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("T2:" + Thread.currentThread().getName());
                int i = 0;
                while (i < 2_000_000) {
                    counter.increment();
                    i++;
                }
            }
        });
        long startTime = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("counter:" + counter.toString());
        System.out.println("duartion:" + (System.currentTimeMillis() - startTime));
    }
}