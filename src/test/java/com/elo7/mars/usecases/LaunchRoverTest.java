package com.elo7.mars.usecases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.elo7.mars.domains.Mars;
import com.elo7.mars.domains.Point;
import com.elo7.mars.domains.Position;

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

}
