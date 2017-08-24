package com.elo7.mars.domains;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class Mars {

    private final Map<UUID, Rover> roverMap = new HashMap<>();

    private final Map<Point, Rover> pointMap = new HashMap<>();

    private final Integer limitX;

    private final Integer limitY;

    public Mars(final Integer limitX, final Integer limitY) {
        this.limitX = limitX;
        this.limitY = limitY;
    }

    public Optional<Rover> findRoverAt(final Point point) {
        isValidPoint(point);
        return Optional.ofNullable(pointMap.get(point));
    }

    public Optional<Rover> findRoverByUuid(final UUID uuid) {
        return Optional.ofNullable(roverMap.get(uuid));
    }

    public Rover insertAt(final Rover rover) {
        isValidPoint(rover.getPosition().getPoint());
        pointMap.put(rover.getPosition().getPoint(), rover);
        roverMap.put(rover.getUuid(), rover);
        return rover;
    }

    public Rover removeAt(final Rover rover) {
        return pointMap.remove(rover.getPosition().getPoint());
    }

    private void isValidPoint(final Point point) {
        if (point.getY() < 0 || point.getX() < 0 || point.getY() > limitY || point.getX() > limitX) {
            throw new IllegalArgumentException();
        }
    }

}
