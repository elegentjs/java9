package win.elegentjs.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GatherWriteSample {

    public static void main(String[] args) throws IOException {
        ByteBuffer header = ByteBuffer.allocate(48);
        ByteBuffer body = ByteBuffer.allocate(1024);

        ByteBuffer[] byteBuffers = {header, body};

        RandomAccessFile randomAccessFile = new RandomAccessFile("", "rw");

        FileChannel fileChannel = randomAccessFile.getChannel();

        fileChannel.write(byteBuffers);
    }
}
