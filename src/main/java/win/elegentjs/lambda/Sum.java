package win.elegentjs.lambda;

import java.util.Arrays;
import java.util.List;

public class Sum {
    public static void main(String[] args) {
        int result = sum(Arrays.asList(1, 2, 3, 4, 5 , 6, 7));

        System.out.println(result);

    }


    public static int sum(List<Integer> values) {
        return values.parallelStream().mapToInt(a -> a).sum();

    }
}
