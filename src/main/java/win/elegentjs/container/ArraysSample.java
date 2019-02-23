package win.elegentjs.container;

import java.util.Arrays;
import java.util.List;

/**
 * 本类是Array工具类，是Java Collection Framework家族中的一员
 *
 * 本类演示Arrays帮助类，提供的方法如下：
 *
 *  sort
 *  parallelSort
 *  binarySearch
 *  fill
 *  copyOf
 *  asList
 *  toString
 *
 */
public class ArraysSample {

    public static void main(String[] args) {

        int[] array = new int[1024];
        Arrays.fill(array, 100);

        System.out.println(Arrays.toString(array));

        Arrays.parallelSort(array);

        int index = Arrays.binarySearch(array, 100);
        System.out.println("index : " + index);

    }
}
