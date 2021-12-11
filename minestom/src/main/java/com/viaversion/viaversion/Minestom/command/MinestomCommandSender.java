package com.viaversion.viaversion.Minestom.command;

import com.viaversion.viaversion.api.command.ViaCommandSender;
import net.minestom.server.command.CommandSender;
import net.minestom.server.command.builder.condition.CommandCondition;
import net.minestom.server.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class MinestomCommandSender implements ViaCommandSender {
    private CommandSender sender;

    public MinestomCommandSender(CommandSender sender) {
        this.sender = sender;
    }

    @Override
    public boolean hasPermission(String permission) { return sender.hasPermission(permission); }

//    public boolean hasPermission(@NotNull MinestomCommand command) {
//        final CommandCondition commandCondition = command.getCondition();
//        if (commandCondition != null) {
//            // Do not show command if return false
//            if (!commandCondition.canUse(sender, command.toString())) {
//                return false;
//            }
//        }
//        return true;
//    }

    @Override
    public void sendMessage(String msg) { sender.sendMessage(msg); }

    @Override
    public UUID getUUID() {
        if (sender instanceof Player) {
            return ((Player) sender).getUuid();
        } else {
            return UUID.fromString(getName());
        }
    }

    @Override
    public String getName() {
        if (sender instanceof Player) {
            return ((Player) sender).getUsername();
        }
        // I can't replicate the same sadness as the one in VelocityCommandSender,
        // so have one of our staff's cats instead https://i.imgur.com/3wraDlh.png
        return "?";
    }
}
