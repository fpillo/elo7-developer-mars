package com.elo7.mars.domains;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import com.elo7.mars.exceptions.InvalidPointException;

public class MarsTest {

    @Test
    public void test_findRoverAt_found() throws Exception {
        final Mars mars = createMars(5, 4);
        final Rover rover = new Rover(UUID.randomUUID(), new Position(2, 3, "N"));
        mars.insertAt(rover);

        Assert.assertEquals(true, mars.findRoverAt(new Point(2,3)).isPresent());
    }

    @Test
    public void test_findRoverAt_notFound() throws Exception {
        final Mars mars = createMars(5, 4);

        Assert.assertEquals(false, mars.findRoverAt(new Point(2,3)).isPresent());
    }

    @Test
    public void test_insertAt_valid_point() throws Exception {
        final Mars mars = createMars(5, 4);
        final Rover rover = new Rover(UUID.randomUUID(), new Position(2, 3, "N"));
        mars.insertAt(rover);
    }

    @Test(expected = InvalidPointException.class)
    public void test_insertAt_invalid_point() throws Exception {
        final Mars mars = createMars(5, 4);
        final Rover rover = new Rover(UUID.randomUUID(), new Position(6, 4, "N"));
        mars.insertAt(rover);
    }

    private Mars createMars(final Integer limitX, final Integer limitY) {
        return new Mars(limitX, limitY);
    }


}
