package win.elegentjs.util;

public class ArrayUtil {

    public static void fillRandom(int[] array) {
        for (int index = 0; index < array.length; index ++) {
            array[index] = (int)(Math.random() * 100);
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

