package win.elegentjs.designpattern.singleton;

/**
 * 设计模式：
 *
 *  Singleton
 *
 *  两种方式： 直接定义为静态成员变量
 *            懒汉式
 *
 */
public class SingletonTest {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();

        Singleton singleton1 = Singleton.getInstance();

        System.out.println(singleton == singleton1);


        Singleton2 singleton2 = Singleton2.getInstance();
        Singleton2 singleton21 = Singleton2.getInstance();

        System.out.println(singleton2 == singleton21);

    }
}



class Singleton {

    private static final Singleton singleton = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return singleton;
    }
}


class Singleton2 {

    private static Singleton2 singleton2;

    private Singleton2() {

    }

    public static Singleton2 getInstance() {
        if (singleton2 == null) {
            synchronized (Singleton2.class) {
                if (singleton2 == null) {
                    singleton2 = new Singleton2();
                }
            }

        }

        return singleton2;
    }


}



