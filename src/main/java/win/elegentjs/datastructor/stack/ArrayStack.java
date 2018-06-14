package win.elegentjs.datastructor.stack;

/**
 * 基于数组的栈
 */
public class ArrayStack {

    private long[] stackArray;

    private int top;

    public ArrayStack(int size) {
        stackArray = new long[size];
        top = -1;
    }


    public void push(long element) {
        stackArray[++ top] = element;
    }

    public long pop() {
        return stackArray[top --];
    }

    public long peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stackArray.length - 1;
    }



    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(100);
        System.out.println("isEmpty: " + stack.isEmpty());
        System.out.println("isFull: " + stack.isFull());

        stack.push(1);
        stack.push(2);

        System.out.println(stack.peek());

        long e = stack.pop();


        System.out.println(stack.peek());
    }

}
