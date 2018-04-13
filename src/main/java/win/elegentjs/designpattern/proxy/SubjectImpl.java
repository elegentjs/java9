package win.elegentjs.designpattern.proxy;

public class SubjectImpl implements Subject {

    @Override
    public void sayHello(String name) {
        System.out.println("hello : " + name);
    }
}
