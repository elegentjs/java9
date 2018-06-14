package win.elegentjs.datastructor.array.binarysearch;

/**
 * 二分查找法
 */
public class BinarySearch {

    public static int binarySearch(int[] arrary, int target) {
        int lower = 0;
        int higher = arrary.length - 1;
        int mid;

        while (true) {
            mid = (lower + higher) / 2;

            if (target == arrary[mid]) {
                return mid;
            }

            if (lower > higher) {
                return -1;
            }

            if (target < arrary[mid]) {
                higher = mid - 1;
            } else {
                lower = mid + 1;
            }
        }

    }


    public static void main(String[] args) {
        int[] array = {1, 4, 5, 32, 49, 58, 69, 100, 190};

        int index = binarySearch(array, 1);

        System.out.println(index);

    }

}
