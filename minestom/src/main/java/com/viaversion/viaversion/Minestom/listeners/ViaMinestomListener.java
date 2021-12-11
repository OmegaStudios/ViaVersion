package com.viaversion.viaversion.Minestom.listeners;

import com.viaversion.viaversion.ViaListener;
import com.viaversion.viaversion.api.protocol.Protocol;
import net.minestom.server.extensions.Extension;

public class ViaMinestomListener extends ViaListener {
    protected ViaMinestomListener(Extension extension, Class<? extends Protocol> requiredPipeline) {
        super(requiredPipeline);
    }

    @Override
    public void register() {
    }
}
