package com.elo7.mars.usecases;

import com.elo7.mars.domains.Mars;
import com.elo7.mars.domains.Position;
import com.elo7.mars.domains.Rover;
import com.elo7.mars.domains.commands.Command;
import com.elo7.mars.domains.commands.MoveCommand;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class ControlRoverTest {

    private ControlRover controlRover;

    @Before
    public void setUp() {
        controlRover = new ControlRover(new Mars(10, 10));
    }

    @Test
    public void test_control_single_move() throws Exception {
        final Rover rover = new Rover(new Position(0 ,0, "N"));
        final Collection<Command> commands = new ArrayList<>();
        commands.add(new MoveCommand());

        controlRover.control(rover, commands);
        Assert.assertEquals(new Position(0, 1, "N"), rover.getPosition());
    }

}
