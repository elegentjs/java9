package win.elegentjs.newdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeSimple {

    public static void main(String[] args) {
        LocalDateTime dt1 = LocalDateTime.of(2020, 1, 8, 10, 10, 0);

        dt1 = LocalDateTime.now();
        dt1 = LocalDateTime.of(LocalDate.now(), LocalTime.now());

        dt1 = LocalDate.now().atTime(10, 10);
        dt1 = LocalTime.now().atDate(LocalDate.now());

        LocalDate date = dt1.toLocalDate();
        LocalTime time = dt1.toLocalTime();

    }
}
