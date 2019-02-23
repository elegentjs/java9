package win.elegentjs.basic;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

/**
 * 演示System类功能
 *
 * System类java标准库中的一个特殊类，本身不可以实例化，提供了一系列的静态方法供用户使用，主要如下几类：
 *
 *  1）stin, stout, sterr
 *  2) properties, env
 *      比较重要的系统属性有：path.separator -> 环境变量分割符：windows: ;  unix: :
 *                         user.dir -> 当前程序运行目录
 *                         line.separator -> 系统换行符： windows: /r/n  unix: /n
 *                         file.separator -> 文件目录分割符： windows: \  unix: /
 *                         os.name   -> 操作系统名称
 *                         java.version -> jdk版本
 *                         user.home -> 用户家目录
 *                         file.encoding -> 当前编码类型，通常是UTF-8
*
 *       比较重要的环境变量有：
 *                          PATH
 *
 *  3) arraycopy  数组复制时推荐使用，底层用c复制，高效
 *  4) currentTimeMillis  获取当前时间，用毫秒表示，计算性能时常用
 *  5) gc, finalization 主动调用垃圾收集器，不常用
 *  6) load files and libraries 装载库文件，如windows下动态链接库（dll），不常用
 *
 */
public class SystemSample {

    public static void main(String[] args) {
        //stin, stout, sterr
        testSt();

        // properties
        testProperties();

        // env
        testEnv();

        // arraycopy
        testArraycopy();

        // currentTimeMillis
        testCurrentTimeMillis();

        // gc
        testGc();
    }

    private static void testCurrentTimeMillis() {
        System.out.println(System.currentTimeMillis());
    }

    private static void testProperties() {
        Properties properties = System.getProperties();

        for(String key : properties.stringPropertyNames()) {
            System.out.println(key + " : " + properties.getProperty(key));
        }
    }

    private static void testEnv() {
       Map<String, String> envMap = System.getenv();

       for (String key : envMap.keySet()) {
           System.out.println(key + " : " + envMap.get(key));
       }
    }

    private static void testSt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串，以enter键结束：");
        String s = scanner.nextLine();
        System.out.println("s = " + s);
        System.err.println("error : s = " + s);
    }

    private static void testArraycopy() {
        int[] source = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int[] target = new int[source.length];

        System.arraycopy(source, 0, target, 0, source.length);

        System.out.println(Arrays.toString(target));
    }

    private static void testGc() {
        System.gc();
    }
}
