package win.elegentjs.io;

import java.io.*;

public class FileInputStreamSample {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("/Users/liupeijun/git/00_bash/redeploy.sh");


        InputStreamReader isr = new InputStreamReader(fis);

        BufferedReader br = new BufferedReader(isr);

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }

}
