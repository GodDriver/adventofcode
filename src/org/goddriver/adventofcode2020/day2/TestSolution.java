package org.goddriver.adventofcode2020.day2;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.goddriver.adventofcode2020.day2.Solution.getCountValidPasswords;
import static org.goddriver.adventofcode2020.day2.Solution.getCountValidPasswordsNewPolicies;
import static org.junit.Assert.*;

public class TestSolution {

    String example = """
            1-3 a: abcde
            1-3 b: cdefg
            2-9 c: ccccccccc""";

    @Test
    @DisplayName("Counting valid passwords")
    public void testGetCountValidPasswords() {
        assertEquals(getCountValidPasswords(example), 2);
    }

    @Test
    @DisplayName("Counting valid passwords according to the new interpretation of the policies")
    public void testGetCountValidPasswordsNewPolicies() {
        assertEquals(getCountValidPasswordsNewPolicies(example), 1);
    }
}
