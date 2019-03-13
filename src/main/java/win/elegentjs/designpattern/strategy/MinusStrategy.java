package win.elegentjs.designpattern.strategy;

public class MinusStrategy implements CalcStrategy {

    @Override
    public int calc(int a, int b) {
        return a - b;
    }
}
