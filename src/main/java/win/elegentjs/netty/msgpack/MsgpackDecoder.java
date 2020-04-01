package win.elegentjs.netty.msgpack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.msgpack.MessagePack;

import java.util.List;

/**
 * MessagePack解码器
 */
public class MsgpackDecoder extends MessageToMessageDecoder<ByteBuf> {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        try {
            byte[] array = new byte[byteBuf.readableBytes()];
            byteBuf.getBytes(byteBuf.readerIndex(), array, 0, array.length);

            MessagePack messagePack = new MessagePack();
            list.add(messagePack.read(array, UserInfo.class));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }
}
