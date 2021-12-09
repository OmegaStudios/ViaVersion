package com.viaversion.viaversion.Minestom.command;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.commands.ViaCommandHandler;
import net.minestom.server.command.CommandManager;
import net.minestom.server.command.CommandSender;
import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.suggestion.Suggestion;
import net.minestom.server.listener.TabCompleteListener;
import net.minestom.server.listener.manager.PacketListenerManager;

import java.util.*;

public class MinestomCommandHandler extends ViaCommandHandler {
    private CommandManager commandManager = new CommandManager();

    public MinestomCommandHandler() {}

    public boolean onCommand(MinestomCommandSender sender, String[] args) {
        if (args.length == 0) {
            showHelp(sender);
        }
    }

    @Override
    public void onTabComplete(MinestomCommandSender sender, String[] args) {
        TabCompleteListener listener = new TabCompleteListener();

    }

    public void registerCommand(MinestomCommand command) {
        try {
            commandManager.register(command);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Suggestion> getSuggestions(CommandSender sender, String s) {

    }

    public void showHelp(MinestomCommandSender sender) {

    }

    private Set<MinestomCommand> calculateAllowedCommands(MinestomCommandSender sender) {

    }
}
