package win.elegentjs.thinkinginjava.oop;

/**
 * 圆形
 *
 *  本继承体系中可以表现为圆形是一个形状
 *
 */
public class Circle extends Shape {

    @Override
    public void draw() {
        System.out.println("Circle draw");
    }

    @Override
    public void erase() {
        System.out.println("Circle erase");
    }
}
