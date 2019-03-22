package win.elegentjs.net.socket;

public class ClientMain2 {

    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient(5000);
        chatClient.start();
    }
}
