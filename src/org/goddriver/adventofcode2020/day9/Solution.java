package org.goddriver.adventofcode2020.day9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    private static ArrayList<Long> getList(String input) {
        Scanner scanner = new Scanner(input);
        ArrayList<Long> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            list.add(Long.parseLong(scanner.nextLine()));
        }
        scanner.close();
        return list;
    }

    static long getNumber(String input, int preamble) {
        ArrayList<Long> numbers = getList(input);
        outer:
        for (int i = preamble; i < numbers.size(); i++) {
            ArrayList<Long> previousTwentyFiveNumbers = new ArrayList<>(numbers.subList(i - preamble, i));
            for (int j = previousTwentyFiveNumbers.size() - 1; j >= 0; j--) {
                long current = previousTwentyFiveNumbers.get(0);
                previousTwentyFiveNumbers.remove(0);
                if (previousTwentyFiveNumbers.contains(numbers.get(i) - current)) {
                    continue outer;
                }
                if (previousTwentyFiveNumbers.size() == 0) {
                    return numbers.get(i);
                }
            }
        }
        return Long.MIN_VALUE;
    }

    static long getTheEncryptionWeakness(String input, int preamble) {
        ArrayList<Long> numbers = getList(input);
        ArrayList<Long> list = new ArrayList<>();
        long sum = getNumber(input, preamble);
        for (Long number : numbers) {
            long currentSum = list.stream().mapToLong(Long::longValue).sum();
            while (currentSum > sum) {
                list.remove(0);
                currentSum = list.stream().mapToLong(Long::longValue).sum();
            }
            if (currentSum < sum)
                list.add(number);
            else if (currentSum == sum && list.size() >= 2) {
                return Collections.max(list) + Collections.min(list);
            }
        }
        return Long.MIN_VALUE;
    }

    public static void main(String[] args) throws IOException {
        String filename = "src/org/goddriver/adventofcode2020/day9/input";
        String puzzleInput = Files.readString(Path.of(filename));
        //Part One
        System.out.println("The first number that does not have this property is "
                + getNumber(puzzleInput, 25));
        //Part Two
        System.out.println("The encryption weakness in XMAS-encrypted list of numbers is "
                + getTheEncryptionWeakness(puzzleInput, 25));
    }
}
