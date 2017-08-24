package com.elo7.mars.usecases;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.elo7.mars.domains.Mars;
import com.elo7.mars.domains.Position;
import com.elo7.mars.domains.Rover;
import com.elo7.mars.domains.commands.Command;
import com.elo7.mars.domains.commands.MoveCommand;
import com.elo7.mars.domains.commands.TurnLeftCommand;
import com.elo7.mars.domains.commands.TurnRightCommand;
import com.elo7.mars.exceptions.RouverNotFoundException;

public class MoveRoverTest {

    private MoveRover moveRover;

    private Mars mars;

    @Before
    public void setUp() {
        mars = new Mars(10 ,10);
        moveRover = new MoveRover(mars);
    }

    @Test
    public void test_move_single_move() throws Exception {
        final Rover rover = new Rover(UUID.randomUUID(), new Position(0 ,0, "N"));
        mars.insertAt(rover);

        final Collection<Command> commands = new ArrayList<>();
        commands.add(new MoveCommand());

        moveRover.move(rover.getUuid(), commands);
        Assert.assertEquals(new Position(0, 1, "N"), rover.getPosition());
    }

    @Test
    public void test_move_turn_right_move() throws Exception {
        final Rover rover = new Rover(UUID.randomUUID(), new Position(0 ,0, "N"));
        mars.insertAt(rover);

        final Collection<Command> commands = new ArrayList<>();
        commands.add(new TurnRightCommand());
        commands.add(new MoveCommand());

        moveRover.move(rover.getUuid(), commands);
        Assert.assertEquals(new Position(1, 0, "E"), rover.getPosition());
    }

    @Test
    public void test_move_turn_right_move_move_turn_left() throws Exception {
        final Rover rover = new Rover(UUID.randomUUID(), new Position(0 ,0, "N"));
        mars.insertAt(rover);

        final Collection<Command> commands = new ArrayList<>();
        commands.add(new TurnRightCommand());
        commands.add(new MoveCommand());
        commands.add(new MoveCommand());
        commands.add(new TurnLeftCommand());

        moveRover.move(rover.getUuid(), commands);
        Assert.assertEquals(new Position(2, 0, "N"), rover.getPosition());
    }

    @Test(expected = RouverNotFoundException.class)
    public void test_move_invalid_rouver() throws Exception {
        final Rover rover = new Rover(UUID.randomUUID(), new Position(0 ,0, "N"));

        final Collection<Command> commands = new ArrayList<>();
        commands.add(new TurnRightCommand());
        commands.add(new MoveCommand());

        moveRover.move(rover.getUuid(), commands);
    }

}
