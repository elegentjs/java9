package win.elegentjs.net.url;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MyUrl {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.xici.net/");

        URLConnection conn = url.openConnection();

        File file = new File("/Users/liupeijun/Downloads/index.html");
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdir();
            }

            file.createNewFile();
        }
        try (
                BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
                FileOutputStream fos = new FileOutputStream(file)
        ) {
            byte[] b = new byte[1024];
            int len;


            while ((len = bis.read(b)) != -1) {
                fos.write(b, 0, len);
            }

            fos.flush();
        }


    }
}
