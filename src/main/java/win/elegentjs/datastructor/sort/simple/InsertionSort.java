package win.elegentjs.datastructor.sort.simple;

import win.elegentjs.util.ArrayUtil;

/**
 * 直接插入排序
 *
 * 直接插入排序的思想是整体排序是渐进的过程，先前两个，后面的元素依次往前面插入，找到对应的位置
 *
 * 时间复杂度 O(n * n)
 * 空间复杂度 O(n)
 */
public class InsertionSort {

    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i ++) {

            int temp = array[i];

            int j;
            for (j = i - 1; j >= 0 && temp < array[j]; j --) {
                array[j + 1] = array[j];
            }

            array[j + 1] = temp;
        }
    }


    public static void main(String[] args) throws NoSuchMethodException {
        ArrayUtil.sort(InsertionSort.class.getMethod("sort", int[].class));
    }

}
