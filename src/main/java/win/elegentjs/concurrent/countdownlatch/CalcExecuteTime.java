package win.elegentjs.concurrent.countdownlatch;


import java.util.List;
import java.util.concurrent.*;

/**
 * 统计执行时间
 *
 *  single Thread vs concurrent
 *
 *  分别用单线程和多线程计算1 + 1000000
 *
 *  从结果可以看出单线程更快，原因：
 *      1）本地pc 核心少不能发挥并发优势
 *      2）线程切换会增加额外开销，反而会降低速度
 *
 *   计算多线程时间时采用了同步工具类：CountDownLatch， 它可以控制线程达到某个条件时执行
 */
public class CalcExecuteTime {

    public static void main(String[] args) {
        long target = 1000000;
        long start = System.currentTimeMillis();

        long result = Singel.plus(target);

        long end = System.currentTimeMillis();

        System.out.println("single thread result : " + result + ", cost : " + (end - start) + " mills.");

        Multi.plus(target, 50);

    }



}


class Singel {
    public static long plus(long target) {
        long result = 0;
        for (long index = 1; index <= target; index ++) {
            result += index;
        }

        return result;
    }
}


class Multi {

   private static ExecutorService executorService = Executors.newFixedThreadPool(1000);


    public static long plus(long target, int thread) {


        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(thread);

        List<Long> list = new CopyOnWriteArrayList<>();


        long split = target / thread;

        for (int index = 1; index <= thread; index ++) {
            final int s = index;
            executorService.submit(() -> {
                try {
                    start.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                long result = 0;
                for (long i = split * (s - 1) + 1; i <= split * (s - 1) + split; i ++) {
                    result += i;
                }

                list.add(result);

                end.countDown();
            });
        }

        long startTime = System.currentTimeMillis();
        start.countDown();

        try {
            end.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long result  = list.parallelStream().mapToLong((i) -> i).sum();

        long endTime = System.currentTimeMillis();

        System.out.println("multi thread result : " + result + ", cost : " + (endTime - startTime) + " mills.");

        executorService.shutdown();

        return result;
    }
}




