package com.elo7.mars.usecases;

import com.elo7.mars.domains.Mars;
import com.elo7.mars.domains.Rover;
import com.elo7.mars.domains.commands.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ControlRover {

    private final Mars mars;

    @Autowired
    public ControlRover(final Mars mars) {
        this.mars = mars;
    }

    public Rover control(final Rover rover, final Collection<Command> commands) {
        commands.forEach(command -> {
            command.execute(rover, mars);
        });

        return rover;
    }

}
