package win.elegentjs.datastructor.queue;

import java.util.Random;

public class PriorityQueue {

    private int maxSize;

    private long[] queArray;

    private int items;


    public PriorityQueue(int size) {
        maxSize = size;
        queArray = new long[maxSize];
        items = 0;
    }

    public void insert(long item) {
        int j;

        if (items == 0) {
            queArray[items ++] = item;
        } else {
            for (j = items - 1; j >=0; j --) {
                if (item > queArray[j]) {
                    queArray[j + 1] = queArray[j];
                } else {
                    break;
                }
            }


            queArray[j + 1] = item;
            items ++;


        }
    }


    public long remove() {
        return queArray[-- items];
    }

    public long peekMin() {
        return queArray[items - 1];
    }

    public boolean isEmpty() {
        return items == 0;
    }

    public boolean isFull() {
        return items == maxSize;
    }

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue(100);

        while (!queue.isFull()) {
            queue.insert(new Random().nextInt(1000));
        }


        while (!queue.isEmpty()) {
            long item = queue.remove();
            System.out.print(item + " ");
        }

        System.out.println();
    }

}
