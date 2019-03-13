package win.elegentjs.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericSample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");

        List<?> list2 = list;

        String s = (String) list2.get(0);

        System.out.println(s);

        List<String> list3 = (List<String>) list2;

        list3.add("B");

        System.out.println(list3);

    }
}
