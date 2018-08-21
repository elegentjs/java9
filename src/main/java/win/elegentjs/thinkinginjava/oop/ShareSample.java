package win.elegentjs.thinkinginjava.oop;

public class ShareSample {

    public static void main(String[] args) {
        RandomShapeGenerator generator = new RandomShapeGenerator();

        Shape[] shapes = new Shape[10];

        for (int index = 0; index < shapes.length; index ++) {
            shapes[index] = generator.next();
        }


        for (Shape item : shapes) {
            item.draw();
        }

        System.out.println("=============================");

        for (Shape item : shapes) {
            item.erase();
        }
    }
}
