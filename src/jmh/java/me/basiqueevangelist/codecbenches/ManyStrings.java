package me.basiqueevangelist.codecbenches;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.lukebemish.codecextras.ExtendedRecordCodecBuilder;
import io.wispforest.endec.Endec;
import io.wispforest.endec.impl.ReflectiveEndecBuilder;
import io.wispforest.endec.impl.StructEndecBuilder;

public record ManyStrings(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8,
                   String s9, String s10, String s11, String s12, String s13, String s14, String s15,
                   String s16) {
    public static final Codec<ManyStrings> DFU = RecordCodecBuilder.create(i -> i.group(
            Codec.STRING.fieldOf("s1").forGetter(ManyStrings::s1),
            Codec.STRING.fieldOf("s2").forGetter(ManyStrings::s2),
            Codec.STRING.fieldOf("s3").forGetter(ManyStrings::s3),
            Codec.STRING.fieldOf("s4").forGetter(ManyStrings::s4),
            Codec.STRING.fieldOf("s5").forGetter(ManyStrings::s5),
            Codec.STRING.fieldOf("s6").forGetter(ManyStrings::s6),
            Codec.STRING.fieldOf("s7").forGetter(ManyStrings::s7),
            Codec.STRING.fieldOf("s8").forGetter(ManyStrings::s8),
            Codec.STRING.fieldOf("s9").forGetter(ManyStrings::s9),
            Codec.STRING.fieldOf("s10").forGetter(ManyStrings::s10),
            Codec.STRING.fieldOf("s11").forGetter(ManyStrings::s11),
            Codec.STRING.fieldOf("s12").forGetter(ManyStrings::s12),
            Codec.STRING.fieldOf("s13").forGetter(ManyStrings::s13),
            Codec.STRING.fieldOf("s14").forGetter(ManyStrings::s14),
            Codec.STRING.fieldOf("s15").forGetter(ManyStrings::s15),
            Codec.STRING.fieldOf("s16").forGetter(ManyStrings::s16))
        .apply(i, ManyStrings::new));

    public static final Codec<ManyStrings> CODEC_EXTRAS = ExtendedRecordCodecBuilder
        .start(Codec.STRING.fieldOf("s1"), ManyStrings::s1)
        .field(Codec.STRING.fieldOf("s2"), ManyStrings::s2)
        .field(Codec.STRING.fieldOf("s3"), ManyStrings::s3)
        .field(Codec.STRING.fieldOf("s4"), ManyStrings::s4)
        .field(Codec.STRING.fieldOf("s5"), ManyStrings::s5)
        .field(Codec.STRING.fieldOf("s6"), ManyStrings::s6)
        .field(Codec.STRING.fieldOf("s7"), ManyStrings::s7)
        .field(Codec.STRING.fieldOf("s8"), ManyStrings::s8)
        .field(Codec.STRING.fieldOf("s9"), ManyStrings::s9)
        .field(Codec.STRING.fieldOf("s10"), ManyStrings::s10)
        .field(Codec.STRING.fieldOf("s11"), ManyStrings::s11)
        .field(Codec.STRING.fieldOf("s12"), ManyStrings::s12)
        .field(Codec.STRING.fieldOf("s13"), ManyStrings::s13)
        .field(Codec.STRING.fieldOf("s14"), ManyStrings::s14)
        .field(Codec.STRING.fieldOf("s15"), ManyStrings::s15)
        .field(Codec.STRING.fieldOf("s16"), ManyStrings::s16)
        .build(s16 -> s15 -> s14 -> s13 -> s12 -> s11 -> s10 -> s9 -> s8 -> s7 -> s6 -> s5 -> s4 -> s3 -> s2 -> s1 -> new ManyStrings(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16));

    public static final Endec<ManyStrings> ENDEC = StructEndecBuilder.of(
        Endec.STRING.fieldOf("s1", ManyStrings::s1),
        Endec.STRING.fieldOf("s2", ManyStrings::s2),
        Endec.STRING.fieldOf("s3", ManyStrings::s3),
        Endec.STRING.fieldOf("s4", ManyStrings::s4),
        Endec.STRING.fieldOf("s5", ManyStrings::s5),
        Endec.STRING.fieldOf("s6", ManyStrings::s6),
        Endec.STRING.fieldOf("s7", ManyStrings::s7),
        Endec.STRING.fieldOf("s8", ManyStrings::s8),
        Endec.STRING.fieldOf("s9", ManyStrings::s9),
        Endec.STRING.fieldOf("s10", ManyStrings::s10),
        Endec.STRING.fieldOf("s11", ManyStrings::s11),
        Endec.STRING.fieldOf("s12", ManyStrings::s12),
        Endec.STRING.fieldOf("s13", ManyStrings::s13),
        Endec.STRING.fieldOf("s14", ManyStrings::s14),
        Endec.STRING.fieldOf("s15", ManyStrings::s15),
        Endec.STRING.fieldOf("s16", ManyStrings::s16),
        ManyStrings::new
    );

    public static final Endec<ManyStrings> REFLECTIVE_ENDEC = ReflectiveEndecBuilder.SHARED_INSTANCE.get(ManyStrings.class);

    public static final Codec<ManyStrings> ENDEC_CODEC = CodecUtils.toCodec(ENDEC);

    public static final Codec<ManyStrings> ALTERNATIVE_CODEC = AlternativeRecordCodec.of(
        Codec.STRING.fieldOf("s1"), ManyStrings::s1,
        Codec.STRING.fieldOf("s2"), ManyStrings::s2,
        Codec.STRING.fieldOf("s3"), ManyStrings::s3,
        Codec.STRING.fieldOf("s4"), ManyStrings::s4,
        Codec.STRING.fieldOf("s5"), ManyStrings::s5,
        Codec.STRING.fieldOf("s6"), ManyStrings::s6,
        Codec.STRING.fieldOf("s7"), ManyStrings::s7,
        Codec.STRING.fieldOf("s8"), ManyStrings::s8,
        Codec.STRING.fieldOf("s9"), ManyStrings::s9,
        Codec.STRING.fieldOf("s10"), ManyStrings::s10,
        Codec.STRING.fieldOf("s11"), ManyStrings::s11,
        Codec.STRING.fieldOf("s12"), ManyStrings::s12,
        Codec.STRING.fieldOf("s13"), ManyStrings::s13,
        Codec.STRING.fieldOf("s14"), ManyStrings::s14,
        Codec.STRING.fieldOf("s15"), ManyStrings::s15,
        Codec.STRING.fieldOf("s16"), ManyStrings::s16,
        ManyStrings::new
    ).codec();
    static final ManyStrings EXAMPLE = new ManyStrings(
        "assume less - mald more",
        ":ctft: literally infinite and counting",
        "Unobtainium is usually found underground",
        "Did you know that Air is made of 78 percent nitrogen and 21 percent oxygen?",
        "We don't have to worry about people re-inventing Venezuela glisco, that's their problem for integrating the Bourgeoisie into their pack",
        "fuck i need to update tags again",
        "Don't use Forge, use Froge!",
        "Noaaan: I'm talking to my inner demons. Which is all of you",
        "There is a 1% chance that instead of Frog, you get Froge!",
        "it seems to react to redstone",
        "remember to update ubuntu, before it is too late",
        "DerGeistdesMatze - i will take the l",
        "idwtialsimmoedm - I didn't want to install a library so I made my own enchantment descriptions mod",
        "Here at Wisp Forest© we employ Wisp Tech Support™ magic, which solves your problem when you ask",
        "chyz: How could you do this to me, Blod. I loved you like a guy I don't know in real life :(",
        "chyzman: No sound or Ender Dragon leakage. Although Ender Dragon sound leakage is still a thing"
    );
}
