package win.elegentjs.datastructor.sort.advanced;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void sort(int[] array) {
        // 步长，确定好的步长能提高效率
        int gap = 1;

        while (gap < array.length / 3) {
            gap = gap * 3 + 1;
        }

        int x, j;

        while (gap >= 1) {
            for (int i = gap; i < array.length; i ++) {
                x = array[i];
                j = i - gap;

                //直接插入排序，会向前找所适合的位置
                while (j >= 0 && array[j] > x) {
                    //交换位置
                    array[j + gap] = array[j];
                    j = j - gap;
                }

                array[j + gap] = x;
            }

            gap = (gap - 1) / 3;

        }

    }

}
