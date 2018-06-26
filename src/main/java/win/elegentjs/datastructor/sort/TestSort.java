package win.elegentjs.datastructor.sort;

import win.elegentjs.datastructor.sort.advanced.ShellSort;
import win.elegentjs.util.ArrayEnum;
import win.elegentjs.util.PrintSort;

public class TestSort {

    public static void main(String[] args) {
        // one thousand(1,000)
        //sortTest(ArrayEnum.ONE_THOUSAND);

        // ten thousand(10,000)
        //sortTest(ArrayEnum.TEN_THOUSAND);

        // one hundred thousand(100,000)
        //sortTest(ArrayEnum.ONE_HUNDRED_THOUSAND);

        // one million(1,000,000)
        sortTest(ArrayEnum.ONE_MILLION);

    }




    public static void sortTest(ArrayEnum arrayEnum) {
        System.out.println("====================== " + arrayEnum.name()  + "统计 =============================");
        //bubble
        //PrintSort.execute(arrayEnum, "bubble", BubbleSort::sort);
        //selection
        PrintSort.execute(arrayEnum, "selection", SelectionSort::sort);
        //insertion
        PrintSort.execute(arrayEnum, "insertion", InserctionSort::sort);
        //merge
        PrintSort.execute(arrayEnum, "merge", MergeSort::sort);
        //shell
        PrintSort.execute(arrayEnum, "shell", ShellSort::sort);

        System.out.println("=============================== END ================================");
    }

}
