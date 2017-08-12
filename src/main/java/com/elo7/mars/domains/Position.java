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

    private Integer x;

    private Integer y;

    private CardinalPoint cardinalPoint;

    public Position(final Integer x, final Integer y, final String cardinal) {
        this.x = x;
        this.y = y;
        this.cardinalPoint = CardinalPoint.valueOf(cardinal);
    }

    public Position addY() {
        return new Position(x, y + 1, cardinalPoint.toString());
    }

    public Position subY() {
        return new Position(x, y - 1, cardinalPoint.toString());
    }

    public Position addX() {
        return new Position(x + 1,y, cardinalPoint.toString());
    }

    public Position subX() {
        return new Position(x - 1, y, cardinalPoint.toString());
    }

}


