package win.elegentjs.concurrent.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 演示了forkJoin框架的使用，在本地表现不如单线程，但在服务器多核环境上会有更好的表现
 */
public class ForkJoinSample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = pool.submit(new Task(1, 1000000));

        Integer result = forkJoinTask.get();

        System.out.println(result);

        long end = System.currentTimeMillis();

        System.out.println("cost : " + (end - start) + " mills.");


        start = System.currentTimeMillis();
        System.out.println("result : " + sumRange(1, 1000000));
        end = System.currentTimeMillis();

        System.out.println("cost : " + (end - start) + " mills.");


    }


    public static Integer sumRange(int begin, int end) {
        int result = 0;

        for (int index = begin; index <= end; index ++) {
            result += index;
        }

        return result;
    }
}


class Task extends RecursiveTask<Integer> {

    private int begin;

    private int end;

    public Task(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if (end - begin <= 2) {
            for (int index = begin; index <= end; index ++) {
                sum += index;
            }
        } else {
            Task t1 = new Task(begin, (begin + end) / 2);
            Task t2 = new Task((begin + end) / 2 + 1, end);

            t1.fork();
            t2.fork();

            Integer a = t1.join();
            Integer b = t2.join();

            sum = a + b;
        }

        return sum;
    }
}