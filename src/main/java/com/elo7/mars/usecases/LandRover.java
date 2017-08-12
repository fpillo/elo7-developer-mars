package com.elo7.mars.usecases;

import com.elo7.mars.domains.Mars;
import com.elo7.mars.domains.Rover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LandRover {

    private final Mars mars;

    @Autowired
    public LandRover(final Mars mars) {
        this.mars = mars;
    }

    public Rover land(final Rover rover) {
        rover.land(mars);

        return rover;
    }

}
