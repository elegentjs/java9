package win.elegentjs.datastructor.recursive;

import java.io.File;

/**
 * 使用递归方法遍历打印文件目录和文件
 */
public class FileUtil {

    public static void display(String path, int deep) {
        File filePath = new File(path);

        File[] files = filePath.listFiles();

        for(File file : files) {
            if (file.isFile() && !file.isHidden()) {
                System.out.println(line(deep) + file.getName());
            } else if (file.isDirectory()) {
                System.out.println(line(deep) + "dir: " + file.getName());
                display(file.getPath(), deep + 1);
            }
         }

    }


    private static String line(int deep) {
        StringBuilder stringBuilder = new StringBuilder("");

        while (deep > 0) {
            stringBuilder.append("  ");
            deep --;
        }

        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        display("/Users/liupeijun/Documents/40_Video", 0);
    }

}
