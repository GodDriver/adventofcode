package org.goddriver.adventofcode2020.day5;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.goddriver.adventofcode2020.day5.Solution.getColumn;
import static org.goddriver.adventofcode2020.day5.Solution.getRow;

public class TestSolution {

    @Test
    @DisplayName("Getting a row number")
    public void testGetRow() {
        assertEquals(getRow("FBFBBFFRLR"), 44);
        assertEquals(getRow("BFFFBBFRRR"), 70);
        assertEquals(getRow("FFFBBBFRRR"), 14);
        assertEquals(getRow("BBFFBBFRLL"), 102);
    }

    @Test
    @DisplayName("Getting a column number")
    public void testGetColumn() {
        assertEquals(getColumn("FBFBBFFRLR"), 5);
        assertEquals(getColumn("BFFFBBFRRR"), 7);
        assertEquals(getColumn("FFFBBBFRRR"), 7);
        assertEquals(getColumn("BBFFBBFRLL"), 4);
    }
}
