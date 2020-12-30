package com.wbits.javarover.rover;

public class Bearing {
    final private static String[] directions = {"N", "E", "S", "W"};
    final private int direction;

    private Bearing(int direction) {
        this.direction = direction;
    }

    public static Bearing north() {
        return new Bearing(0);
    }

    public static Bearing turnRight(Bearing bearing) {
        return new Bearing((bearing.direction + 1) % 4);
    }

    public static Bearing turnLeft(Bearing bearing) {
        return new Bearing((bearing.direction + 3) % 4);
    }

    public int direction() {
        return direction;
    }

    public String toString() {
        return directions[direction];
    }
}
