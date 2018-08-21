package win.elegentjs.thinkinginjava.oop;

/**
 * 正方形
 *
 *  在此处可以理解为：正方形是一个形状
 *
 */
public class Square extends Shape {

    @Override
    public void draw() {
        System.out.println("Square draw");
    }

    @Override
    public void erase() {
        System.out.println("Square erase");
    }
}
