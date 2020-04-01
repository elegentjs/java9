package win.elegentjs.netty.msgpack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.msgpack.MessagePack;

/**
 * Messagepack编码器，负责将Object类型的POJO对象编码为byte数组，
 * 然后写入到byteBuf中
 */
public class MsgpackEncoder extends MessageToByteEncoder<Object> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        try {
            MessagePack messagePack = new MessagePack();
            byte[] raw = messagePack.write(o);

            byteBuf.writeBytes(raw);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }
}
