package win.elegentjs.netty.msgpack;



import org.msgpack.MessagePack;
import org.msgpack.template.Templates;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 简单使用MessagePack框架进行序列化/反序列化的示例程序
 */
public class MessagePackSample {

    public static void main(String[] args) throws IOException {
        List<String> src = new ArrayList<>();
        src.add("msgpack");
        src.add("kumofs");
        src.add("viver");

        MessagePack msgpack = new MessagePack();

        // serialize
        byte[] raw = msgpack.write(src);

        // unserialize
        List<String> dst = msgpack.read(raw, Templates.tList(Templates.TString));

        System.out.println(dst.get(0));
        System.out.println(dst.get(1));
        System.out.println(dst.get(2));

    }
}
