package org.goddriver.adventofcode2020.day1;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static org.goddriver.adventofcode2020.day1.Solution.getProductOfThreeEntries;
import static org.goddriver.adventofcode2020.day1.Solution.getProductOfTwoEntries;
import static org.junit.Assert.assertEquals;

public class TestSolution {

    String example = """
            1721
            979
            366
            299
            675
            1456""";

    @Test
    @DisplayName("Getting the product of two entries that sum to 2020")
    public void testGetProductOfTwoEntries() {
        assertEquals(getProductOfTwoEntries(example), 514579);
    }

    @Test
    @DisplayName("Getting the product of three entries that sum to 2020")
    public void testGetProductOfThreeEntries() {
        assertEquals(getProductOfThreeEntries(example), 241861950);
    }
}
