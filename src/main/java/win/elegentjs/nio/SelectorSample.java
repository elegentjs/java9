package win.elegentjs.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.*;

public class SelectorSample {

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();


        SocketChannel channel = null;
        channel.configureBlocking(false);

        SelectionKey key = channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);


        int interestSet = key.interestOps();

        boolean isInterestedInAccept  = (interestSet & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT;
        boolean isInterestedInConnect = (interestSet & SelectionKey.OP_CONNECT) == SelectionKey.OP_CONNECT;
        boolean isInterestedInRead    = (interestSet & SelectionKey.OP_READ) == SelectionKey.OP_READ;
        boolean isInterestedInWrite   = (interestSet & SelectionKey.OP_WRITE) == SelectionKey.OP_WRITE;




    }
}
