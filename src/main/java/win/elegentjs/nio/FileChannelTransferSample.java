package win.elegentjs.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class FileChannelTransferSample {

    public static void main(String[] args) throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile("/Users/liupeijun/git/00_bash/redeploy.sh", "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("/Users/liupeijun/git/00_bash/2.sh", "rw");
        FileChannel toChannel = toFile.getChannel();

        long count = fromChannel.size();

        toChannel.transferFrom(fromChannel, 0, count);


        fromChannel.transferTo(0, count, toChannel);

    }
}
