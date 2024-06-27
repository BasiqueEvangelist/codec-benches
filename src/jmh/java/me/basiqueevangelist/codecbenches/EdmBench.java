package me.basiqueevangelist.codecbenches;

import io.wispforest.endec.format.edm.EdmDeserializer;
import io.wispforest.endec.format.edm.EdmElement;
import io.wispforest.endec.format.edm.EdmSerializer;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

public class EdmBench {
    @Benchmark
    public void dfu(Blackhole blackhole) {
        EdmElement<?> tree = ManyStrings.DFU.encodeStart(EdmOps.withoutContext(), ManyStrings.EXAMPLE).getOrThrow(UnsupportedOperationException::new);
        blackhole.consume(ManyStrings.DFU.parse(EdmOps.withoutContext(), tree));
    }

    private static final CompressedOps<EdmElement<?>> COMPRESSED_EDM = new CompressedOps<>(EdmOps.withoutContext());

    @Benchmark
    public void dfuCompressed(Blackhole blackhole) {
        EdmElement<?> tree = ManyStrings.DFU.encodeStart(COMPRESSED_EDM, ManyStrings.EXAMPLE).getOrThrow(UnsupportedOperationException::new);
        blackhole.consume(ManyStrings.DFU.parse(COMPRESSED_EDM, tree));
    }

    @Benchmark
    public void codecExtras(Blackhole blackhole) {
        EdmElement<?> tree = ManyStrings.CODEC_EXTRAS.encodeStart(EdmOps.withoutContext(), ManyStrings.EXAMPLE).getOrThrow(UnsupportedOperationException::new);
        blackhole.consume(ManyStrings.CODEC_EXTRAS.parse(EdmOps.withoutContext(), tree));
    }

    @Benchmark
    public void endec(Blackhole blackhole) {
        EdmElement<?> tree = ManyStrings.ENDEC.encodeFully(EdmSerializer::of, ManyStrings.EXAMPLE);
        blackhole.consume(ManyStrings.ENDEC.decodeFully(EdmDeserializer::of, tree));
    }

    @Benchmark
    public void endecCodec(Blackhole blackhole) {
        EdmElement<?> tree = ManyStrings.ENDEC_CODEC.encodeStart(EdmOps.withoutContext(), ManyStrings.EXAMPLE).getOrThrow(UnsupportedOperationException::new);
        blackhole.consume(ManyStrings.ENDEC_CODEC.parse(EdmOps.withoutContext(), tree));
    }

    @Benchmark
    public void alternativeCodec(Blackhole blackhole) {
        EdmElement<?> tree = ManyStrings.ALTERNATIVE_CODEC.encodeStart(EdmOps.withoutContext(), ManyStrings.EXAMPLE).getOrThrow(UnsupportedOperationException::new);
        blackhole.consume(ManyStrings.ALTERNATIVE_CODEC.parse(EdmOps.withoutContext(), tree));
    }
}
