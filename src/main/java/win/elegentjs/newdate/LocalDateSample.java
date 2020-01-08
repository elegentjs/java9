package win.elegentjs.newdate;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class LocalDateSample {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2019, 1, 8);

        // year
        int year = date.getYear();

        // month
        int month = date.getMonthValue();

        // dayOfMonth 几号
        int dayOfMonth = date.getDayOfMonth();

        // dayOfWeek 星期几
        int dayOfWeek = date.getDayOfWeek().getValue();

        // 是不是闰年
        boolean isLeapYear = date.isLeapYear();

        System.out.println("year : " + year);
        System.out.println("month : " + month);
        System.out.println("dayOfMonth : " + dayOfMonth);
        System.out.println("dayOfWeek : " + dayOfWeek);
        System.out.println("isLeapYear : " + isLeapYear);

        year = date.get(ChronoField.YEAR);


        date = LocalDate.parse("2019/11/11", DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        System.out.println(date);

    }
}
