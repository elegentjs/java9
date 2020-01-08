package win.elegentjs.newdate;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;

/**
 * 计算秒区间
 */
public class DurationSample {

    public static void main(String[] args) {

        Duration duration = Duration.between(LocalTime.of(10, 11), LocalTime.of(10, 12));
        System.out.println(duration.getSeconds());

        duration = Duration.between(Instant.ofEpochSecond(1000), Instant.ofEpochSecond(10000));
        System.out.println(duration.getSeconds());

        Duration threeMins = Duration.ofMinutes(3);

    }
}
