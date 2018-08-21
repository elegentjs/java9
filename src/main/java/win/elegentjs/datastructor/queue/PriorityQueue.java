package win.elegentjs.datastructor.queue;

/**
 * 优先级队列按照关键字插入时保持排序
 * 对优先级队列的操作通常有：
 *
 *  1）插入
 *  2）查找
 *  3）删除
 */
public class PriorityQueue {

    private int maxSize;

    private int[] elementData;

    private int items;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;

        items = 0;

        elementData = new int[maxSize];
    }

    /**
     * 当前队列的最大容量
     * @return
     */
    public int size() {
        return maxSize;
    }

    /**
     * 判断当前队列是否已满
     * @return
     */
    public boolean isFull() {
        return items == maxSize;
    }


    /**
     * 判断当前队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return items == 0;
    }

    /**
     * 插入元素至优先级队列
     * @param element
     */
    public void add(int element) {

        if (isFull()) {
            throw new IllegalStateException("优先级队列已满");
        }

        if (items == 0) {
            elementData[items ++] = element;
            return;
        }

        // 当前队列最大元素的索引位
        int j = items - 1;

        while (j >= 0 && element < elementData[j]) {
            elementData[j + 1] = elementData[j];
            j --;
        }

        elementData[ j + 1] = element;
        items ++;
    }


    /**
     * 队头移除优先级最高的元素
     * @return
     */
    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException("当前队列为空");
        }
        int k = items - 1;
        int value = elementData[k];

        elementData[k] = -1;
        items --;

        return value;
    }
}
