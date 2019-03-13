package win.elegentjs.container;


import java.util.Comparator;
import java.util.TreeSet;

import static win.elegentjs.util.PrintUtil.print;


/**
 * treeSet 实现了SortedSet接口，可实现元素保持排序
 */
public class TreeSetSample {

    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();


        treeSet.add("V");
        treeSet.add("C");
        treeSet.add("D");
        treeSet.add("E");
        treeSet.add("A");

        print(treeSet);

        // 可接收一个comparator，自定义排序规则; 如果不指定自定义comparator, 则使用添加元素的comparator方法
        TreeSet<String> treeSet2 = new TreeSet<>((o1, o2) -> -1 * o1.compareTo(o2));
        treeSet2.addAll(treeSet);

        print(treeSet2);
    }
}
