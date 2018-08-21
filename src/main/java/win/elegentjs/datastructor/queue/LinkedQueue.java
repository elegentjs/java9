package win.elegentjs.datastructor.queue;


import win.elegentjs.datastructor.link.DoubleLinkedList;

/**
 * 基于双端链表实现的队列
 */
public class LinkedQueue {

    private DoubleLinkedList list;

    public LinkedQueue() {
        list = new DoubleLinkedList();
    }

    public void add(Object element) {
        list.addTail(element);
    }

    public void remove() {
        list.del();
    }


    public void display() {
        list.display();
    }


    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();

        for (int index = 0; index < 10; index ++) {
            queue.add(index);
        }

        queue.display();

        queue.remove();

        queue.display();
    }
}
