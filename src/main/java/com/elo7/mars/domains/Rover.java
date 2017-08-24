package com.elo7.mars.domains;

import java.util.Optional;
import java.util.UUID;

import com.elo7.mars.exceptions.CollisionException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "uuid")
public class Rover {

    private UUID uuid;

    private Position position;

    public Rover(final UUID uuid, final Position position) {
        this.uuid = uuid;
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

    public Position launch(final Mars mars) {
        if (hasCollision(mars, position)) {
            throw new CollisionException();
        }

        mars.insertAt(this);
        return position;
    }

    public Position move(final Mars mars) {
        final Position newPosition = calculateNewPosition();
        if (hasCollision(mars, newPosition)) {
            throw new CollisionException();
        }

        mars.removeAt(this);
        mars.insertAt(this);
        position = newPosition;

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

    private boolean hasCollision(final Mars mars, final Position position) {
        final Optional<Rover> roverOptional = mars.findRoverAt(position.getPoint());
        if (roverOptional.isPresent()) {
            return roverOptional.get().getUuid() != this.getUuid();
        }

        return false;
    }

}
