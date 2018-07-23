package win.elegentjs.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayInputStreamSample {
    public static void main(String[] args) throws IOException {

        byte[] bytes = new byte[] {1, 12, 3, 4, 127, 123};


        InputStream inputStream = new ByteArrayInputStream(bytes);

        int data;

        while ((data = inputStream.read()) != -1) {
            System.out.println(data);
        }
    }
}
