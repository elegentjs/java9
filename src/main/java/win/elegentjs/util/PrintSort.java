package win.elegentjs.util;

import java.util.Arrays;

public class PrintSort {

    public static void execute(ArrayEnum arrayEnum, String sortType, Sortable sortable) {
        String arrayName;

        switch (arrayEnum) {
            case ONE_THOUSAND:
                arrayName = "oneThousandArray.txt";
                break;

            case TEN_THOUSAND:
                arrayName = "tenThousandArray.txt";
                break;

            case ONE_HUNDRED_THOUSAND:
                arrayName = "oneHundredThousandArray.txt";
                break;

            case ONE_MILLION:
                arrayName = "oneMillionArray.txt";
                break;

            default:
                throw new IllegalArgumentException("wrong arrayEnum");
        }


        int[] array = FileUtil.classpathFileToArray(arrayName);

        long start = System.currentTimeMillis();

        sortable.sort(array);

        long end = System.currentTimeMillis();

        StringBuilder temp = new StringBuilder("==========> sort: " + sortType);
        while (temp.length() < 27) {
            temp.append(" ");
        }

        //System.out.println("array: " + Arrays.toString(array));
        System.out.println(temp + ", cost time: " + (end - start) + " mills. ===================");
    }
}
