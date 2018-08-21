/**
 * Copyright (C) 2017 南京思创信息技术有限公司
 * <p>
 * 版权所有。
 * <p>
 * 功能概要    :
 * 做成日期    : 2017/12/5
 */
package win.elegentjs.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Liupj
 * @date 2017/12/5.
 */
public class StreamSample1 {
    public static void main(String[] args) {
        //实现选中低热量(<= 500)的食物，并按照热量高低进行排序，最后打印食物的名称

        //初始化食物列表
        List<Dish> dishes = new ArrayList<>(Arrays.asList(
                new Dish(100, "青菜"),
                new Dish(450, "鸡肉"),
                new Dish(400, "鱼"),
                new Dish(200, "鸡蛋"),
                new Dish(500, "猪肉"),
                new Dish(700, "牛肉"),
                new Dish(900, "熊猫肉"),
                new Dish(100, "青菜"),
                new Dish(450, "鸡肉"),
                new Dish(400, "鱼"),
                new Dish(200, "鸡蛋"),
                new Dish(500, "猪肉"),
                new Dish(700, "牛肉"),
                new Dish(900, "熊猫肉"),
                new Dish(100, "青菜"),
                new Dish(450, "鸡肉"),
                new Dish(400, "鱼"),
                new Dish(200, "鸡蛋"),
                new Dish(500, "猪肉"),
                new Dish(700, "牛肉"),
                new Dish(900, "熊猫肉"),
                new Dish(100, "青菜"),
                new Dish(450, "鸡肉"),
                new Dish(400, "鱼"),
                new Dish(200, "鸡蛋"),
                new Dish(500, "猪肉"),
                new Dish(700, "牛肉"),
                new Dish(900, "熊猫肉"),
                new Dish(100, "青菜"),
                new Dish(450, "鸡肉"),
                new Dish(400, "鱼"),
                new Dish(200, "鸡蛋"),
                new Dish(500, "猪肉"),
                new Dish(700, "牛肉"),
                new Dish(900, "熊猫肉"),
                new Dish(100, "青菜"),
                new Dish(450, "鸡肉"),
                new Dish(400, "鱼"),
                new Dish(200, "鸡蛋"),
                new Dish(500, "猪肉"),
                new Dish(700, "牛肉"),
                new Dish(900, "熊猫肉"),
                new Dish(100, "青菜"),
                new Dish(450, "鸡肉"),
                new Dish(400, "鱼"),
                new Dish(200, "鸡蛋"),
                new Dish(500, "猪肉"),
                new Dish(700, "牛肉"),
                new Dish(900, "熊猫肉"),
                new Dish(800, "兔子肉"),
                new Dish(800, "羊肉")));


        //传统实现
        long start = System.currentTimeMillis();
        for (int index = 0; index < dishes.size(); index ++) {
            if (dishes.get(index).getCalories() > 500) {
                dishes.remove(index);
                index --;
            }
        }

        //排序
        dishes.sort(Comparator.comparing(Dish::getCalories));

        //选出菜名
        List<String> dishNames = new ArrayList<>(dishes.size());
        for (Dish dish : dishes) {
            dishNames.add(dish.getName());
        }

        long end = System.currentTimeMillis();

        System.out.println("cost : " + (end  -start) + " mills.");
        System.out.println(dishNames);

        // 采用Stream API
        start = System.currentTimeMillis();
        dishNames = dishes.parallelStream().filter(dish -> dish.getCalories() <= 500)
                       .sorted(Comparator.comparing(Dish::getCalories))
                       .map(Dish::getName)
                       .collect(Collectors.toList());
        end = System.currentTimeMillis();

        System.out.println("cost : " + (end - start) + " mills.");
        System.out.println(dishNames);

    }
}


class Dish {

    private int calories;

    private String name;

    public Dish(int calories, String name) {
        this.calories = calories;
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Dish{" +
                "calories=" + calories +
                ", name='" + name + '\'' +
                '}';
    }
}
