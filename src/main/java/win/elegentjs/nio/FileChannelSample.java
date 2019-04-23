package win.elegentjs.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用NIO读取文件并打印出来
 */
public class FileChannelSample {

    public static void main(String[] args) {
        try (
                RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/liupeijun/Downloads/settings.xml", "rw");
                FileChannel fileChannel = randomAccessFile.getChannel();
        ) {

            ByteBuffer byteBuffer = ByteBuffer.allocate(48);

            int count = 0;

            while ((count = fileChannel.read(byteBuffer)) != -1) {
                System.out.println("read: " + count);

                byteBuffer.flip();

                while (byteBuffer.hasRemaining()) {
                    System.out.print((char) byteBuffer.get());
                }

                byteBuffer.clear();
            }


        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }

    }

}
