package win.elegentjs.netty.first.server;

public class Main {

    public static void main(String[] args) throws Exception {
        new EchoServer(9999).start();
    }
}
