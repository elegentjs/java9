package win.elegentjs.concurrent.volatiles;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 演示懒汉式单例模式
 *
 *  此种模式下，需要双重检查
 *
 *  但虚拟机会进行一定程序的优化，即指令重排序，可能会导致运行结果不符合预期
 *  引入关键字volatile能避免这种情况
 *
 */
public class SingleTonSample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int index = 0; index < 10; index ++) {
            executorService.submit(() -> System.out.println(Thread.currentThread().getName() + " : " + QuickSingleTon.getInstance()));
        }

        for (int index = 0; index < 10; index ++) {
            executorService.submit(() -> System.out.println(Thread.currentThread().getName() + " : " + LazySingleTon.getInstance()));
        }
    }

}


class QuickSingleTon {
    private static QuickSingleTon instance = new QuickSingleTon();

    private QuickSingleTon() {}

    public static QuickSingleTon getInstance() {
        return instance;
    }
}


class LazySingleTon {
    private static volatile LazySingleTon lazySingleTon;

    private LazySingleTon() {}


    public static LazySingleTon getInstance() {
        if (lazySingleTon == null) {
            synchronized (LazySingleTon.class) {
                if (lazySingleTon == null) {
                    lazySingleTon = new LazySingleTon();
                }
            }
        }

        return lazySingleTon;
    }
}