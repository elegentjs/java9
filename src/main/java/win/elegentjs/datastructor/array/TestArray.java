package win.elegentjs.datastructor.array;

public class TestArray {

    public static void main(String[] args) {
        Array array = new Array(100);

        array.add(10);
        array.add(100);
        array.add(1010);
        array.add(1010);
        array.add(1100);
        array.add(1001);

        array.display();

        int target = array.get(1);
        System.out.println("array[" + 1 + "] = " + target);
        System.out.println();

        array.del(100);

        array.modify(10, 10000);

        array.display();


    }
}
