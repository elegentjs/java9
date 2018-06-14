package win.elegentjs.datastructor.queue;

public class ArrayQueue {

    private long[] array;


    private int front;

    private int rear;

    private int maxSize;

    private long items;

    public ArrayQueue(int size) {
        array = new long[size];
        maxSize = size;

        front = 0;
        rear = -1;
        items = 0;
    }


    public void insert(long element) {
        if (rear == maxSize - 1) {
            rear = -1;
        }

        array[++ rear] = element;
        items ++;
    }


    public long remove() {
        long temp = array[front ++];

        if (front == maxSize) {
            front = 0;
        }

        items --;

        return temp;
    }


    public long peekFront() {
        return array[front];
    }




}
