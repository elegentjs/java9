package win.elegentjs.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static win.elegentjs.util.PrintUtil.print;

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

    public static void sort(Method method) {
        int[] source = new int[100];
        ArrayUtil.fillRandom(source);

        print(Arrays.toString(source));
        long start = System.currentTimeMillis();

        try {
            method.invoke(null, source);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }

        long end = System.currentTimeMillis();

        print(Arrays.toString(source));
        print("cost time : " + (end - start) + " millis.");
    }
}

