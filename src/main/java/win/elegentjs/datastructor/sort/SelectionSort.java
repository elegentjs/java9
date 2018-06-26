package win.elegentjs.datastructor.sort;

/**
 * 选择排序
 *
 *
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

            swap(array, i, minIndex);
        }

    }




    private static void swap(int[] array, int i, int j) {
        int temp = array[i];

        array[i] = array[j];
        array[j] = temp;
    }

}
