package win.elegentjs.datastructor.sort.advanced;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void sort(int[] array) {
        int inner, outer;
        int temp;

        int h = 1;

        int elements = array.length;

        while (h <  elements / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            for(outer = h; outer < elements; outer ++) {
                temp = array[outer];
                inner = outer;

                while (inner > h - 1 && array[inner - h] >= temp) {
                    array[inner] = array[inner - h];
                    inner -= h;
                }

                array[inner] = temp;

            }

            h = (h - 1) / 3;
        }
    }

}
