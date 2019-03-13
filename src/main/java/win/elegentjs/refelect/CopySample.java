package win.elegentjs.refelect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class CopySample {



    public static <T> T copy(T t) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = t.getClass();

        T result = (T)clazz.newInstance();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }

            if (!Modifier.isFinal(field.getModifiers())) {
                field.set(result, field.get(t));
            }
        }

        return result;
    }


    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Person p = new Person();
        p.setId("1");
        p.setName("liu");
        p.setAge(50);

        Object result = CopySample.copy(p);

        System.out.println("origin : " + p.hashCode());
        System.out.println("target : " + result.hashCode());

        System.out.println(result);
    }
}

class Person {
    private String id;
    private String name;
    private int age;

    public Person() {
    }

    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


