package win.elegentjs.datastructor.link;

/**
 * 单向链表
 *
 *  每个节点上只有一个指针，指向下一个节点
 *
 *  需要遍历查找时也只能从头开始往后查找
 *
 */
public class SingleLinkedList {

    private int size;

    // 头节点
    private Node head;

    // default constructor
    public SingleLinkedList() {
        size = 0;
        head = null;
    }

    /**
     * 往链表中新添元素
     * @param element
     */
    public void add(Object element) {
        Node newHead = new Node(element);

        if (head == null) {
            head = newHead;
        } else {
            newHead.next = head;
            head = newHead;
        }

        size ++;
    }

    /**
     * 删除链表头部元素
     */
    public Object del() {
        Node target = head;
        head = head.next;
        size --;

        return target.data;
    }

    /**
     * 返回链表头元素
     * @return
     */
    public Object find() {
        return head.data;
    }

    /**
     * 在链表中遍历，找出目标元素
     * @param element
     * @return
     */
    public Node find(Object element) {
        Node current = head;

        while (current != null) {
            if (current.data.equals(element)) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    /**
     * 删除指定元素
     * @param element
     * @return
     */
    public boolean del(Object element) {
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.data.equals(element)) {
                break;
            }

            prev = current;
            current = current.next;
        }

        // 遍历到队尾也没能找到目标元素
        if (current == null) {
            return false;
        }

        // 找到的目标元素是head
        if (prev == null) {
            head = current.next;
        } else { // 找到的目标元素非head
            prev.next = current.next;
        }

        size --;

        return true;
    }

    /**
     * 判断链表是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 迭代打印链表元素
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


    private static class Node {
        private  Object data;

        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }


    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();

        for (int index = 0; index < 10; index ++) {
            linkedList.add(String.valueOf(index));
        }

        linkedList.display();

        linkedList.del();

        linkedList.display();

        linkedList.add("-1");

        linkedList.display();

        Node node = linkedList.find("5");

        System.out.println("node: " + node.data);

        linkedList.del("3");

        linkedList.display();

    }
}
