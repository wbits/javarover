package com.wbits.javarover.rover;

public class Bearing {
    final private static String[] directions = {"N", "E", "S", "W"};
    final private int headingDirection;

    private Bearing(int headingDirection) {
        this.headingDirection = headingDirection;
    }

    public static Bearing headingNorth() {
        return new Bearing(0);
    }

    public static Bearing turnRight(Bearing bearing) {
        return new Bearing((bearing.headingDirection + 1) % 4);
    }

    public static Bearing turnLeft(Bearing bearing) {
        return new Bearing((bearing.headingDirection + 3) % 4);
    }

    public int direction() {
        return headingDirection;
    }

    public String toString() {
        return directions[headingDirection];
    }
}
