package win.elegentjs.datastructor.recursive;

/**
 *
 * 采用非递归和递归算法进行二分查找
 *
 */
public class BinarySearch {

    /**
     * 非递归二分查找目标元素下标
     * @param array
     * @param key
     * @return
     */
    public static int search(int[] array, int key) {

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (key == array[mid]) {
                return mid;
            }


            if (key > array[mid]) {
                low = mid + 1;
            }

            if (key < array[mid]) {
                high = mid - 1;
            }

        }

        return -1;
    }


    /**
     * 递归方式二分法查找
     * @param array
     * @param key
     * @param low
     * @param high
     * @return
     */
    public static int recursive(int[] array, int key, int low, int high) {
        int mid = (low + high) / 2;

        if (key == array[mid]) {
            return mid;
        }


        if (low > high) {return -1;}

        if (key < array[mid]) {
            return recursive(array, key, low, mid - 1);
        }

        if (key > array[mid]) {
            return recursive(array, key, mid + 1, high);
        }

        return -1;

    }


    public static void main(String[] args) {
        int[] origin = new int[100000000];

        for (int index = 0; index < origin.length; index ++) {
            origin[index] = index;
        }

        long start = System.currentTimeMillis();
        int index1 = BinarySearch.search(origin, 1000);
        long end = System.currentTimeMillis();


        int index2 = BinarySearch.recursive(origin, 1000, 0, origin.length - 1);
        long end2 = System.currentTimeMillis();



        System.out.println("index1: " + index1 + ", cost: " + (end - start) + " mills.");

        System.out.println("index2: " + index2 + ", cost: " + (end2 - end) + " mills.");
    }

}
