/**
 * Copyright (C) 2017 南京思创信息技术有限公司
 * <p>
 * 版权所有。
 * <p>
 * 功能概要    :
 * 做成日期    : 2017/12/5
 */
package win.elegentjs.lambda;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Liupj
 * @date 2017/12/5.
 */
public class Apple {

    private Integer weight;

    private String color;

    public Apple(Integer weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();

        apples.add(new Apple(10, "red"));
        apples.add(new Apple(9, "red"));
        apples.add(new Apple(8, "red"));
        apples.add(new Apple(7, "red"));
        apples.add(new Apple(6, "red"));
        apples.add(new Apple(5, "red"));
        apples.add(new Apple(4, "red"));
        apples.add(new Apple(3, "green"));
        apples.add(new Apple(2, "red"));
        apples.add(new Apple(1, "red"));

        Collections.sort(apples, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.weight.compareTo(o2.weight);
            }
        });


        System.out.println(apples);


        Comparator<Apple> comparator = Comparator.comparing(o -> o.weight);

        // 正序
        apples.sort(comparator);

        //逆序
        apples.sort(comparator.reversed());

        //比较器链
        apples.sort(comparator.reversed().thenComparing(apple -> apple.color));

        // 简写
        apples.sort(Comparator.comparing((Apple e) -> e.weight).reversed().thenComparing(e -> e.weight));

        System.out.println(apples);

        //谓词复合
        Predicate<Apple> predicate = e -> e.color.equals("red");

        // negate 表示 ！
        predicate = predicate.negate().and(e -> e.color.equals("green")).or(e -> e.color.equals("black"));

        // 执行过滤
        apples = apples.stream().filter(predicate).collect(Collectors.toList());

        System.out.println(apples);

        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;

        //and Then 等价于： g(f(x))
        Function<Integer, Integer> andThen = f.andThen(g);
        //compose 等价于：f(g(x))
        Function<Integer, Integer> compose = f.compose(g);

        apples.forEach(System.out::println);

        Optional<Apple> apple = apples.stream().filter(e -> e.weight > 0).findAny();

        if (apple.isPresent()) {
            //
        }

        apple.ifPresent(System.out::println);

    }


    @Override
    public String toString() {
        return "Apple{" +
                "weight ='" + weight + '\'' +
                "color ='" + color + '\'' +
                '}';
    }
}


