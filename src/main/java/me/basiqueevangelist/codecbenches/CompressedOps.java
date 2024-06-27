package me.basiqueevangelist.codecbenches;

import com.mojang.serialization.DynamicOps;
import dev.lukebemish.codecextras.companion.DelegatingOps;

public class CompressedOps<T> extends DelegatingOps<T> {
    public CompressedOps(DynamicOps<T> delegate) {
        super(delegate);
    }

    @Override
    public boolean compressMaps() {
        return true;
    }
}
