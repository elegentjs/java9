package win.elegentjs.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 获取线程任务返回值和异常处理方法
 */
public class CallableSample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            System.out.println("in call method.");
            return 1;
        });

        new Thread(futureTask).start();

        System.out.println("in main method.");

        Integer result = futureTask.get();
        System.out.println("result = " + result);
    }
}



