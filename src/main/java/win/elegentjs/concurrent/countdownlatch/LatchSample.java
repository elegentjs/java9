package win.elegentjs.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 递减锁存器的使用
 */
public class LatchSample {

    public static void main(String[] args) {
         CountDownLatch latch = new CountDownLatch(3);
         Calc calc = new Calc();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(() -> {
            calc.calcSingle("3,1,2,3,4,5", 0, latch);
        });

        executorService.submit(() -> {
            calc.calcSingle("3,1,2,3,4,5", 1, latch);
        });

        executorService.submit(() -> {
            calc.calcSingle("3,1,2,3,4,5", 2, latch);
        });

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("total : " + calc.calcTotal());

    }
}


class Calc {

    private int[] result = new int[3];


    public void calcSingle(String line, int index, CountDownLatch latch) {
        String[] lineArray = line.split(",");

        int tmp = 0;
        for (int i = 0; i < lineArray.length; i ++) {
            tmp += Integer.parseInt(lineArray[i]);
        }

        result[index] = tmp;

        latch.countDown();
    }


    public Integer calcTotal() {
        int temp = 0;
        for (int item : result) {
            temp += item;
        }

        return temp;
    }

}
