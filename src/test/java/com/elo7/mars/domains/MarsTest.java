package com.elo7.mars.domains;

import org.junit.Assert;
import org.junit.Test;

public class MarsTest {

    @Test
    public void test_findRoverAt_found() throws Exception {
        final Mars mars = createMars(5, 4);
        final Rover rover = new Rover(new Position(2, 3, "N"));
        mars.insertAt(new Point(2,3), rover);

        Assert.assertEquals(true, mars.findRoverAt(new Point(2,3)).isPresent());
    }

    @Test
    public void test_findRoverAt_notFound() throws Exception {
        final Mars mars = createMars(5, 4);

        Assert.assertEquals(false, mars.findRoverAt(new Point(2,3)).isPresent());
    }

    private Mars createMars(final Integer limitX, final Integer limitY) {
        return new Mars(limitX, limitY);
    }


}
