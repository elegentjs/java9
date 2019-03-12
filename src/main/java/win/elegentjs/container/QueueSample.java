package win.elegentjs.container;


import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static win.elegentjs.util.PrintUtil.print;

/**
 * 队列基本特性队尾进，队首出
 *
 * 队列按两侧是否都可以插入和移除分为单端队列和双端队列
 * 队列按是否阻塞可以分为阻塞式队列和非阻塞式队列
 * 队列按是否始终保持插入的元素有序可分为优先级队列和非优先级队列
 *
 */
public class QueueSample {


    public static void main(String[] args) throws InterruptedException {
        // 单端队列；双端队列
        // 这个比较简单，实现Queue接口的是单端队列；实现Deque接口的是双端队列
        // 典型的是LinkedList

        // BlockingQueue; UnBlockingQueue
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);
        blockingQueue.put(1);
        blockingQueue.put(2);
        blockingQueue.put(3);

        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();

        //blockingQueue.take(); blocked.

        print(blockingQueue);


        // PriorityQueue; UnPriorityQueue
        Queue<String> queue = new PriorityQueue<>();
        queue.offer("2");
        queue.offer("1");
        queue.offer("3");
        queue.offer("0");

        print(queue);
    }

}
