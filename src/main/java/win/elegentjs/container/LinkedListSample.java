package win.elegentjs.container;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static win.elegentjs.util.PrintUtil.print;

/**
 * LinkedList也具有List的基本特性
 * LinkedList底层基于双向链表，所有查找慢，插入，删除快
 *
 *  除了基本的List特性（curd, 遍历），LinkedList还实现了Deque接口，所以可以模拟队列和栈（将双端队列的一端堵住）
 *
 */
public class LinkedListSample {

    public static void main(String[] args) {
        // as a List
        List<Integer> integerList = new LinkedList<>();
        integerList.add(100);
        integerList.add(200);
        integerList.add(300);

        print(integerList);
        print("==================");

        integerList.clear();

        // as Queue（单端队列）
        Queue<Integer> queue = (Queue<Integer>) integerList;

        // 队尾插入元素
        queue.offer(100);
        queue.offer(200);
        queue.offer(300);

        // 打印队首元素
        print("队首元素： " + queue.peek());

        // 移除队首元素
        print("移除队首元素： " + queue.poll());

        // 打印队列
        print("队列： " + queue);

        print("==================");


        // as Deque（作为双端队列）
        integerList.clear();
        Deque<Integer> deque = (Deque<Integer>) integerList;

        // 队首操作（添加）
        deque.offerFirst(100);
        deque.offerFirst(200);
        deque.offerFirst(300);

        // 打印队首元素
        print("队首元素： " + deque.peekFirst());
        // 移除队首元素
        print("移除队首元素： " + deque.pollFirst());

        // 打印队列
        print("队列： " + deque);
        print("==================");

        integerList.clear();
        // 队尾操作（添加）
        deque.offerLast(100);
        deque.offerLast(200);
        deque.offerLast(300);

        // 打印队尾元素
        print("队尾元素： " + deque.peekLast());
        // 移除队尾元素
        print("移除队尾元素： " + deque.pollLast());

        // 打印队列
        print("队列： " + deque);
        print("==================");


        // as 栈
        integerList.clear();
        // 压栈
        deque.push(100);
        deque.push(200);
        deque.push(300);

        // 打印栈顶元素
        print(deque.peek());

        // 取出栈顶元素
        deque.pop();

        // 打印栈
        print(deque);
    }
}
