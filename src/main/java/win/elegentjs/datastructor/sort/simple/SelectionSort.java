package win.elegentjs.datastructor.sort.simple;

import win.elegentjs.util.ArrayUtil;

/**
 * 选择排序
 *
 * 核心算法：
 *
 *  从第0个元素开始依次跟其余的元素进行比较，决定最小的元素，
 *  然后再从第1个元素开始比较决定第二小的元素，依次类推做完排序
 *
 *  时间复杂度 O（N * N）
 *  空间复杂度 O (N)
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
