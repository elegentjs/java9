package win.elegentjs.newdate;

import java.time.LocalTime;

public class LocalTimeSample {

    public static void main(String[] args) {
        LocalTime time = LocalTime.of(15, 1, 1);
        time = LocalTime.of(15, 1);

        // hour
        int hour = time.getHour();
        int min = time.getMinute();
        int second = time.getSecond();

        System.out.println("hour : " + hour);
        System.out.println("min : " + min);
        System.out.println("second : " + second);
    }
}
