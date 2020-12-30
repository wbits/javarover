package com.wbits.javarover.rover;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoverTest {
    @Test
    public void testItCanBeInitiatedWithBearerAndPosition() {
        Rover rover = Rover.init();
        assertEquals("N, 0, 0", rover.executeCommand(""));
    }

    @Test
    public void testItCanTurnRight() {
        Rover rover = Rover.init();
        assertEquals("E, 0, 0", rover.executeCommand("rrrrr"));
    }

    @Test
    public void testItCanTurnLeft() {
        Rover rover = Rover.init();
        assertEquals("W, 0, 0", rover.executeCommand("lllll"));
    }

    @Test
    public void testItCanMoveForward() {
        Rover rover = Rover.init();
        assertEquals("N, 0, 2", rover.executeCommand("ff"));
    }

    @Test
    public void testItCanTurnAndMoveForward() {
        Rover rover = Rover.init();
        assertEquals("S, 0, -2", rover.executeCommand("llff"));
    }

    @Test
    public void testItCanTurnAndMoveBackward() {
        Rover rover = Rover.init();
        assertEquals("E, -3, 0", rover.executeCommand("rbbb"));
    }
}
