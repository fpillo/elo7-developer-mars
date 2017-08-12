package com.elo7.mars.domains;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Rover {

    private Position position;

    public Rover(final Position position) {
        this.position = position;
    }

    public Position turnRight() {
        position.setCardinalPoint(position.getCardinalPoint().turnRight());
        return position;
    }

    public Position turnLeft() {
        position.setCardinalPoint(position.getCardinalPoint().turnLeft());
        return position;
    }

    public Position walk(final Mars mars) {
        final Position newPosition = calculateNewPosition();
        if (detectCollision(newPosition, mars)) {
            return null;
        }
        position = newPosition;
        mars.insertAt(new Point(newPosition.getX(), newPosition.getY()), this);

        return position;
    }

    private Position calculateNewPosition() {
        switch (position.getCardinalPoint()) {
            case N: {
                return position.addY();
            }
            case W: {
                return position.subX();
            }
            case S: {
                return position.subY();
            }
            case E: {
                return position.addX();
            }
            default: return null;
        }
    }

    private boolean detectCollision(final Position position, final Mars mars) {
        return mars.findRoverAt(new Point(position.getX(), position.getY())).isPresent();
    }

}
