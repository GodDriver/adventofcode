package org.goddriver.adventofcode2020.day3;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Solution {

    static int getCount(String input,
                        int right,
                        int down) {
        int i = 0, count = 0;
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.charAt(i % line.length()) == '#')
                count++;
            i += right;
            if (down == 2 && scanner.hasNextLine())
                scanner.nextLine();
        }
        scanner.close();
        return count;
    }

    static BigInteger getProduct(String input) {
        BigInteger result = BigInteger.ONE;
        result = result
                .multiply(BigInteger.valueOf(getCount(input, 1, 1)))
                .multiply(BigInteger.valueOf(getCount(input, 3, 1)))
                .multiply(BigInteger.valueOf(getCount(input, 5, 1)))
                .multiply(BigInteger.valueOf(getCount(input, 7, 1)))
                .multiply(BigInteger.valueOf(getCount(input, 1, 2)));
        return result;
    }

    public static void main(String[] args) throws IOException {
        String filename = "src/org/goddriver/adventofcode2020/day3/input";
        String puzzleInput = Files.readString(Path.of(filename));
        //Part One
        System.out.println("In part one puzzle answer is " + getCount(puzzleInput, 3, 1));
        //Part Two
        System.out.println("In part two puzzle answer is " + getProduct(puzzleInput));
    }
}
