package win.elegentjs.datastructor.queue;

import java.util.Random;

public class TestQueue {

    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.add(new Random().nextInt(10));
        queue.add(new Random().nextInt(10));
        queue.add(new Random().nextInt(10));
        queue.add(new Random().nextInt(10));
        queue.add(new Random().nextInt(10));

        queue.remove();
        queue.add(new Random().nextInt(10));

        queue.remove();
        queue.add(new Random().nextInt(10));

        for (int index = 0; index < Integer.MAX_VALUE / 10; index ++) {
            queue.remove();
            queue.add(1);
        }


        PriorityQueue priorityQueue = new PriorityQueue(10);

        for (int index = 0; index < priorityQueue.size(); index ++) {
            int e = new Random().nextInt(1000);
            System.out.println("queue element: " + e);
            priorityQueue.add(e);
        }

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.remove());
        }

    }
}
