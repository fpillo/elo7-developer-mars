package com.elo7.mars.controllers;

import com.elo7.mars.domains.Position;
import com.elo7.mars.domains.Rover;
import com.elo7.mars.domains.WorldContext;
import com.elo7.mars.usecases.ExecuteRovers;
import com.elo7.mars.usecases.CreateWorldContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class RoverController {

    private final CreateWorldContext createWorldContext;

    private final ExecuteRovers executeRovers;

    @Autowired
    public RoverController(final CreateWorldContext createWorldContext, final ExecuteRovers executeRovers) {
        this.createWorldContext = createWorldContext;
        this.executeRovers = executeRovers;
    }

    @PostMapping(consumes = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Collection<Position> start(@RequestBody final String input) {
        final WorldContext worldContext = createWorldContext.create(input);
        final Collection<Rover> rovers = executeRovers.control(worldContext);

        return extract(rovers);
    }

    private final Collection<Position> extract(final Collection<Rover> rovers) {
        return rovers.stream().map(Rover::getPosition).collect((Collectors.toList()));
    }

}
