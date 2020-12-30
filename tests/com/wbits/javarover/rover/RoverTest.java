package com.wbits.javarover.rover;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(DataProviderRunner.class)
public class RoverTest {
    private Rover rover;

    @Before
    public void setUp() {
        rover = new Rover();
    }

    @Test
    public void testItGetsInitiatedWithBearerAndPosition() {
        assertEquals("N, 0, 0", String.valueOf(rover));
    }

    @Test
    @UseDataProvider("dataProvider")
    public void testItExecutesCommands(String command, String expected) {
        rover.executeCommand(command);

        assertEquals(expected, String.valueOf(rover));
    }

    @DataProvider
    public static Object[][] dataProvider() {
        return new Object[][]{
                {"rrrrr", "E, 0, 0"},
                {"lllll", "W, 0, 0"},
                {"ff", "N, 0, 2"},
                {"llff", "S, 0, -2"},
                {"rbbb", "E, -3, 0"},
        };
    }
}
