package win.elegentjs.concurrent.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SequenceSample {

    public static void main(String[] args) throws InterruptedException {
        OriginSeq seq = new OriginSeq();

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for (int index = 0; index < 50; index ++) {
            Thread.sleep(10);
            executorService.submit(seq::add);
            executorService.submit(() -> {
                System.out.println("current val : " + seq.getVal());
            });
        }

        executorService.shutdown();

    }


}

class OriginSeq {
    private Integer val = 1;

    public Integer getVal() {
        return val;
    }

    public void add() {
        val ++;
    }
}

class Seq {
    private AtomicInteger val = new AtomicInteger();

    public Integer getVal() {
        return val.get();
    }

    public void add() {
        val.incrementAndGet();
    }
}