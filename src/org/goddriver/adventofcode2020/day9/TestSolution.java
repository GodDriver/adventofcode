package org.goddriver.adventofcode2020.day9;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.goddriver.adventofcode2020.day9.Solution.getNumber;
import static org.goddriver.adventofcode2020.day9.Solution.getTheEncryptionWeakness;
import static org.junit.Assert.assertEquals;

public class TestSolution {

    String example = """
            35
            20
            15
            25
            47
            40
            62
            55
            65
            95
            102
            117
            150
            182
            127
            219
            299
            277
            309
            576""";

    @Test
    @DisplayName("Getting the first number which is not the sum of two of the 5 numbers before it")
    public void testGetNumber() {
        assertEquals(getNumber(example, 5), 127);
    }

    @Test
    @DisplayName("Getting the encryption weakness in XMAS-encrypted list of numbers")
    public void testGetTheEncryptionWeakness() {
        assertEquals(getTheEncryptionWeakness(example, 5), 62);
    }
}
