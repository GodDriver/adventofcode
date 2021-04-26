package org.goddriver.adventofcode2020.day7;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.goddriver.adventofcode2020.day7.Solution.*;
import static org.junit.Assert.assertEquals;

public class TestSolution {

    String example = """
            light red bags contain 1 bright white bag, 2 muted yellow bags.
            dark orange bags contain 3 bright white bags, 4 muted yellow bags.
            bright white bags contain 1 shiny gold bag.
            muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
            shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
            dark olive bags contain 3 faded blue bags, 4 dotted black bags.
            vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
            faded blue bags contain no other bags.
            dotted black bags contain no other bags.
            """;

    @Test
    @DisplayName("Getting the number of bag colors which can eventually contain at least one shiny gold bag")
    public void testGetCountBagColors() {
        assertEquals(getCountBagColors(example), 4);
    }

    String example2 = """
            shiny gold bags contain 2 dark red bags.
            dark red bags contain 2 dark orange bags.
            dark orange bags contain 2 dark yellow bags.
            dark yellow bags contain 2 dark green bags.
            dark green bags contain 2 dark blue bags.
            dark blue bags contain 2 dark violet bags.
            dark violet bags contain no other bags
            """;

    @Test
    @DisplayName("Getting the number of individual bags inside single shiny gold bag")
    public void testGetCountBagInside() {
        assertEquals(getCountBagsInsideBag(getMapOfBags(example2), "shiny gold"), 126);
    }
}
