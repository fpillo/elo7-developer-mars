package com.elo7.mars.domains;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import lombok.Getter;

@Getter
public class Mars {

    private final Map<UUID, Rover> roverMap = new HashMap<>();

    private Rover [][] plane;

    private Integer limitX;

    private Integer limitY;

    public Mars(final Integer limitX, final Integer limitY) {
        setUp(limitX, limitY);
    }

    public Optional<Rover> findRoverAt(final Point point) {
        isValidPoint(point);
        return Optional.ofNullable(plane[point.getX()][point.getY()]);
    }

    public Optional<Rover> findRoverByUuid(final UUID uuid) {
        return Optional.ofNullable(roverMap.get(uuid));
    }

    public Rover insertAt(final Rover rover) {
        isValidPoint(rover.getPosition().getPoint());
        plane[rover.getPosition().getPoint().getX()][rover.getPosition().getPoint().getY()] = rover;
        roverMap.put(rover.getUuid(), rover);
        return rover;
    }

    public Rover removeAt(final Rover rover) {
        plane[rover.getPosition().getPoint().getX()][rover.getPosition().getPoint().getY()] = null;
        return roverMap.remove(rover);
    }

    public Mars update(final Integer limitX, final Integer limitY) {
        setUp(limitX, limitY);
        return this;
    }

    private void setUp(final Integer limitX, final Integer limitY) {
        this.limitX = limitX;
        this.limitY = limitY;
        this.plane = new Rover[limitX + 1][limitY + 1];
    }

    private void isValidPoint(final Point point) {
        if (point.getY() < 0 || point.getX() < 0 || point.getY() > limitY || point.getX() > limitX) {
            throw new IllegalArgumentException();
        }
    }

}
