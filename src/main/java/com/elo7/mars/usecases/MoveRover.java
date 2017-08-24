package com.elo7.mars.usecases;

import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.elo7.mars.domains.Mars;
import com.elo7.mars.domains.Rover;
import com.elo7.mars.domains.commands.Command;
import com.elo7.mars.exceptions.RouverNotFoundException;

@Component
public class MoveRover {

    private final Mars mars;

    @Autowired
    public MoveRover(final Mars mars) {
        this.mars = mars;
    }

    public Rover move(final UUID uuid, final Collection<Command> commands) {
        final Rover rover = mars.findRoverByUuid(uuid).orElseThrow(() -> new RouverNotFoundException(uuid));
        commands.forEach(command -> {
            command.execute(rover);
        });

        return rover;
    }
    
}
