package win.elegentjs.io;

import java.io.*;

public class BufferedInputStreamSample {

    public static void main(String[] args) throws IOException {
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("/Users/liupeijun/Downloads/南京智慧房安-项目环境配置说明.xls"));
        OutputStream bos = new BufferedOutputStream(new FileOutputStream("/Users/liupeijun/Downloads/2.xls"));
        byte[] b = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(b))  != -1) {
            bos.write(b, 0, len);
        }

        bos.flush();
        bos.close();
        inputStream.close();
    }
}
