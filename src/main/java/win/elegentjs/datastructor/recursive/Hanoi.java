package win.elegentjs.datastructor.recursive;

/**
 * 汉诺塔求解
 *
 * 有ABC三个柱子，A柱上有N个盘子，从上到下盘子以从小到大排列
 *
 * 将盘子全部移动到目标C柱上，但一次只能移动一个，并且如果柱子上已经有盘子了，需要放的盘子不能比已有的大
 *
 */
public class Hanoi {

    public static void move(int dish, String from, String temp, String to) {
        if (dish == 1) {
            System.out.println("将盘子 " + dish + " 从塔 " + from + " 移动到目标塔 " + to);
            return;
        }

        move(dish - 1, from, to, temp);
        System.out.println("将盘子 " + dish + " 从塔 " + from + " 移动到目标塔 " + to);
        move(dish - 1, temp, from, to);
    }


    public static void main(String[] args) {
        move(20, "A", "B", "C");
    }

}
