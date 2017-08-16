package com.elo7.mars.usecases;

import com.elo7.mars.domains.Mars;
import com.elo7.mars.domains.Position;
import com.elo7.mars.domains.Rover;
import com.elo7.mars.domains.WorldContext;
import com.elo7.mars.domains.commands.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CreateWorldContext {

    private final CommandBuilder commandBuilder;

    @Autowired
    public CreateWorldContext(final CommandBuilder commandBuilder) {
        this.commandBuilder = commandBuilder;
    }

    public WorldContext create(final String input) {
        final List<String> lines = extract(input);
        final Mars mars = extractMars(lines.get(0));
        final Map<Rover, Collection<Command>> map = extractMap(lines);

        return new WorldContext(mars, map);
    }

    private List<String> extract(final String input) {
        return Arrays.asList(input.split("\\r?\\n"));
    }

    private Mars extractMars(final String line) {
        final String [] limits = line.split(" ");
        return new Mars(Integer.valueOf(limits[0]), Integer.valueOf(limits[1]));
    }

    private Map<Rover, Collection<Command>> extractMap(final List<String> lines) {
        final Map<Rover, Collection<Command>> map = new HashMap<>();
        for (int i = 2; i < lines.size(); i = i + 2) {
            final Rover rover = extractRover(lines.get(i - 1));
            final Collection<Command> commands = extractCommands(lines.get(i));

            map.put(rover, commands);
        }

        return map;
    }

    private Rover extractRover(final String line) {
        final String [] roverAsString = line.split(" ");
        return new Rover(new Position(Integer.valueOf(roverAsString[0]), Integer.valueOf(roverAsString[1]), roverAsString[2]));
    }

    private Collection<Command> extractCommands(final String line) {
        return commandBuilder.build(line);
    }


}
