package com.wbits.javarover.rover;

public class Bearing {
    private final String[] directions;
    private final int heading;

    private Bearing(int heading) {
        this.heading = heading;
        directions = new String[4];
        directions[0] = "N";
        directions[1] = "E";
        directions[2] = "S";
        directions[3] = "W";
    }

    public static Bearing north() {
        return new Bearing(0);
    }

    public static Bearing turnRight(Bearing bearing) {
        int newHeading = (bearing.heading + 1) % 4;

        return new Bearing(newHeading);
    }

    public static Bearing turnLeft(Bearing bearing) {
        int newHeading = (bearing.heading + 3) % 4;

        return new Bearing(newHeading);
    }

    public int heading() {
        return heading;
    }

    public String toString() {
        return directions[heading];
    }
}
