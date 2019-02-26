package win.elegentjs.datastructor.sort;

import win.elegentjs.util.ArrayUtil;

import static win.elegentjs.util.PrintUtil.*;

import java.util.Arrays;


/**
 *
 * 冒泡排序
 *
 * 思路：
 *  从第二个开始跟前面的元素两两比较，如果前面比后面的大，位置交换，一轮下来会将最大的冒到最后面
 *  共进行N -1 轮上述过程，排序完成
 *
 *  时间复杂度：O(N * N)
 *
 */
public class BubbleSort {

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i ++) {
            for (int j = 1; j < array.length - i; j ++) {
                if (array[j - 1] > array[j]) {
                    ArrayUtil.swap(array, j - 1, j);
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] source = new int[10000];
        ArrayUtil.fillRandom(source);

        print(Arrays.toString(source));
        long start = System.currentTimeMillis();

        sort(source);

        long end = System.currentTimeMillis();

        print(Arrays.toString(source));
        print("cost time : " + (end - start) + " millis.");
    }

}
