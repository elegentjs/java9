package win.elegentjs.datastructor.link;

/**
 * 双端链表
 *
 * 在单向链表的基础上在Node节点上新增tail指针，指向当前链表的最后一个元素
 * 这样也可以很方便的在表尾新增元素
 */
public class DoubleLinkedList {

    /**
     * 当前双端链表元素的数量
     */
    private int size;

    /**
     * 指向头节点的指针
     */
    private Node head;

    /**
     * 指向尾节点的指针
     */
    private Node tail;


    public DoubleLinkedList() {
        this.size = 0;
        head = null;
        tail = null;
    }

    /**
     * 在头部添加元素
     * @param element
     */
    public void addHead(Object element) {
        Node newNode = new Node(element);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        size ++;
    }

    /**
     * 在尾部添加元素
     * @param element
     */
    public void addTail(Object element) {
        Node newNode = new Node(element);

        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size ++;
    }

    /**
     * 删除队头元素
     * @return
     */
    public Object del() {
        if (size == 0) {
            throw new IllegalStateException("empty list");
        }

        Object target = head.data;

        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }

        size --;

        return target;
    }

    /**
     * 判断当前队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 从链表头开始遍历打印链表
     */
    public void display() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
        System.out.println();

    }


    /**
     * 嵌套内部类，用于描述节点，对外部不可见
     */
    private static class Node {
        private Object data;

        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

}
