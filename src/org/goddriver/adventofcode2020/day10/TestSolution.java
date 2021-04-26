package org.goddriver.adventofcode2020.day10;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.math.BigInteger;

import static org.goddriver.adventofcode2020.day10.Solution.*;
import static org.junit.Assert.assertEquals;

public class TestSolution {

    String example = """
            16
            10
            15
            5
            1
            11
            7
            19
            6
            12
            4""";

    String largeExample = """
            28
            33
            18
            42
            31
            14
            46
            20
            48
            47
            24
            23
            49
            45
            19
            38
            39
            11
            1
            32
            25
            35
            8
            17
            7
            9
            4
            2
            34
            10
            3""";

    @Test
    @DisplayName("Getting the number of 1-jolt differences multiplied by the number of 3-jolt differences")
    public void testCountPairsWithDiffK() {
        assertEquals(countPairsWithDiffK(getList(example), 1), 7);
        assertEquals(countPairsWithDiffK(getList(example), 3), 5);

        assertEquals(countPairsWithDiffK(getList(largeExample), 1), 22);
        assertEquals(countPairsWithDiffK(getList(largeExample), 3), 10);
    }

    @Test
    @DisplayName("Getting the total number of distinct ways to arrange adapters "
            + "for connecting the charging outlet to device")
    public void testGetTotalNumberOfArrangements() {
        assertEquals(getTotalNumberOfArrangements(getList(example)), BigInteger.valueOf(8));

        assertEquals(getTotalNumberOfArrangements(getList(largeExample)), BigInteger.valueOf(19208));
    }
}
