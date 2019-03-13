package win.elegentjs.enumration;

public enum ColorEnum {
    RED("RED", 1),
    BLACK("BLACK", 2),
    WHITE("WHITE", 3),
    PINK("PINK", 4),
    BLUE("BLUE", 5);

    private String name;
    private int value;

     ColorEnum(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
