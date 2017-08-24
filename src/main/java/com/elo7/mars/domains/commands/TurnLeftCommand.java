package com.elo7.mars.domains.commands;

import com.elo7.mars.domains.Rover;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TurnLeftCommand implements Command {

    @Override
    public void execute(final Rover rover) {
        rover.turnLeft();
    }

    @Override
    public String toString() {
        return "L";
    }

}
