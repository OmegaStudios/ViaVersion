package com.viaversion.viaversion;

import com.google.gson.JsonObject;
import com.viaversion.viaversion.Minestom.command.MinestomCommand;
import com.viaversion.viaversion.Minestom.command.MinestomCommandHandler;
import com.viaversion.viaversion.Minestom.command.MinestomCommandSender;
import com.viaversion.viaversion.Minestom.platform.MinestomViaAPI;
import com.viaversion.viaversion.Minestom.platform.MinestomViaConfig;
import com.viaversion.viaversion.Minestom.platform.MinestomViaTask;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.ViaAPI;
import com.viaversion.viaversion.api.command.ViaCommandSender;
import com.viaversion.viaversion.api.configuration.ConfigurationProvider;
import com.viaversion.viaversion.api.configuration.ViaVersionConfig;
import com.viaversion.viaversion.api.platform.PlatformTask;
import com.viaversion.viaversion.api.platform.ViaPlatform;
import com.viaversion.viaversion.dump.PluginInfo;
import com.viaversion.viaversion.util.GsonUtil;
import net.minestom.server.MinecraftServer;
import net.minestom.server.entity.Player;
import net.minestom.server.extensions.Extension;
import net.minestom.server.utils.time.TimeUnit;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class MinestomExtension extends Extension implements ViaPlatform<Player> {

    private static MinestomExtension instance;
    private final ViaAPI<Player> api = new MinestomViaAPI();
    private final MinestomViaConfig conf;
    private final MinestomCommandHandler commandHandler;

    public MinestomExtension() {
        instance = this;
        commandHandler = new MinestomCommandHandler();

//        Via.init(ViaManagerImpl.builder()
//                .platform(this)
//                .commandHandler(commandHandler)
//                .injector(injector)
//                .loader(new BukkitViaLoader(this))
//                .build());

        this.conf = new MinestomViaConfig();
    }

    @Override
    public void initialize() {
        MinecraftServer.getCommandManager().register(new MinestomCommand(commandHandler));
    }

    @Override
    public void terminate() {

    }

    @Override
    public String getPlatformName() {
        return MinecraftServer.getBrandName();
    }

    @Override
    public String getPlatformVersion() {
        return MinecraftServer.VERSION_NAME;
    }

    @Override
    public String getPluginVersion() {
        return getOrigin().getVersion();
    }

    @Override
    public PlatformTask runAsync(Runnable runnable) {
        return new MinestomViaTask(MinecraftServer.getSchedulerManager().buildTask(runnable).schedule());
    }

    @Override
    public PlatformTask runSync(Runnable runnable) {
        return runAsync(runnable);
    }

    @Override
    public PlatformTask runSync(Runnable runnable, long ticks) {
        return new MinestomViaTask(MinecraftServer.getSchedulerManager().buildTask(runnable).delay(ticks, TimeUnit.SERVER_TICK).schedule());
    }

    @Override
    public PlatformTask runRepeatingSync(Runnable runnable, long ticks) {
        return new MinestomViaTask(MinecraftServer.getSchedulerManager().buildTask(runnable).repeat(ticks, TimeUnit.SERVER_TICK).schedule());
    }

    @Override
    public ViaCommandSender[] getOnlinePlayers() {
        ViaCommandSender[] array = new ViaCommandSender[MinecraftServer.getConnectionManager().getOnlinePlayers().size()];
        int i = 0;
        for (Player player : MinecraftServer.getConnectionManager().getOnlinePlayers()) {
            array[i++] = new MinestomCommandSender(player);
        }
        return array;
    }

    @Override
    public void sendMessage(UUID uuid, String message) {
        Player player = MinecraftServer.getConnectionManager().getPlayer(uuid);
        if(player != null) {
            player.sendMessage(message);
        }
    }

    @Override
    public boolean kickPlayer(UUID uuid, String message) {
        Player player = MinecraftServer.getConnectionManager().getPlayer(uuid);
        if(player != null) {
            player.kick(message);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isPluginEnabled() {
        return true;
    }

    @Override
    public ViaAPI<Player> getApi() {
        return api;
    }

    @Override
    public ViaVersionConfig getConf() {
        return conf;
    }

    @Override
    public ConfigurationProvider getConfigurationProvider() {
        return conf;
    }

    @Override
    public File getDataFolder() {
        return getOrigin().getDataDirectory().toFile();
    }

    @Override
    public void onReload() {

    }

    @Override
    public JsonObject getDump() {
        JsonObject platformSpecific = new JsonObject();

        List<PluginInfo> extensions = new ArrayList<>();
        for (Extension e : MinecraftServer.getExtensionManager().getExtensions())
            extensions.add(new PluginInfo(
                    true,
                    e.getOrigin().getName(),
                    e.getOrigin().getVersion(),
                    Objects.requireNonNull(e.getOrigin().getMinestomExtensionClassLoader()).getMainClassName(),
                    List.of(e.getOrigin().getAuthors())
            ));

        platformSpecific.add("extensions", GsonUtil.getGson().toJsonTree(extensions));
        return platformSpecific;
    }

    @Override
    public boolean isOldClientsAllowed() {
        return true;
    }

    public MinestomExtension getInstance() { return instance; }
}
