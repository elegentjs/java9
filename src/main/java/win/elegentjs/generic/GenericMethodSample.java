package win.elegentjs.generic;

public class GenericMethodSample {


    public static <T> void print(T t) {
        System.out.println(t);
    }


    public static void main(String[] args) {
        print("A");
    }
}
