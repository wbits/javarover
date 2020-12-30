package com.wbits.javarover.rover;

public class Rover {
    private Position position;
    private Bearing bearing;

    public Rover() {
        bearing = Bearing.headingNorth();
        position = Position.start();
    }

    public void executeCommand(String command) {
        for (String c: command.split("(?!^)")) {
            runSingleCommand(c);
        }
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

    public String toString() {
        return String.format("%s, %d, %d", String.valueOf(bearing), position.x(), position.y());
    }
}
