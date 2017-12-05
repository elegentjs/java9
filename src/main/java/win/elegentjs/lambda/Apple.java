/**
 * Copyright (C) 2017 南京思创信息技术有限公司
 * <p>
 * 版权所有。
 * <p>
 * 功能概要    :
 * 做成日期    : 2017/12/5
 */
package win.elegentjs.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Liupj
 * @date 2017/12/5.
 */
public class Apple {

    private String color;

    public Apple(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }


    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();

        inventory.add(new Apple("green"));
        inventory.add(new Apple("green"));
        inventory.add(new Apple("green"));
        inventory.add(new Apple("green"));
        inventory.add(new Apple("red"));
        inventory.add(new Apple("red"));
        inventory.add(new Apple("red"));

        List<Apple> greenApples = filterApples(inventory, Apple::isGreenApple);
        List<Apple> redApples = filterApples(inventory, Apple::isRedApple);


        System.out.println(greenApples);
        System.out.println(redApples);


        greenApples = filterApples(inventory, (Apple apple) -> "green".equals(apple.getColor()));
        redApples = filterApples(inventory, (Apple apple) -> "red".equals(apple.getColor()));

        System.out.println(greenApples);
        System.out.println(redApples);


        long start = System.currentTimeMillis();

        greenApples = inventory.stream().filter((Apple apple) -> "green".equals(apple.getColor())).collect(Collectors.toList());

        long end = System.currentTimeMillis();

        System.out.println("cost1 : " + (end - start) + " mills.");
        System.out.println(greenApples);

        start = System.currentTimeMillis();
        greenApples = inventory.parallelStream().filter((Apple apple) -> "green".equals(apple.getColor())).collect(Collectors.toList());
        end = System.currentTimeMillis();
        System.out.println("cost2 : " + (end - start) + " mills.");

        System.out.println(greenApples);

    }



    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isRedApple(Apple apple) {
        return "red".equals(apple.getColor());
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();

        for (Apple item : inventory) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }

        return result;
    }


    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                '}';
    }
}


