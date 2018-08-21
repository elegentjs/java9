package win.elegentjs.thinkinginjava.oop;

import java.util.Random;

/**
 * 图形随机生成器
 */
public class RandomShapeGenerator {

    private Random random = new Random();

    public  Shape next() {
        switch (random.nextInt(3)) {
            case 0:
                return new Circle();
            case 1:
                return new Square();

            case 2:
                return new Triangle();

            default:
                throw new IllegalStateException("wrong random number.");
        }
    }
}
