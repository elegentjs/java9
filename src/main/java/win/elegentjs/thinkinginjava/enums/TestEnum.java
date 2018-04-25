package win.elegentjs.thinkinginjava.enums;

public class TestEnum {

    public static void main(String[] args) {
        Spiciness[] array = Spiciness.values();

        for (Spiciness item : array) {
            System.out.println(item.name() + ", " + item.ordinal());
        }

        Spiciness item = Spiciness.valueOf("NOT");

        System.out.println(Spiciness.NOT == item);
    }
}
