package lock.atom;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomTwo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(2);
        AtomicInteger i = new AtomicInteger(0);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 5000; j++) {
                    i.incrementAndGet();
                }
                cdl.countDown();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 5000; j++) {
                    i.incrementAndGet();
                }
                cdl.countDown();
            }
        });
        t1.start();
        t2.start();

        cdl.await();
        System.out.println("result=" + i.get());
    }

}
