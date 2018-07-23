package win.elegentjs.nio;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ScatteringReadSample {

    public static void main(String[] args) throws IOException {
        ByteBuffer header = ByteBuffer.allocate(128);

        ByteBuffer body = ByteBuffer.allocate(1024);

        ByteBuffer[] byteBuffers = {header, body};

        FileChannel fileChannel = new RandomAccessFile("", "wr").getChannel();

        fileChannel.read(byteBuffers);

    }
}
