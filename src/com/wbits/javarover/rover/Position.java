package com.wbits.javarover.rover;

public class Position {
    private final int x;
    private final int y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position start() {
        return new Position(0, 0);
    }

    public static Position moveNorth(Position position) {
        return new Position(position.x, position.y + 1);
    }

    public static Position moveSouth(Position position) {
        return new Position(position.x, position.y - 1);
    }

    public static Position moveEast(Position position) {
        return new Position(position.x + 1, position.y);
    }

    public static Position moveWest(Position position) {
        return new Position(position.x - 1, position.y);
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }
}
