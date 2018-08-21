package win.elegentjs.datastructor.sort.simple;

import java.util.Arrays;

/**
 * 直接插入排序
 *
 *  算法思路：从第二个元素开始跟第一个元素比较确定两个元素的位置关系（从小到大排序就是小的在前，大的在后）
 *
 *  一轮排序后前两个元素的位置关系就确定了
 *
 *  依次类推，后续的元素继续往前面已排序好的集合中找到对应的位置，知道排序完成
 *
 *  时间复杂度O(N * N), 随机数据时执行速度比冒泡快一倍，比选择排序也略快，但如果初始数据完全倒序时，执行速度就不比冒泡和选择快了
 *
 */
public class InsertionSort {


    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i ++) {
            int tmp = array[i]; // 即将要插入的数据

            int j = i;

            while (j> 0 && tmp < array[j - 1]) {
                array[j] = array[j - 1];
                j --;
            }

            array[j] = tmp;

            System.out.println("第" + i + "轮排序后的结果： " + Arrays.toString(array));
        }


    }


    public static void main(String[] args) {
        int[] array = {2, 1, 100, 34, 35, 45, 68, 98};

        sort(array);


    }

}
