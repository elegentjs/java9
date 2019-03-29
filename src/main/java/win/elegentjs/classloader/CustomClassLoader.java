package win.elegentjs.classloader;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 自定义ClassLoader
 *
 * Thread.currentThread().getContextClassLoader() 返回的是启用当前线程的ClassLoader
 *
 */
public class CustomClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("/Users/liupeijun/Downloads/MyClass.class"))) {
            byte[] bytes = new byte[1024];
            int len;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }

            byte[] total = bos.toByteArray();

            return defineClass(name, total, 0, total.length);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new ClassNotFoundException("不能加载目标类");

    }
}

class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ClassLoader myClassLoader = new CustomClassLoader();
        Class<?> clazz = myClassLoader.loadClass("win.elegentjs.classloader.MyClass");

        System.out.println("classLoader2 : " + clazz.getClassLoader());

        Constructor<?> constructor = clazz.getConstructor(String.class, String.class);
        constructor.setAccessible(true);
        Object o = constructor.newInstance("1", "刘");

        Method method = clazz.getMethod("execute");
        method.setAccessible(true);
        method.invoke(o);

    }
}

/**
class MyClass {

    private String id;

    private String name;

    public MyClass(String id, String name) {
        this.id = id;
        this.name = name;
    }


    public void execute() {
        new Thread(() -> {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            System.out.println("execute thread : " + classLoader);

        }).start();
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
**/



