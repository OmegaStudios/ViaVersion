package com.viaversion.viaversion.Minestom.platform;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.configuration.AbstractViaConfig;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MinestomViaConfig extends AbstractViaConfig {
    private static final List<String> UNSUPPORTED = Arrays.asList("anti-xray-patch", "bungee-ping-interval",
            "bungee-ping-save", "bungee-servers", "velocity-ping-interval", "velocity-ping-save", "velocity-servers",
            "quick-move-action-fix", "change-1_9-hitbox", "change-1_14-hitbox", "blockconnection-method");

    public MinestomViaConfig() {
        super(new File(Via.getPlatform().getDataFolder(), "config.yml"));
        reloadConfig();
    }

    @Override
    public URL getDefaultConfigURL() {
        return MinestomViaConfig.class.getClassLoader().getResource("assets/viaversion/config.yml");
    }

    @Override
    protected void handleConfig(Map<String, Object> config) {
    }

    @Override
    public List<String> getUnsupportedOptions() {
        return UNSUPPORTED;
    }
}
