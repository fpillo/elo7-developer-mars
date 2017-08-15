package com.elo7.mars.domains.commands;

import com.elo7.mars.domains.Mars;
import com.elo7.mars.domains.Rover;

public class TurnLeftCommand implements Command {

    @Override
    public void execute(final Rover rover, final Mars mars) {
        rover.turnLeft();
    }

}
