package com.elo7.mars.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.elo7.mars.controllers.json.LaunchRoverJson;
import com.elo7.mars.controllers.json.MoveRoverJson;
import com.elo7.mars.domains.Position;
import com.elo7.mars.domains.Rover;
import com.elo7.mars.usecases.CommandBuilder;
import com.elo7.mars.usecases.LaunchRover;
import com.elo7.mars.usecases.MoveRover;

@RestController
public class RoverController {

    private final LaunchRover launchRover;

    private final MoveRover moveRover;

    private final CommandBuilder commandBuilder;

    @Autowired
    public RoverController(final LaunchRover launchRover, final MoveRover moveRover, final CommandBuilder commandBuilder) {
        this.launchRover = launchRover;
        this.moveRover = moveRover;
        this.commandBuilder = commandBuilder;
    }

    @PostMapping(value = "/rovers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Rover launch(@RequestBody final LaunchRoverJson launchRoverJson) {
        final Position position = new Position(launchRoverJson.getX(), launchRoverJson.getY(), launchRoverJson.getCardinal());
        return launchRover.launch(position);
    }

    @PutMapping(value = "/rovers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public Rover move(@RequestBody final MoveRoverJson moveRoverJson) {
        return moveRover.move(moveRoverJson.getUuid(), commandBuilder.build(moveRoverJson.getCommand()));
    }


}
