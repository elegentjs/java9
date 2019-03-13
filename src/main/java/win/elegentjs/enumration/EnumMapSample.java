package win.elegentjs.enumration;

import java.util.EnumMap;

public class EnumMapSample {

    public static void main(String[] args) {
        EnumMap<ColorEnum, Object> enumMap = new EnumMap<>(ColorEnum.class);
        enumMap.put(ColorEnum.BLUE, "蓝色");
        enumMap.put(ColorEnum.PINK, "粉色");
        enumMap.put(ColorEnum.RED, "红色");

        System.out.println(enumMap);
    }
}
