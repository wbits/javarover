package com.wbits.javarover.rover;

public class Rover {
    private Position position;
    private Bearing bearing;

    private Rover(Bearing bearing, Position position) {
        this.bearing = bearing;
        this.position = position;
    }

    public static Rover init() {
        return new Rover(Bearing.north(), Position.start());
    }

    public String executeCommand(String command) {
        for (String c: command.split("(?!^)")) {
            runSingleCommand(c);
        }

        return String.format("%s, %d, %d", String.valueOf(bearing), position.x(), position.y());
    }

    private void runSingleCommand(String command) {
        switch (command) {
            case "r" -> bearing = Bearing.turnRight(bearing);
            case "l" -> bearing = Bearing.turnLeft(bearing);
            case "f" -> move(bearing.direction());
            case "b" -> move((bearing.direction() + 2) % 4);
        }
    }

    private void move(int direction) {
        switch (direction) {
            case 0 -> position = Position.moveNorth(position);
            case 1 -> position = Position.moveEast(position);
            case 2 -> position = Position.moveSouth(position);
            case 3 -> position = Position.moveWest(position);
        }
    }
}
