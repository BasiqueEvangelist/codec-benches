package me.basiqueevangelist.codecbenches;

import blue.endless.jankson.Jankson;
import blue.endless.jankson.JsonElement;
import blue.endless.jankson.JsonObject;
import com.google.gson.JsonSyntaxException;
import dev.lukebemish.codecextras.compat.jankson.JanksonOps;
import io.wispforest.endec.format.json.JanksonDeserializer;
import io.wispforest.endec.format.json.JanksonSerializer;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

public class JanksonBench {
    @Benchmark
    public void dfu(Blackhole blackhole) {
        JsonElement tree = ManyStrings.DFU.encodeStart(JanksonOps.INSTANCE, ManyStrings.EXAMPLE).getOrThrow(JsonSyntaxException::new);
        blackhole.consume(ManyStrings.DFU.parse(JanksonOps.INSTANCE, tree));
    }

    @Benchmark
    public void endec(Blackhole blackhole) {
        JsonElement tree = ManyStrings.ENDEC.encodeFully(JanksonSerializer::of, ManyStrings.EXAMPLE);
        blackhole.consume(ManyStrings.ENDEC.decodeFully(JanksonDeserializer::of, tree));
    }

    private static final Jankson JANKSON = new Jankson.Builder().build();

    @Benchmark
    public void automatic(Blackhole blackhole) {
        JsonElement tree = JANKSON.toJson(ManyStrings.EXAMPLE);
        blackhole.consume(JANKSON.fromJson((JsonObject) tree, ManyStrings.class));
    }
}
