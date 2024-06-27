package me.basiqueevangelist.codecbenches;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.mojang.serialization.JsonOps;
import io.wispforest.endec.format.json.GsonDeserializer;
import io.wispforest.endec.format.json.GsonSerializer;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

public class GsonBench {
    private static ManyStrings deserializeGson(JsonElement element) {
        JsonObject obj = element.getAsJsonObject();

        return new ManyStrings(
            obj.get("s1").getAsString(),
            obj.get("s2").getAsString(),
            obj.get("s3").getAsString(),
            obj.get("s4").getAsString(),
            obj.get("s5").getAsString(),
            obj.get("s6").getAsString(),
            obj.get("s7").getAsString(),
            obj.get("s8").getAsString(),
            obj.get("s9").getAsString(),
            obj.get("s10").getAsString(),
            obj.get("s11").getAsString(),
            obj.get("s12").getAsString(),
            obj.get("s13").getAsString(),
            obj.get("s14").getAsString(),
            obj.get("s15").getAsString(),
            obj.get("s16").getAsString()
        );
    }

    private static JsonElement serializeGson(ManyStrings record) {
        JsonObject obj = new JsonObject();

        obj.addProperty("s1", record.s1());
        obj.addProperty("s2", record.s2());
        obj.addProperty("s3", record.s3());
        obj.addProperty("s4", record.s4());
        obj.addProperty("s5", record.s5());
        obj.addProperty("s6", record.s6());
        obj.addProperty("s7", record.s7());
        obj.addProperty("s8", record.s8());
        obj.addProperty("s9", record.s9());
        obj.addProperty("s10", record.s10());
        obj.addProperty("s11", record.s11());
        obj.addProperty("s12", record.s12());
        obj.addProperty("s13", record.s13());
        obj.addProperty("s14", record.s14());
        obj.addProperty("s15", record.s15());
        obj.addProperty("s16", record.s16());

        return obj;
    }

    @Benchmark
    public void dfu(Blackhole blackhole) {
        JsonElement tree = ManyStrings.DFU.encodeStart(JsonOps.INSTANCE, ManyStrings.EXAMPLE).getOrThrow(JsonSyntaxException::new);
        blackhole.consume(ManyStrings.DFU.parse(JsonOps.INSTANCE, tree));
    }

    @Benchmark
    public void dfuCompressed(Blackhole blackhole) {
        JsonElement tree = ManyStrings.DFU.encodeStart(JsonOps.COMPRESSED, ManyStrings.EXAMPLE).getOrThrow(JsonSyntaxException::new);
        blackhole.consume(ManyStrings.DFU.parse(JsonOps.COMPRESSED, tree));
    }

    @Benchmark
    public void codecExtras(Blackhole blackhole) {
        JsonElement tree = ManyStrings.CODEC_EXTRAS.encodeStart(JsonOps.INSTANCE, ManyStrings.EXAMPLE).getOrThrow(JsonSyntaxException::new);
        blackhole.consume(ManyStrings.CODEC_EXTRAS.parse(JsonOps.INSTANCE, tree));
    }

    @Benchmark
    public void manual(Blackhole blackhole) {
        JsonElement tree = serializeGson(ManyStrings.EXAMPLE);
        blackhole.consume(deserializeGson(tree));
    }

    private static final Gson GSON = new Gson();

    @Benchmark
    public void automatic(Blackhole blackhole) {
        JsonElement tree = GSON.toJsonTree(ManyStrings.EXAMPLE, ManyStrings.class);
        blackhole.consume(GSON.fromJson(tree, ManyStrings.class));
    }

    @Benchmark
    public void endec(Blackhole blackhole) {
        JsonElement tree = ManyStrings.ENDEC.encodeFully(GsonSerializer::of, ManyStrings.EXAMPLE);
        blackhole.consume(ManyStrings.ENDEC.decodeFully(GsonDeserializer::of, tree));
    }

    @Benchmark
    public void endecCodec(Blackhole blackhole) {
        JsonElement tree = ManyStrings.ENDEC_CODEC.encodeStart(JsonOps.INSTANCE, ManyStrings.EXAMPLE).getOrThrow(JsonSyntaxException::new);
        blackhole.consume(ManyStrings.ENDEC_CODEC.parse(JsonOps.INSTANCE, tree));
    }

    @Benchmark
    public void reflectiveEndec(Blackhole blackhole) {
        JsonElement tree = ManyStrings.REFLECTIVE_ENDEC.encodeFully(GsonSerializer::of, ManyStrings.EXAMPLE);
        blackhole.consume(ManyStrings.REFLECTIVE_ENDEC.decodeFully(GsonDeserializer::of, tree));
    }

    @Benchmark
    public void alternativeCodec(Blackhole blackhole) {
        JsonElement tree = ManyStrings.ALTERNATIVE_CODEC.encodeStart(JsonOps.INSTANCE, ManyStrings.EXAMPLE).getOrThrow(JsonSyntaxException::new);
        blackhole.consume(ManyStrings.ALTERNATIVE_CODEC.parse(JsonOps.INSTANCE, tree));
    }
}
