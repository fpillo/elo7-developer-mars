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

    public Integer addY() {
        this.y = y + 1;
        return y;
    }

    public Integer subY() {
        this.y = y - 1;
        return y;
    }

    public Integer addX() {
        this.x = x + 1;
        return x;
    }

    public Integer subX() {
        this.x = x - 1;
        return x;
    }

}


