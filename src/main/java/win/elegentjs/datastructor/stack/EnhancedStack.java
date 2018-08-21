package win.elegentjs.datastructor.stack;

import java.util.Arrays;

/**
 * 增强版本的栈，可以解决普通的Stack只能存储具体数据类型的数据（Stack中只能存储int）;
 * 可以解决容量达到上限后不够的问题
 */
public class EnhancedStack {

    private Object[] elementsData;

    private int size = 10;

    private int top = -1;

    public EnhancedStack(int size) {
        this.size = size;

        elementsData = new Object[size];
    }

    public EnhancedStack() {
        elementsData = new Object[size];
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 获取当前栈最大容量
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 判断是否需要执行扩容（按两倍进行扩容）
     */
    private void ensureCapacity() {
        if (top == size - 1) {
            elementsData = Arrays.copyOf(elementsData, elementsData.length * 2);
            size = elementsData.length;
        }
    }

    /**
     * 压栈
     * @param element
     */
    public void push(Object element) {
        ensureCapacity();

        elementsData[++ top] = element;
    }


    /**
     * 出栈
     */
    public Object pop() {
        if (isEmpty()) {
            throw new IllegalStateException("栈为空！");
        }

        return elementsData[top --];
    }


    /**
     * 获取栈顶元素
     * @return
     */
    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("栈为空！");
        }

        return elementsData[top];
    }


}
