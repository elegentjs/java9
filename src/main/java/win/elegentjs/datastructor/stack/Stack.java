package win.elegentjs.datastructor.stack;

/**
 * 栈：LIFO, 是一种程序员辅助工具，通常用来执行特殊任务
 *
 *  编程中最常见的栈结构是线程调用方法的执行模型
 *  此处以底层顺序存储的线性表（Array）来实现栈
 *
 */
public class Stack {

    private int[] array;

    // 栈最大容量
    private int size;

    // 栈顶指针，在本例中就是栈顶元素的下标，栈为空时，为-1
    private int top;

    public Stack(int length) {
        this.size = length;
        array = new int[size];
        top = -1;
    }

    /**
     * 获取栈容量
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 判断当前栈是否为空
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 判断当前栈是否已满
     * @return
     */
    public boolean isFull() {
        return top == array.length - 1;
    }


    /**
     * 执行压栈操作
     * @param element
     */
    public void push(int element) {
        if (isFull()) {
            throw new IllegalStateException("栈已满！");
        }

        array[++ top] = element;
    }

    /**
     * 出栈
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("栈为空！");
        }

        return array[top --];
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("栈为空！");
        }

        return array[top];
    }


    /**
     * 打印栈中元素（从栈顶开始，实际不会这么遍历栈，这里是为了方便查看栈中元素）
     */
    public void display() {
        for (int index = top; index >= 0; index --) {
            System.out.print((char)array[index] + " ");
        }
        System.out.println();
    }

    /**
     * 逆序打印栈中元素
     */
    public void displayReverse() {
        for (int index = 0; index <= top; index ++) {
            System.out.print((char)array[index] + " ");
        }
        System.out.println();

    }
}
