/**
 * Copyright (C) 2017 南京思创信息技术有限公司
 * <p>
 * 版权所有。
 * <p>
 * 功能概要    :
 * 做成日期    : 2017/12/5
 */
package win.elegentjs.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Liupj
 * @date 2017/12/5.
 */
public class ProcessorFile {

    public static String processFile() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("E:/data.txt"))) {
            return br.readLine();
        }
    }

    public static String processFile2(BufferReaderProcessor processor) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("E:/data.txt"))) {
            return processor.process(br);
        }
    }

    public static void main(String[] args) throws IOException {
        String result = processFile();

        System.out.println(result);

        result = processFile2(br -> br.readLine());

        System.out.println(result);

        result = processFile2(br -> br.readLine() + br.readLine() + br.readLine());

        System.out.println(result);


    }



}

/**
 * 函数式接口
 */
@FunctionalInterface
interface BufferReaderProcessor {
    String process(BufferedReader br) throws IOException;
}
