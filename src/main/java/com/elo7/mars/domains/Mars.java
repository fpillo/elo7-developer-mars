package com.elo7.mars.domains;

import java.util.Optional;
import java.util.Vector;

public class Mars {

    private final Vector<Vector<Rover>> map;

    public Mars(final Integer limitY, final Integer limitX) {
        final Vector<Vector<Rover>> y = new Vector<>(limitY);
        for(int i = 0; i < limitX; i++) {
            final Vector<Rover> x = new Vector<>(limitX);
            y.set(i, x);
        }

        this.map = y;
    }

    public Optional<Rover> findRoverAt(final Point point) {
        return Optional.ofNullable(map.get(point.getY()).get(point.getX()));
    }

    public Rover insertAt(final Point point, final Rover rover) {
        return map.get(point.getY()).set(point.getX(), rover);
    }


}
