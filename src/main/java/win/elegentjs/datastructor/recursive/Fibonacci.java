package win.elegentjs.datastructor.recursive;

// 打印斐波那契数列
public class Fibonacci {

    private static int[] fibonacci = new int[100];

    /**
     * 获取第n个斐波那契数列值
     * @param n
     */
    public static int fibonacci(int n) {
        if (fibonacci[n - 1] != 0) {
            return fibonacci[n - 1];
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        fibonacci[n - 1] = fibonacci(n - 1) + fibonacci(n - 2);
        return fibonacci[n - 1];
    }

    public static void main(String[] args) {

        for (int index = 1; index <= 30; index ++) {
            System.out.println(fibonacci(index));
        }
    }
}
