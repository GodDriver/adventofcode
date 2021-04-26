package org.goddriver.adventofcode2020.day8;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.goddriver.adventofcode2020.day8.Solution.getValue;
import static org.goddriver.adventofcode2020.day8.Solution.getValueAfterTerminate;
import static org.junit.Assert.assertEquals;

public class TestSolution {

    String example = """
            nop +0
            acc +1
            jmp +4
            acc +3
            jmp -3
            acc -99
            acc +1
            jmp -4
            acc +6
            """;

    @Test
    @DisplayName("Getting a value from an accumulator")
    public void testGetValue() {
        assertEquals(getValue(example), 5);
    }

    @Test
    @DisplayName("Getting a value from an accumulator after the program terminates")
    public void testGetValueAfterTerminate() {
        assertEquals(getValueAfterTerminate(example), 8);
    }
}
