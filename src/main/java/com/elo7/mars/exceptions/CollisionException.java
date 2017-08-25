package com.elo7.mars.exceptions;

import com.elo7.mars.domains.Point;

public class CollisionException extends RuntimeException {

    public CollisionException(final Point point) {
        super(point.toString());
    }

}
