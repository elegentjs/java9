package win.elegentjs.enumration;

import java.util.EnumSet;

public class EnumSetSample {

    public static void main(String[] args) {
        EnumSet<ColorEnum> colorEnums = EnumSet.of(ColorEnum.BLUE, ColorEnum.WHITE, ColorEnum.BLACK, ColorEnum.BLUE);

        for (ColorEnum item : colorEnums) {
            System.out.println(item);
        }
    }
}


