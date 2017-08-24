package com.elo7.mars.usecases;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.elo7.mars.domains.Mars;
import com.elo7.mars.domains.commands.Command;
import com.elo7.mars.domains.commands.MoveCommand;
import com.elo7.mars.domains.commands.TurnLeftCommand;
import com.elo7.mars.domains.commands.TurnRightCommand;

@Component
public class CommandBuilder {

    private final Mars mars;

    @Autowired
    public CommandBuilder(final Mars mars) {
        this.mars = mars;
    }

    public Collection<Command> build(final String commandLine) {
        final Collection<Command> commands = new ArrayList<>();
        final char[] cs = commandLine.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            commands.add(create(cs[i]));
        }

        return commands;
    }

    private Command create(final char c) {
        switch (c) {
            case 'M':
                return new MoveCommand(mars);
            case 'L':
                return new TurnLeftCommand();
            case 'R':
                return new TurnRightCommand();
            default:
                throw new IllegalArgumentException(String.format("Invalid command: %c", c));
        }
    }


}
