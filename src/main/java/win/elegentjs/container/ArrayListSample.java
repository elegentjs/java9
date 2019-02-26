package win.elegentjs.container;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList是集合家族最常见的类
 *
 * 是List接口的实现类
 * 特性：
 *      有序可重复
 *      可随机存取元素
 *      底层基于数组，所以擅长随机访问，不擅长添加，删除
 *
 */
public class ArrayListSample {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(10);
    }
}
