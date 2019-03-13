package win.elegentjs.enumration;

public enum ColorEnum {
    RED(1),
    BLACK( 2),
    WHITE(3),
    PINK( 4),
    BLUE( 5);

    private int value;

     ColorEnum(int value) {
        this.value = value;
    }

    public static ColorEnum getType(int value) {
         ColorEnum result = null;
         for (ColorEnum item : ColorEnum.values()) {
             if (item.value == value) {
                 result = item;
                 break;
             }
         }

         return result;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        ColorEnum red = ColorEnum.RED;

        System.out.println(red);
        System.out.println(red.name());
        System.out.println("ordinal: " + red.ordinal());
        System.out.println("getValue: " + red.getValue());
        System.out.println("getType: " + ColorEnum.getType(red.getValue()));

        System.out.println("=====================");

        for (ColorEnum item : ColorEnum.values()) {
            print(item);
        }

    }

    public static void print(ColorEnum colorEnum) {
        switch (colorEnum) {
            case RED:
                System.out.println("红色");
                break;
            case BLUE:
                System.out.println("蓝色");
                break;
            case PINK:
                System.out.println("粉色");
                break;
            case BLACK:
                System.out.println("黑色");
                break;
            case WHITE:
                System.out.println("白色");
                break;
            default:
                throw new IllegalStateException("wrong enum type");
        }
    }

}
