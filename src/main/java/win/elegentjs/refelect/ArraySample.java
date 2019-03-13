package win.elegentjs.refelect;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 演示
 */
public class ArraySample {

    public static void main(String[] args) {
        int[] array = (int[])Array.newInstance(int.class, 10);

        Arrays.fill(array, 10);

        System.out.println(Arrays.toString(array));

        Array.set(array, 9, 11);

        System.out.println(Arrays.toString(array));

    }
}
