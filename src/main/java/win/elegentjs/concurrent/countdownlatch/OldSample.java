package win.elegentjs.concurrent.countdownlatch;

public class OldSample {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        new Thread(() -> {
            calculator.calcSingle("3,1,2,3,4,5", 0);
        }).start();

        new Thread(() -> {
            calculator.calcSingle("3,1,2,3,4,5", 1);

        }).start();

        new Thread(() -> {
            calculator.calcSingle("3,1,2,3,4,5", 2);
        }).start();


        while (Thread.activeCount() > 2) {}

        System.out.println("total : " + calculator.calcTotal());

    }
}



class Calculator {
    private int[] result = new int[3];

    public void calcSingle(String line, int index) {
        String[] lineArray = line.split(",");

        int tmp = 0;
        for (int i = 0; i < lineArray.length; i ++) {
            tmp += Integer.parseInt(lineArray[i]);
        }

        result[index] = tmp;
    }


    public Integer calcTotal() {
        int temp = 0;
        for (int item : result) {
            temp += item;
        }

        return temp;
    }

}
