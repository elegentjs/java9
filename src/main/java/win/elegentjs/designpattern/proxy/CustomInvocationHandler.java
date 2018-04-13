package win.elegentjs.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {

    private Object subject;

    public CustomInvocationHandler(Object subject) {
        this.subject = subject;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(" before invoke method. ");
        System.out.println("method : " + method);

        Object result = method.invoke(subject, args);

        System.out.println("after invoke method. ");

        return result;
    }
}
