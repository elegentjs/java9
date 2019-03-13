package win.elegentjs.refelect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ObjectSample {

    public static void main(String[] args) {
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


    }
}
