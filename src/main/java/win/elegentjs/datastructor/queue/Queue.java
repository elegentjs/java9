package win.elegentjs.datastructor.queue;


/**
 *
 * 队列是一种先进先出（FIFO）的数据结构，跟日常的排队买票类似，本类是
 * 单向队列，只允许一端进，另一端出
 *
 * 具体就是队尾进，队头出
 *
 * 定义两个指针：
 *
 *   front: 指向队头指针
 *   rear: 指向队尾指针
 *
 */
public class Queue {

    //队首指针
    private int front;

    // 队尾指针
    private int rear;

    // 队列存储元素的底层数组
    private Object[] elementData;

    // 队列容纳元素的大小
    private int maxSize;

    // 当前队列中元素的个数
    private int items;

    public Queue(int size) {
        this.maxSize = size;

        front = 0;
        rear = -1;

        items = 0;

        elementData = new Object[maxSize];
    }

    /**
     * 判断队列是否已满
     * @return
     */
    public boolean isFull() {
        return items == maxSize;
    }

    /**
     * 判断队列是否是空的
     * @return
     */
    public boolean isEmpty() {
        return items == 0;
    }

    /**
     * 当前队列中元素的个数
     * @return
     */
    public int size() {
        return items;
    }

    /**
     * 往队列中新增元素
     * @param element
     */
    public void add(Object element) {
        if (isFull()) {
            throw new IllegalStateException("队列已满");
        }

        // 指向最后一个指针了，移到最前端
        if (rear == maxSize - 1) {
            rear = -1;
        }

        elementData[++ rear] = element;
        items ++;
    }

    /**
     * 从队列头部移除元素
     * @return
     */
    public Object remove() {
        if (isEmpty()) {
            throw new IllegalStateException("当前队列是空的！");
        }

        Object target = elementData[front];
        elementData[front] = null;

        front ++;

        if (front == maxSize) {
            front = 0;
        }

        items --;

        return target;

    }



}
