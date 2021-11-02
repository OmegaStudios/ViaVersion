package com.viaversion.viaversion.Minestom.platform;

import com.viaversion.viaversion.ViaAPIBase;
import io.netty.buffer.ByteBuf;
import net.minestom.server.entity.Player;

public class MinestomViaAPI extends ViaAPIBase<Player> {

    @Override
    public int getPlayerVersion(Player player) {
        return getPlayerVersion(player.getUuid());
    }

    @Override
    public void sendRawPacket(Player player, ByteBuf packet) {
        sendRawPacket(player.getUuid(), packet);
    }
}
