package win.elegentjs.datastructor.sort.simple;

import java.util.Arrays;

/**
 * 选择排序
 * 思路：
 *     第一轮：从第二个元素开始与第一个元素进行比较，记下最小值的索引，一轮下来能得出最下的索引，如果不是0则跟第一个进行交换
 *     依次类推
 *
 *     时间复杂度：
 *     执行比较次数N * (N - 1) / 2，执行交换次数 N
 *
 *     与冒泡排序比较发现：比较次数一样，但执行交换次数少了，但大数据量排序时，比较次数是次要的，所以时间复杂度仍然是O(N * N)
 *     但毫无疑问它的排序执行效率是要优于冒泡的
 *
 *
 */
public class SelectionSort {

    public static void sort(int[] array) {

        for (int i = 0; i < array.length - 1; i ++) {

            int index = i;

            for (int j = i + 1; j < array.length; j ++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }

            if (index != i) {
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }


            System.out.println("第" + (i + 1) + "轮排序结果： " + Arrays.toString(array));

        }

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 10, 21, 1, -1};

        sort(array);
    }


}
