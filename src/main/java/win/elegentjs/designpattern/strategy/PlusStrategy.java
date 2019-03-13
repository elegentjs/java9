package win.elegentjs.designpattern.strategy;

public class PlusStrategy implements CalcStrategy {

    @Override
    public int calc(int a, int b) {
        return a + b;
    }
}
