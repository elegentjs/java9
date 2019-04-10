package win.elegentjs.designpattern.proxy;

public class SubjectProxy implements Subject {

    private Subject subject;


    public SubjectProxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void sayHello(String name) {
        System.out.println("before");
        subject.sayHello(name);
        System.out.println("after");
    }
}
