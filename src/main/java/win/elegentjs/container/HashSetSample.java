package win.elegentjs.container;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static win.elegentjs.util.PrintUtil.print;

public class HashSetSample {

    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();

        hashSet.add("b");
        hashSet.add("b");
        hashSet.add("a");
        hashSet.add("c");
        hashSet.add("d");
        hashSet.add("e");


        print(hashSet);

        /*

            迭代器模式，所有Collection子类都实现了iterator方法，都能以统一的方式进行迭代
         */
        Iterator<String> iterator = hashSet.iterator();

        while (iterator.hasNext()) {
            String s = iterator.next();

            print(s);
        }



    }
}
