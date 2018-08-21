package win.elegentjs.datastructor.recursive;

/**
 * 求阶乘
 */
public class Factorial {

    public static int recursive(int n) {
        if (n == 1) {
            return 1;
        }

        return n * recursive(n - 1);

    }


    public static int noRecursive(int n) {
        int result = 1;

        for (int index = 1; index <= n; index ++) {
            result *= index;
        }

        return result;
    }


    public static void main(String[] args) {

        int result = recursive(10);
        int result2 = noRecursive(10);

        System.out.println("result: " + result);
        System.out.println("result2: " + result2);
    }

}
