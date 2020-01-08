package win.elegentjs.newdate;

import java.time.LocalDate;
import java.time.Period;

/**
 * 以年月日计算区间
 */
public class PeriodSample {

    public static void main(String[] args) {
        Period tenDays = Period.between(LocalDate.of(2019, 10, 1), LocalDate.of(2019,10, 11));

        System.out.println(tenDays.getDays());

        tenDays = Period.ofDays(3);

        // 两年6个月1天
        Period twoYear6Month1Day = Period.of(2, 6, 1);

    }
}
