package win.elegentjs.concurrent.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 采用Atomic类可以保证原子性
 */
public class SequenceSample {

    public static void main(String[] args) throws InterruptedException {
        Seq seq = new Seq();

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        executorService.submit(() -> {
            while (true) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " : seq : " + seq.getNext());

            }
        });

        executorService.submit(() -> {
            while (true) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " : seq : " + seq.getNext());

            }
        });

        executorService.shutdown();

    }


}

class OriginSeq {
    private Integer val = 1;

    public Integer getNext() {
        return val ++;
    }
}

class Seq {
    private AtomicInteger val = new AtomicInteger();

    public Integer getNext() {
        return val.incrementAndGet();
    }

}