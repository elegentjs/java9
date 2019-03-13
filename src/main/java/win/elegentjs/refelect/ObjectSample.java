package win.elegentjs.refelect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ObjectSample {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<Object> objectClass = Object.class;

        int classModifiers = objectClass.getModifiers();

        // 是public
        if (Modifier.isPublic(classModifiers)) {
            System.out.println("Object 类型是public修饰");
        }

        // 获取方法定义
        Method[] methods = objectClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            System.out.println();
        }

        // 动态调用方法
        Method toString = objectClass.getMethod("toString");

        String result = (String)toString.invoke(objectClass.newInstance());
        System.out.println(result);


    }
}
