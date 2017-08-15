package com.elo7.mars.usecases;

import com.elo7.mars.domains.commands.Command;
import com.elo7.mars.domains.commands.MoveCommand;
import com.elo7.mars.domains.commands.TurnLeftCommand;
import com.elo7.mars.domains.commands.TurnRightCommand;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class CommandBuilder {

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
                return new MoveCommand();
            case 'L':
                return new TurnLeftCommand();
            case 'R':
                return new TurnRightCommand();
            default:
                return null;
        }
    }


}
