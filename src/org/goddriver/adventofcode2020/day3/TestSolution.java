package org.goddriver.adventofcode2020.day3;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.math.BigInteger;

import static org.goddriver.adventofcode2020.day3.Solution.getCount;
import static org.goddriver.adventofcode2020.day3.Solution.getProduct;
import static org.junit.Assert.assertEquals;

public class TestSolution {

    String example = """
            ..##.......
            #...#...#..
            .#....#..#.
            ..#.#...#.#
            .#...##..#.
            ..#.##.....
            .#.#.#....#
            .#........#
            #.##...#...
            #...##....#
            .#..#...#.#
            """;

    @Test
    @DisplayName("Counting trees encountered")
    public void testGetCount() {
        assertEquals(getCount(example, 3, 1), 7);
    }

    @Test
    @DisplayName("Getting the product of the number of trees encountered on each of the listed slopes")
    public void testGetProduct() {
        assertEquals(getProduct(example), BigInteger.valueOf(336));
    }
}
