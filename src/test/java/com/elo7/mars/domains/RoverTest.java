package com.elo7.mars.domains;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class RoverTest {

    @Test
    public void test_turnRight_from_n() throws Exception {
        final Rover rover = new Rover(UUID.randomUUID(), new Position(0, 0, "N"));
        rover.turnRight();

        Assert.assertEquals("E", rover.getPosition().getCardinalPoint().toString());
    }

    @Test
    public void test_turnRight_from_e() throws Exception {
        final Rover rover = new Rover(UUID.randomUUID(), new Position(0, 0, "E"));
        rover.turnRight();

        Assert.assertEquals("S", rover.getPosition().getCardinalPoint().toString());
    }

    @Test
    public void test_turnRight_from_s() throws Exception {
        final Rover rover = new Rover(UUID.randomUUID(), new Position(0, 0, "S"));
        rover.turnRight();

        Assert.assertEquals("W", rover.getPosition().getCardinalPoint().toString());
    }

    @Test
    public void test_turnRight_from_w() throws Exception {
        final Rover rover = new Rover(UUID.randomUUID(), new Position(0, 0, "W"));
        rover.turnRight();

        Assert.assertEquals("N", rover.getPosition().getCardinalPoint().toString());
    }

    @Test
    public void test_turnLeft_from_n() throws Exception {
        final Rover rover = new Rover(UUID.randomUUID(), new Position(0, 0, "N"));
        rover.turnLeft();

        Assert.assertEquals("W", rover.getPosition().getCardinalPoint().toString());
    }

    @Test
    public void test_turnLeft_from_e() throws Exception {
        final Rover rover = new Rover(UUID.randomUUID(), new Position(0, 0, "E"));
        rover.turnLeft();

        Assert.assertEquals("N", rover.getPosition().getCardinalPoint().toString());
    }

    @Test
    public void test_turnLeft_from_s() throws Exception {
        final Rover rover = new Rover(UUID.randomUUID(), new Position(0, 0, "S"));
        rover.turnLeft();

        Assert.assertEquals("E", rover.getPosition().getCardinalPoint().toString());
    }

    @Test
    public void test_turnLeft_from_w() throws Exception {
        final Rover rover = new Rover(UUID.randomUUID(), new Position(0, 0, "W"));
        rover.turnLeft();

        Assert.assertEquals("S", rover.getPosition().getCardinalPoint().toString());
    }

    @Test
    public void test_move_looking_to_n() throws Exception {
        final Mars mars = new Mars(5,5);
        final Rover rover = new Rover(UUID.randomUUID(), new Position(0, 0, "N"));
        rover.move(mars);

        Assert.assertEquals(new Position(0, 1, "N"), rover.getPosition());
    }

    @Test
    public void test_move_looking_to_e() throws Exception {
        final Mars mars = new Mars(5,5);
        final Rover rover = new Rover(UUID.randomUUID(), new Position(0, 0, "E"));
        rover.move(mars);

        Assert.assertEquals(new Position(1, 0, "E"), rover.getPosition());
    }

    @Test
    public void test_move_looking_to_s() throws Exception {
        final Mars mars = new Mars(5,5);
        final Rover rover = new Rover(UUID.randomUUID(), new Position(0, 1, "S"));
        rover.move(mars);

        Assert.assertEquals(new Position(0, 0, "S"), rover.getPosition());
    }

    @Test
    public void test_move_looking_to_w() throws Exception {
        final Mars mars = new Mars(5,5);
        final Rover rover = new Rover(UUID.randomUUID(), new Position(1, 0, "W"));
        rover.move(mars);

        Assert.assertEquals(new Position(0, 0, "W"), rover.getPosition());
    }

}
