package win.elegentjs.basic;

/**
 *
 * java类是单根继承体系结构，所有的类都会继承自Object类，Object类中有不少有用的共用方法
 *
 *  1) getClass -> 获取本对象的Class对象
 *  2）hashCode -> 获取本对象的hash值
 *  3）equals -> 默认比较两个对象的引用地址是否相等
 *  4）clone -> 执行对象克隆，只能浅复制
 *  5）toString -> 打印本对象，默认是 Class全路径名 + "@" + hashCode的十六进制字符串
 *  6）notify / notifyAll
 *  7) wait/ wait(long), wait(long, int)
 *  8) finalize
 *
 */
public class ObjectSample {

    public static void main(String[] args) {
        ObjectSample o = new ObjectSample();
        System.out.println(o.getClass().getName());

        System.out.println(Integer.toHexString(o.hashCode()));
        System.out.println(o);

    }
}
