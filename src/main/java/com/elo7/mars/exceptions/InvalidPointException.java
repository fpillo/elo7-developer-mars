package com.elo7.mars.exceptions;

import com.elo7.mars.domains.Point;

public class InvalidPointException extends RuntimeException {

    public InvalidPointException(final Point point) {
        super(point.toString());
    }

}
