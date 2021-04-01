package win.elegentjs.datastructor.sort.advanced;

/**
 * 快速排序
 *
 * 时间复杂度：O(n * logn)
 *
 */
public class QuickSort {

    public static void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    /**
     * 快速排序
     *
     * @param array
     * @param lo
     * @param hi
     */
    private static void quickSort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        //进行第一轮排序获取分割点
        int index = partition(array, lo, hi);
        //排序前半部分
        quickSort(array, lo, index - 1);
        //排序后半部分
        quickSort(array, index + 1, hi);
    }

    /**
     * 一次快速排序
     *
     * @param array 数组
     * @param lo    数组的前下标
     * @param hi    数组的后下标
     * @return key的下标index，也就是分片的间隔点
     */
    private static int partition(int[] array, int lo, int hi) {
        /** 固定的切分方式 */
        int key = array[lo];//选取了基准点
        while (lo < hi) {
            //从后半部分向前扫描
            while (array[hi] >= key && hi > lo) {
                hi--;
            }
            array[lo] = array[hi];
            //从前半部分向后扫描
            while (array[lo] <= key && hi > lo) {
                lo++;
            }
            array[hi] = array[lo];
        }
        array[hi] = key;//最后把基准存入
        return hi;
    }

}
