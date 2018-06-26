package win.elegentjs.datastructor.sort;

public class MergeSort {


    public static void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }


    private static void mergeSort(int[] array, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        }


        int mid = (lowerBound + upperBound) / 2;

        mergeSort(array, lowerBound, mid);
        mergeSort(array, mid + 1, upperBound);


        merge(array, lowerBound, mid + 1, upperBound);

    }


    private static void merge(int[] array, int lowPtr, int highPtr, int upperBound) {
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;
        int[] temp = new int[n];

        while (lowPtr <= mid && highPtr <= upperBound) {
            if (array[lowPtr] < array[highPtr]) {
                temp[j ++] = array[lowPtr ++];
            } else {
                temp[j ++] = array[highPtr ++];
            }
        }

        while (lowPtr <= mid) {
            temp[j ++] = array[lowPtr ++];
        }

        while (highPtr <= upperBound) {
            temp[j ++] = array[highPtr ++];
        }

        for (j = 0; j < n; j ++) {
            array[lowerBound + j] = temp[j];
        }
    }

}
