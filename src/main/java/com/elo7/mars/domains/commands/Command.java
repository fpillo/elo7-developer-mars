package com.elo7.mars.domains.commands;

import com.elo7.mars.domains.Mars;
import com.elo7.mars.domains.Rover;

public interface Command {

    void execute(Rover rover, Mars mars);

}
