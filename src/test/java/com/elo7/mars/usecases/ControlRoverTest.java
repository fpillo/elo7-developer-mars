package com.elo7.mars.usecases;

import com.elo7.mars.domains.Mars;
import com.elo7.mars.domains.Position;
import com.elo7.mars.domains.Rover;
import com.elo7.mars.domains.commands.Command;
import com.elo7.mars.domains.commands.MoveCommand;
import com.elo7.mars.domains.commands.TurnLeftCommand;
import com.elo7.mars.domains.commands.TurnRightCommand;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class ControlRoverTest {

    private ControlRover controlRover;

    @Before
    public void setUp() {
        controlRover = new ControlRover();
    }

    @Test
    public void test_control_single_move() throws Exception {
        final Rover rover = new Rover(new Position(0 ,0, "N"));
        final Collection<Command> commands = new ArrayList<>();
        commands.add(new MoveCommand());

        controlRover.control(createMars(10, 10), rover, commands);
        Assert.assertEquals(new Position(0, 1, "N"), rover.getPosition());
    }

    @Test
    public void test_control_turn_right_move() throws Exception {
        final Rover rover = new Rover(new Position(0 ,0, "N"));
        final Collection<Command> commands = new ArrayList<>();
        commands.add(new TurnRightCommand());
        commands.add(new MoveCommand());

        controlRover.control(createMars(10, 10), rover, commands);
        Assert.assertEquals(new Position(1, 0, "E"), rover.getPosition());
    }

    @Test
    public void test_control_turn_right_move_move_turn_left() throws Exception {
        final Rover rover = new Rover(new Position(0 ,0, "N"));
        final Collection<Command> commands = new ArrayList<>();
        commands.add(new TurnRightCommand());
        commands.add(new MoveCommand());
        commands.add(new MoveCommand());
        commands.add(new TurnLeftCommand());

        controlRover.control(createMars(10, 10), rover, commands);
        Assert.assertEquals(new Position(2, 0, "N"), rover.getPosition());
    }

    private Mars createMars(final Integer limitX, final Integer limitY) {
        return new Mars(limitX, limitY);
    }

}
