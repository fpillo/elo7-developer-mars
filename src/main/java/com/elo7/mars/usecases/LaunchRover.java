package com.elo7.mars.usecases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.elo7.mars.domains.Mars;
import com.elo7.mars.domains.Position;
import com.elo7.mars.domains.Rover;
import com.elo7.mars.domains.commands.Command;
import com.elo7.mars.domains.commands.LauchCommand;

@Component
public class LaunchRover {

    private final Mars mars;

    @Autowired
    public LaunchRover(final Mars mars) {
        this.mars = mars;
    }

    public Rover launch(final Position position) {
        final Rover rover = new Rover(UUID.randomUUID(), position);
        final Command command = new LauchCommand();
        command.execute(rover, mars);

        return rover;
    }

}
