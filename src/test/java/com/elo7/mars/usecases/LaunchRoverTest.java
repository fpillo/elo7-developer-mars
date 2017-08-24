package com.elo7.mars.usecases;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.elo7.mars.domains.Mars;
import com.elo7.mars.domains.Point;
import com.elo7.mars.domains.Position;
import com.elo7.mars.domains.Rover;
import com.elo7.mars.exceptions.CollisionException;

public class LaunchRoverTest {

    private LaunchRover launchRover;

    private Mars mars;

    @Before
    public void setUp() {
        mars = new Mars(10, 10);
        launchRover = new LaunchRover(mars);
    }

    @Test
    public void test_launch() {
        launchRover.launch(new Position(10, 10, "N"));
        Assert.assertTrue(mars.findRoverAt(new Point(10, 10)).isPresent());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_launch_invalid_position() {
        launchRover.launch(new Position(11, 10, "N"));
    }

    @Test(expected = CollisionException.class)
    public void test_launch_collision() {
        mars.insertAt(new Rover(UUID.randomUUID(), new Position(1 ,0, "E")));
        launchRover.launch(new Position(1, 0, "N"));
    }

}
