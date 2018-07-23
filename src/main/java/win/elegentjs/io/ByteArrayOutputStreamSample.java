package win.elegentjs.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ByteArrayOutputStreamSample {

    public static void main(String[] args) throws IOException {
        OutputStream outputStream = new ByteArrayOutputStream();

        outputStream.write("This text is converted to bytes".getBytes());


        byte[] bytes = ((ByteArrayOutputStream) outputStream).toByteArray();


        System.out.println(bytes);

    }
}
