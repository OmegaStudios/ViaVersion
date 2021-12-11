package com.viaversion.viaversion.Minestom.command;

import net.minestom.server.command.CommandSender;
import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.CommandContext;
import net.minestom.server.command.builder.arguments.ArgumentString;
import net.minestom.server.command.builder.arguments.ArgumentType;

public class MinestomCommand extends Command {
    private final MinestomCommandHandler handler;

    public MinestomCommand(MinestomCommandHandler handler) {
        super("viaversion", "viaver", "vvminestom");
        this.handler = handler;

        ArgumentString args = ArgumentType.String("args");

        addSyntax(this::execute, args);
    }

    public boolean execute(CommandSender commandSender, CommandContext context) {
        String[] args = context.get("args").toString().split(" ");
        boolean result = handler.onCommand(new MinestomCommandSender(commandSender), args);
        return result;
    }

    public boolean execute(MinestomCommandSender commandSender, String[] args) {
        boolean result = handler.onCommand(commandSender, args);
        return result;
    }
}
