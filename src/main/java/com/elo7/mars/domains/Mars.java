package com.elo7.mars.domains;

import java.util.ArrayList;
import java.util.Optional;

public class Mars {

    private final ArrayList<ArrayList<Rover>> map;

    public Mars(final Integer limitX, final Integer limitY) {
        final ArrayList<ArrayList<Rover>> y = new ArrayList<>(limitY);
        for(int i = 0; i < limitY; i++) {
            y.add(createX(limitX));
        }

        this.map = y;
    }

    public Optional<Rover> findRoverAt(final Point point) {
        return Optional.ofNullable(map.get(point.getY()).get(point.getX()));
    }

    public Rover insertAt(final Point point, final Rover rover) {
        return map.get(point.getY()).set(point.getX(), rover);
    }

    private ArrayList<Rover> createX(final Integer limitX) {
        final ArrayList<Rover> x = new ArrayList<>(limitX);
        for (int i = 0; i < limitX; i++) {
            x.add(null);
        }
        return x;
    }


}
