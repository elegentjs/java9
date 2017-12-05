/**
 * Copyright (C) 2017 南京思创信息技术有限公司
 * <p>
 * 版权所有。
 * <p>
 * 功能概要    :
 * 做成日期    : 2017/12/5
 */
package win.elegentjs.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Liupj
 * @date 2017/12/5.
 */
public class ComparatorTest {

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple("green"), new Apple("red"), new Apple("green"));

        Comparator<Apple> byColor = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        };
        apples.sort(byColor);
        System.out.println(apples);


        byColor = (Apple o1, Apple o2) -> o1.getColor().compareTo(o2.getColor());
        apples.sort(byColor);
        System.out.println(apples);


        byColor = (o1, o2) -> o1.getColor().compareTo(o2.getColor());
        apples.sort(byColor);
        System.out.println(apples);


        byColor = Comparator.comparing(apple -> apple.getColor());
        apples.sort(byColor);
        System.out.println(apples);


        byColor = Comparator.comparing(Apple::getColor);
        apples.sort(byColor);
        System.out.println(apples);

        //逆序
        apples.sort(byColor.reversed());

        //比较器链
        apples.sort(byColor.reversed().thenComparing(apple -> apple.getColor()));

        //谓词复合
        Predicate<Apple> predicate = apple -> apple.getColor().equals("red");
        predicate = predicate.negate().and(apple -> apple.getColor().equals("green")).or(apple -> apple.getColor().equals("black"));

        Apple.filterApples(apples, predicate);

        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;

        //and Then 等价于： g(f(x))
        Function<Integer, Integer> andThen = f.andThen(g);
        //compose 等价于：f(g(x))
        Function<Integer, Integer> compose = f.compose(g);


    }
}
