package com.elo7.mars.domains;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Position {

    private Point point;

    private CardinalPoint cardinalPoint;

    public Position(final Integer x, final Integer y, final String cardinal) {
        this.point = new Point(x, y);
        this.cardinalPoint = CardinalPoint.valueOf(cardinal);
    }

    public Position addY() {
        return new Position(point.getX(), point.getY() + 1, cardinalPoint.toString());
    }

    public Position subY() {
        return new Position(point.getX(), point.getY() - 1, cardinalPoint.toString());
    }

    public Position addX() {
        return new Position(point.getX() + 1, point.getY(), cardinalPoint.toString());
    }

    public Position subX() {
        return new Position(point.getX() - 1, point.getY(), cardinalPoint.toString());
    }

}


