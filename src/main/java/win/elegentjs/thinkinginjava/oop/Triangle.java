package win.elegentjs.thinkinginjava.oop;

/**
 * 三角形
 *
 * 此处可以理解为：三角形是一个图形
 */
public class Triangle extends Shape {


    @Override
    public void draw() {
        System.out.println("Triangle draw.");
    }

    @Override
    public void erase() {
        System.out.println("Triangle erase.");
    }
}
