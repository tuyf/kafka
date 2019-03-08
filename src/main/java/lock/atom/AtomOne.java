package lock.atom;

import java.util.concurrent.CountDownLatch;

public class AtomOne {

    private static int m = 0;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(2);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 5000; j++) {
                    m++;
                }
                cdl.countDown();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 5000; j++) {
                    m++;
                }
                cdl.countDown();
            }
        });
        t1.start();
        t2.start();

        cdl.await();
        System.out.println("result=" + m);
    }

}
