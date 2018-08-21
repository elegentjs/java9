package win.elegentjs.datastructor.sort.simple;

import java.util.Arrays;

/**
 *
 * 冒泡排序
 *
 *  思路：每轮比较出一个最大或最小值，比较次数最多需要N - 1次，最多需要N - 1轮, 时间复杂度为：O(N * N)
 *  加入flag后能提高排序效率
 */
public class BubbleSort {

    public static void sort(int[] origin) {

        for (int i = 1; i < origin.length; i ++) {
            boolean flag = true;
            for (int j = 0; j < origin.length - i; j ++) {
                if (origin[j] > origin[j + 1]) {
                    int temp = origin[j];
                    origin[j] = origin[j + 1];
                    origin[j + 1] = temp;
                    flag = false;
                }
            }

            if (flag) {
                break;
            }

            System.out.println("第" + i + "次的排序结果是：" + Arrays.toString(origin));
        }


    }


    public static void main(String[] args) {
        int[] origin = {4, 3, 12, 43, 100, 101, 102, 99, 45};

        sort(origin);

    }

}
