package com.elo7.mars.domains.commands;

import com.elo7.mars.domains.Mars;
import com.elo7.mars.domains.Rover;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LauchCommand implements Command {

    private final Mars mars;

    @Override
    public void execute(final Rover rover) {
        rover.launch(mars);
    }
}
