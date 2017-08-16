package com.elo7.mars.usecases;

import com.elo7.mars.domains.Mars;
import com.elo7.mars.domains.Rover;
import com.elo7.mars.domains.WorldContext;
import com.elo7.mars.domains.commands.Command;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class ControlRover {

    public Collection<Rover> control(final WorldContext worldContext) {
        final Collection<Rover> rovers = new ArrayList<>();
        final Mars mars = worldContext.getMars();

        worldContext.getRoverMap().forEach((rover,commands)->{
            rovers.add(executeRover(mars, rover, commands));
        });

        return rovers;
    }

    private Rover executeRover(final Mars mars, final Rover rover, final Collection<Command> commands) {
        commands.forEach(command -> {
            command.execute(rover, mars);
        });

        return rover;
    }


}
