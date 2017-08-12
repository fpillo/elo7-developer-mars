package com.elo7.mars.domains;

import lombok.ToString;

@ToString
public enum CardinalPoint {

    N("N"),
    S("S"),
    E("E"),
    W("W");

    private final String cardinal;

    CardinalPoint(final String cardinal) {
        this.cardinal = cardinal;
    }

    public CardinalPoint turnLeft() {
        switch (cardinal) {
            case "N": {
                return CardinalPoint.W;
            }
            case "W": {
                return CardinalPoint.S;
            }
            case "S": {
                return CardinalPoint.E;
            }
            case "E": {
                return CardinalPoint.N;
            }
            default:
                return null;
        }
    }

    public CardinalPoint turnRight() {
        switch (cardinal) {
            case "N": {
                return CardinalPoint.E;
            }
            case "W": {
                return CardinalPoint.N;
            }
            case "S": {
                return CardinalPoint.W;
            }
            case "E": {
                return CardinalPoint.S;
            }
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return cardinal;
    }

}

