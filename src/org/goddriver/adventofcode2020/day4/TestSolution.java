package org.goddriver.adventofcode2020.day4;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.goddriver.adventofcode2020.day4.Solution.isValid;
import static org.goddriver.adventofcode2020.day4.Solution.isValidValues;

public class TestSolution {

    @Test
    @DisplayName("Checking if the password is valid")
    public void testIsValid() {
        assertTrue(isValid("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\n" +
                "byr:1937 iyr:2017 cid:147 hgt:183cm"));
        assertFalse(isValid("iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884\n" +
                "hcl:#cfa07d byr:1929"));
        assertTrue(isValid("""
                hcl:#ae17e1 iyr:2013
                eyr:2024
                ecl:brn pid:760753108 byr:1931
                hgt:179cm"""));
        assertFalse(isValid("hcl:#cfa07d eyr:2025 pid:166559648\n" +
                "iyr:2011 ecl:brn hgt:59in"));
    }

    @Test
    @DisplayName("Checking if password values are correct")
    public void testIsValidValues() {
        assertFalse(isValidValues("eyr:1972 cid:100\n" +
                "hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926"));
        assertFalse(isValidValues("""
                iyr:2019
                hcl:#602927 eyr:1967 hgt:170cm
                ecl:grn pid:012533040 byr:1946"""));
        assertFalse(isValidValues("hcl:dab227 iyr:2012\n" +
                "ecl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277"));
        assertFalse(isValidValues("""
                hgt:59cm ecl:zzz
                eyr:2038 hcl:74454a iyr:2023
                pid:3556412378 byr:2007"""));
        assertTrue(isValidValues("pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980\n" +
                "hcl:#623a2f"));
        assertTrue(isValidValues("eyr:2029 ecl:blu cid:129 byr:1989\n" +
                "iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm"));
        assertTrue(isValidValues("""
                hcl:#888785
                hgt:164cm byr:2001 iyr:2015 cid:88
                pid:545766238 ecl:hzl
                eyr:2022"""));
        assertTrue(isValidValues("iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719"));
    }
}
