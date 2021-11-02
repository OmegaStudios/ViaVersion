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

    public void execute(CommandSender commandSender, CommandContext context) {
        String[] args = context.get("args").toString().split(" ");
        handler.onCommand(new MinestomCommandSender(commandSender), args);
    }
}
