package win.elegentjs.datastructor.sort;

/**
 *
 * 冒泡排序
 *
 */
public class BubbleSort {


    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i ++) {
            for (int j = 1; j < array.length - i; j ++) {
                if (array[j] < array[j - 1]) {
                    swap(array, j,  j - 1);
                }
            }
        }
    }



    private static void swap(int[] array, int j, int k) {
        int temp = array[j];
        array[j] = array[k];
        array[k] = temp;
    }

}
