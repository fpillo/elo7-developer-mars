package com.elo7.mars.domains;

import java.util.ArrayList;
import java.util.Optional;

public class Mars {

    private final ArrayList<ArrayList<Rover>> map;

    private final Integer limitX;

    private final Integer limitY;

    public Mars(final Integer limitX, final Integer limitY) {
        final ArrayList<ArrayList<Rover>> y = new ArrayList<>(limitY);
        for(int i = 0; i <= limitY; i++) {
            y.add(createX(limitX));
        }

        this.map = y;
        this.limitX = limitX;
        this.limitY = limitY;
    }

    public Optional<Rover> findRoverAt(final Point point) {
        isValidPoint(point);
        return Optional.ofNullable(map.get(point.getY()).get(point.getX()));
    }

    public Rover insertAt(final Rover rover) {
        isValidPoint(rover.getPosition().getPoint());
        return map.get(rover.getPosition().getPoint().getY()).set(rover.getPosition().getPoint().getX(), rover);
    }

    private void isValidPoint(final Point point) {
        if (point.getY() < 0 || point.getX() < 0 || point.getY() > limitY || point.getX() > limitX) {
            throw new IllegalArgumentException();
        }
    }


    private ArrayList<Rover> createX(final Integer limitX) {
        final ArrayList<Rover> x = new ArrayList<>(limitX);
        for (int i = 0; i <= limitX; i++) {
            x.add(null);
        }
        return x;
    }


}
