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

    public Position walk() {
        switch (position.getCardinalPoint()) {
            case N: {
                position.addY();
                break;
            }
            case W: {
                position.subX();
                break;
            }
            case S: {
                position.subY();
                break;
            }
            case E: {
                position.addX();
                break;
            }
        }

        return position;
    }

}
