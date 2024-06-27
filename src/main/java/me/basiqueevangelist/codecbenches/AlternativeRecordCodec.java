package me.basiqueevangelist.codecbenches;

import com.mojang.datafixers.util.Function16;
import com.mojang.serialization.*;

import java.util.function.Function;
import java.util.stream.Stream;

public class AlternativeRecordCodec {
    public static <T, F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, F13, F14, F15, F16> MapCodec<T> of(
        MapCodec<F1> codec1, Function<T, F1> getter1,
        MapCodec<F2> codec2, Function<T, F2> getter2,
        MapCodec<F3> codec3, Function<T, F3> getter3,
        MapCodec<F4> codec4, Function<T, F4> getter4,
        MapCodec<F5> codec5, Function<T, F5> getter5,
        MapCodec<F6> codec6, Function<T, F6> getter6,
        MapCodec<F7> codec7, Function<T, F7> getter7,
        MapCodec<F8> codec8, Function<T, F8> getter8,
        MapCodec<F9> codec9, Function<T, F9> getter9,
        MapCodec<F10> codec10, Function<T, F10> getter10,
        MapCodec<F11> codec11, Function<T, F11> getter11,
        MapCodec<F12> codec12, Function<T, F12> getter12,
        MapCodec<F13> codec13, Function<T, F13> getter13,
        MapCodec<F14> codec14, Function<T, F14> getter14,
        MapCodec<F15> codec15, Function<T, F15> getter15,
        MapCodec<F16> codec16, Function<T, F16> getter16,
        Function16<F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12, F13, F14, F15, F16, T> factory
    ) {
        return new MapCodec<T>() {
            @Override
            public <T1> Stream<T1> keys(DynamicOps<T1> ops) {
                return Stream.of(codec1, codec2, codec3, codec4, codec5, codec6, codec7, codec8, codec9, codec10, codec11, codec12, codec13, codec14, codec15, codec16)
                    .flatMap(x -> x.keys(ops));
            }

            @Override
            public <T1> DataResult<T> decode(DynamicOps<T1> ops, MapLike<T1> input) {
                return codec1.decode(ops, input).flatMap(v1 -> {
                    return codec2.decode(ops, input).flatMap(v2 -> {
                        return codec3.decode(ops, input).flatMap(v3 -> {
                            return codec4.decode(ops, input).flatMap(v4 -> {
                                return codec5.decode(ops, input).flatMap(v5 -> {
                                    return codec6.decode(ops, input).flatMap(v6 -> {
                                        return codec7.decode(ops, input).flatMap(v7 -> {
                                            return codec8.decode(ops, input).flatMap(v8 -> {
                                                return codec9.decode(ops, input).flatMap(v9 -> {
                                                    return codec10.decode(ops, input).flatMap(v10 -> {
                                                        return codec11.decode(ops, input).flatMap(v11 -> {
                                                            return codec12.decode(ops, input).flatMap(v12 -> {
                                                                return codec13.decode(ops, input).flatMap(v13 -> {
                                                                    return codec14.decode(ops, input).flatMap(v14 -> {
                                                                        return codec15.decode(ops, input).flatMap(v15 -> {
                                                                            return codec16.decode(ops, input).map(v16 -> {
                                                                                return factory.apply(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16);
                                                                            });
                                                                        });
                                                                    });
                                                                });
                                                            });
                                                        });
                                                    });
                                                });
                                            });
                                        });
                                    });
                                });
                            });
                        });
                    });
                });
            }

            @Override
            public <T1> RecordBuilder<T1> encode(T input, DynamicOps<T1> ops, RecordBuilder<T1> prefix) {
                codec1.encode(getter1.apply(input), ops, prefix);
                codec2.encode(getter2.apply(input), ops, prefix);
                codec3.encode(getter3.apply(input), ops, prefix);
                codec4.encode(getter4.apply(input), ops, prefix);
                codec5.encode(getter5.apply(input), ops, prefix);
                codec6.encode(getter6.apply(input), ops, prefix);
                codec7.encode(getter7.apply(input), ops, prefix);
                codec8.encode(getter8.apply(input), ops, prefix);
                codec9.encode(getter9.apply(input), ops, prefix);
                codec10.encode(getter10.apply(input), ops, prefix);
                codec11.encode(getter11.apply(input), ops, prefix);
                codec12.encode(getter12.apply(input), ops, prefix);
                codec13.encode(getter13.apply(input), ops, prefix);
                codec14.encode(getter14.apply(input), ops, prefix);
                codec15.encode(getter15.apply(input), ops, prefix);
                codec16.encode(getter16.apply(input), ops, prefix);
                return prefix;
            }
        };
    }
}
