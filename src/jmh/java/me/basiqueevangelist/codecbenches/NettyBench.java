package me.basiqueevangelist.codecbenches;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.wispforest.endec.format.bytebuf.ByteBufDeserializer;
import io.wispforest.endec.format.bytebuf.ByteBufSerializer;
import io.wispforest.endec.util.VarInts;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import java.nio.charset.StandardCharsets;

public class NettyBench {
    private static String readString(ByteBuf buf) {
        //noinspection UnstableApiUsage
        var sequenceLength = VarInts.readInt(buf::readByte);

        var string = buf.toString(buf.readerIndex(), sequenceLength, StandardCharsets.UTF_8);
        buf.readerIndex(buf.readerIndex() + sequenceLength);

        return string;
    }

    private static void writeString(ByteBuf buf, String str) {
        //noinspection UnstableApiUsage
        VarInts.writeInt(ByteBufUtil.utf8Bytes(str), buf::writeByte);

        ByteBufUtil.writeUtf8(buf, str);
    }

    private static ManyStrings deserializeNetty(ByteBuf buf) {
        return new ManyStrings(
            readString(buf),
            readString(buf),
            readString(buf),
            readString(buf),
            readString(buf),
            readString(buf),
            readString(buf),
            readString(buf),
            readString(buf),
            readString(buf),
            readString(buf),
            readString(buf),
            readString(buf),
            readString(buf),
            readString(buf),
            readString(buf)
        );
    }

    private static void serializeNetty(ByteBuf buf, ManyStrings record) {
        writeString(buf, record.s1());
        writeString(buf, record.s2());
        writeString(buf, record.s3());
        writeString(buf, record.s4());
        writeString(buf, record.s5());
        writeString(buf, record.s6());
        writeString(buf, record.s7());
        writeString(buf, record.s8());
        writeString(buf, record.s9());
        writeString(buf, record.s10());
        writeString(buf, record.s11());
        writeString(buf, record.s12());
        writeString(buf, record.s13());
        writeString(buf, record.s14());
        writeString(buf, record.s15());
        writeString(buf, record.s16());
    }

    @Benchmark
    public void manual(Blackhole blackhole) {
        ByteBuf buf = Unpooled.buffer();
        serializeNetty(buf, ManyStrings.EXAMPLE);
        blackhole.consume(deserializeNetty(buf));
    }

    @Benchmark
    public void endec(Blackhole blackhole) {
        ByteBuf buf = Unpooled.buffer();
        ManyStrings.ENDEC.encodeFully(() -> ByteBufSerializer.of(buf), ManyStrings.EXAMPLE);
        blackhole.consume(ManyStrings.ENDEC.decodeFully(ByteBufDeserializer::of, buf));
    }
}
