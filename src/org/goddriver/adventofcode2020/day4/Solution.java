package org.goddriver.adventofcode2020.day4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static boolean isValid(String passportData) {
        return passportData.contains("byr")
                && passportData.contains("iyr")
                && passportData.contains("eyr")
                && passportData.contains("hgt")
                && passportData.contains("hcl")
                && passportData.contains("ecl")
                && passportData.contains("pid");
    }

    static boolean isValidValues(String passportData) {
        passportData = passportData.replaceAll("\n", " ");
        String[] fields = passportData.split(" ");
        Arrays.sort(fields);
        return isValid(passportData)
                && byrIsValid(fields[0])
                && eclIsValid(fields[fields.length - 6])
                && eyrIsValid(fields[fields.length - 5])
                && hclIsValid(fields[fields.length - 4])
                && hgtIsValid(fields[fields.length - 3])
                && iyrIsValid(fields[fields.length - 2])
                && pidIsValid(fields[fields.length - 1]);
    }

    private static boolean byrIsValid(String byr) {
        int year = Integer.parseInt(byr.substring(4));
        return year >= 1920 && year <= 2002;
    }

    private static boolean eclIsValid(String ecl) {
        String[] eyeColor = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
        return Arrays.asList(eyeColor).contains(ecl.substring(4));
    }

    private static boolean eyrIsValid(String eyr) {
        int year = Integer.parseInt(eyr.substring(4));
        return year >= 2020 && year <= 2030;
    }

    private static boolean hclIsValid(String hcl) {
        String hairColor = hcl.substring(4);
        return hairColor.startsWith("#") && hairColor.length() == 7;
    }

    private static boolean hgtIsValid(String hgt) {
        int height = Integer.parseInt(hgt.substring(4, hgt.length() - 2));
        if (hgt.endsWith("cm"))
            return height >= 150 && height <= 193;
        else
            return height >= 59 && height <= 76;
    }

    private static boolean iyrIsValid(String iyr) {
        int year = Integer.parseInt(iyr.substring(4));
        return year >= 2010 && year <= 2020;
    }

    private static boolean pidIsValid(String pid) {
        return pid.substring(4).length() == 9;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "src/org/goddriver/adventofcode2020/day4/input";
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)));
        StringBuilder passportData = new StringBuilder();
        int countValid = 0, countValidValues = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.equals("")) {
                passportData.append(line).append(" ");
            }
            else {
                if (isValid(passportData.toString()))
                    countValid++;
                if (isValidValues(passportData.toString()))
                    countValidValues++;
                passportData = new StringBuilder();
            }
            if (!scanner.hasNextLine()) {
                if (isValid(passportData.toString()))
                    countValid++;
                if (isValidValues(passportData.toString()))
                    countValidValues++;
            }
        }
        scanner.close();
        System.out.println("Count of valid passports in part one is " + countValid);
        System.out.println("Count of valid passports in part two is " + countValidValues);
    }
}
