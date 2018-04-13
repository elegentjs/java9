package win.elegentjs.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        Subject subject = new SubjectImpl();
        InvocationHandler invocationHandler = new CustomInvocationHandler(subject);

        Subject proxy = (Subject) Proxy.newProxyInstance(Main.class.getClassLoader(), subject.getClass().getInterfaces(), invocationHandler);

        System.out.println(proxy);



    }
}
