/**
 * Copyright (C) 2017 南京思创信息技术有限公司
 * <p>
 * 版权所有。
 * <p>
 * 功能概要    :
 * 做成日期    : 2017/11/21
 */
package win.elegentjs.round;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * java 中支持7中舍入法：
 *
 *  1. ROUND_UP: 远离零方向舍入（只要舍弃位非零就进位）
 *  2. ROUND_DOWN: 趋向零方向舍入（直接舍弃）
 *  3. ROUND_CEILING: 向正无穷方向舍入（保证绝对值最大化）
 *  4. ROUND_FLOOR: 向负无穷方向舍入（保证绝对值最小化）
 *  5. HALF_UP: 四舍五入（最经典的舍入法）
 *  6. HALF_DOWN: 五舍
 *  7. HALF_EVEN: 银行家舍入法
 *      1）舍去位的数值小于5时，直接舍去
 *      2) 舍去位大于5时，进位后舍去
 *      3) 当舍去位等于5时，若5后面还有其他非0数值，则进位后舍去；若5后面是0时，则根据5前一位的奇偶性来判断，奇数进位，偶数舍去。
 *
 *
 * @author Liupj
 * @date 2017/11/21.
 */
public class RoundTest {
    public static void main(String[] args) {
        //ROUND_UP
        BigDecimal bigDecimal = new BigDecimal(65.540);
        BigDecimal result = bigDecimal.setScale(2, RoundingMode.UP);

        System.out.println(result);


    }
}
