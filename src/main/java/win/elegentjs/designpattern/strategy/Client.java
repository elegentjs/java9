package win.elegentjs.designpattern.strategy;

import static win.elegentjs.util.PrintUtil.print;

public class Client {

    public static void main(String[] args) {
        int result = Environment.calc(10, 1, new PlusStrategy());
        print(result);

        result = Environment.calc(10, 1, new MinusStrategy());
        print(result);
    }
}
