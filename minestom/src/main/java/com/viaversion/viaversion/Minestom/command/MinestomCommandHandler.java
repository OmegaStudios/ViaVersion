package com.viaversion.viaversion.Minestom.command;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.commands.ViaCommandHandler;
import net.minestom.server.command.CommandManager;
import net.minestom.server.command.CommandSender;
import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.condition.CommandCondition;
import net.minestom.server.command.builder.suggestion.Suggestion;
import net.minestom.server.listener.TabCompleteListener;
import net.minestom.server.listener.manager.PacketListenerManager;
import org.checkerframework.checker.units.qual.C;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class MinestomCommandHandler extends ViaCommandHandler {
//    private CommandManager commandManager = new CommandManager();
//
//    public MinestomCommandHandler() {}
//
//    public MinestomCommand getCommand(String name) {
//        return (MinestomCommand) commandManager.getCommand(name);
//    }
//
//    public boolean onCommand(MinestomCommandSender sender, String[] args) {
//        if (args.length == 0) {
//            showHelp(sender);
//            return false;
//        }
//
//        MinestomCommand command = getCommand(args[0]);
//        List<Command> subCommands = command.getSubcommands();
//
//        if (!sender.hasPermission(command)) {
//            sender.sendMessage("Lol you thought");
//            return false;
//        }
//
//        boolean result = command.execute(sender, args);
//        if (!result) {
//            sender.sendMessage("It literally failed what are you even doing");
//        }
//        return result;
//    }
//
//    public List<String> onTabComplete(MinestomCommandSender sender, String[] args) {
//        Set<MinestomCommand> allowed = calculateAllowedCommands(sender);
//        List<String> output = new ArrayList<>();
//    }
//
//    public void registerCommand(MinestomCommand command) {
//        try {
//            commandManager.register(command);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<Suggestion> getSuggestions(CommandSender sender, String s) {
//
//    }
//
//    public void showHelp(MinestomCommandSender sender) {
//        sender.sendMessage("Here is a help message regarding your command");
//    }
//
//    private Set<MinestomCommand> calculateAllowedCommands(MinestomCommandSender sender) {
//        Set<MinestomCommand> commands = new HashSet<>();
//
//    }
}
