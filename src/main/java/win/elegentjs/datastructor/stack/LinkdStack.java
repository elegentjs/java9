package win.elegentjs.datastructor.stack;


import win.elegentjs.datastructor.link.SingleLinkedList;

/**
 * 基于单向链表的栈结构
 */
public class LinkdStack {

    private SingleLinkedList linkedList;

    public LinkdStack() {
        linkedList = new SingleLinkedList();
    }


    public void push(Object element) {
        linkedList.add(element);
    }

    public Object pop() {
        return linkedList.del();
    }


    public Object peek() {
        return linkedList.find();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }


    public static void main(String[] args) {
        LinkdStack linkdStack = new LinkdStack();

        for (int index = 0; index < 100; index ++) {
            linkdStack.push(index);
        }

        linkdStack.pop();
        linkdStack.pop();
        linkdStack.pop();

        int topElement = (Integer) linkdStack.peek();

        System.out.println("top: " + topElement);

    }

}
