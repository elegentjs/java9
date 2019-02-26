package win.elegentjs.datastructor.sort.simple;

import win.elegentjs.datastructor.array.Array;
import win.elegentjs.util.ArrayUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import static win.elegentjs.util.PrintUtil.print;

/**
 * 选择排序
 */
public class SelectionSort {

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i ++) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j ++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            ArrayUtil.swap(array, i, minIndex);
        }

    }


    public static void main(String[] args) throws NoSuchMethodException {
       ArrayUtil.sort(SelectionSort.class.getMethod("sort", int[].class));
    }

}
