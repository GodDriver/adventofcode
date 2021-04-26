package org.goddriver.adventofcode2020.day6;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.goddriver.adventofcode2020.day6.Solution.getEveryOneCounts;
import static org.goddriver.adventofcode2020.day6.Solution.getGroupCounts;

public class TestSolution {

    String question1 = "abc";
    String question2 = """
            a
            b
            c
            """;
    String question3 = "ab\n" +
            "ac";
    String question4 = """
            a
            a
            a
            a
            """;
    String question5 = "b";

    @Test
    @DisplayName("Getting the number of questions to which anyone answered \"yes\"")
    public void testGetGroupCounts() {
        assertEquals(getGroupCounts(question1), 3);
        assertEquals(getGroupCounts(question2), 3);
        assertEquals(getGroupCounts(question3), 3);
        assertEquals(getGroupCounts(question4), 1);
        assertEquals(getGroupCounts(question5), 1);
    }

    @Test
    @DisplayName("Getting the number of questions to which everyone answered \"yes\"")
    public void testGetEveryOneCounts() {
        assertEquals(getEveryOneCounts(question1, 1), 3);
        assertEquals(getEveryOneCounts(question2, 3), 0);
        assertEquals(getEveryOneCounts(question3, 2), 1);
        assertEquals(getEveryOneCounts(question4, 4), 1);
        assertEquals(getEveryOneCounts(question5, 1), 1);
    }
}
