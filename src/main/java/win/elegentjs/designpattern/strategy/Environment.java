package win.elegentjs.designpattern.strategy;

public class Environment {

    public static int calc(int i, int j, CalcStrategy strategy) {
        return strategy.calc(i, j);
    }

}
