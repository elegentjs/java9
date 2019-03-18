package win.elegentjs.io;

import java.io.*;

/**
 * 借助ObjectOutputStream和ObjectInputStream演示了对象的序列化和反序列化
 */
public class ObjOutputStreamSample {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/Users/liupeijun/Downloads/1.txt"));
        oos.writeObject(new Person("1", "liu", 23));
        oos.writeObject(new Person("2", "li", 25));
        oos.writeObject(new Person("3", "zhang", 26));

        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/liupeijun/Downloads/1.txt"));
        Person p = (Person) ois.readObject();
        System.out.println(p);
        p = (Person) ois.readObject();
        System.out.println(p);
        p = (Person) ois.readObject();
        System.out.println(p);

        ois.close();
    }


    public static class Person implements Serializable  {
        private String id;
        private String name;
        private Integer age;

        public Person(String id, String name, Integer age) {
            this.id = id;
            this.name = name;
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

}
