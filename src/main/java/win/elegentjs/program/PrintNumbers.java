package win.elegentjs.program;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PrintNumbers {

    public static void main(String[] args) {
        System.out.println("请输入一串数字，最大8位：");

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        if (s.length() > 8) {
            System.out.println("最大只可以输入8个字符！");
            return;
        }

        int intNum;

        try {
            intNum = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("您输入的字符串中包含非数字字符，请重新输入！");
            return;
        }



    }




}
