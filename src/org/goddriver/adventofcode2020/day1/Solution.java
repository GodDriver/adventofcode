package org.goddriver.adventofcode2020.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    private static ArrayList<Integer> getList(String input) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            list.add(Integer.parseInt(scanner.nextLine()));
        }
        scanner.close();
        return list;
    }

    static int getProductOfTwoEntries(String input) {
        ArrayList<Integer> list = getList(input);
        for (int i : list) {
            if (list.contains(2020 - i))
                return i * (2020 - i);
        }
        return -1;
        }

    static int getProductOfThreeEntries(String input) {
        ArrayList<Integer> list = getList(input);
        for (int i : list) {
            for (int j : list) {
                if (list.contains(2020 - i - j))
                    return i * j * (2020 - i - j);
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        String filename = "src/org/goddriver/adventofcode2020/day1/input";
        String puzzleInput = Files.readString(Path.of(filename));
        System.out.println("The product of two entries that sum to 2020 is "
                + getProductOfTwoEntries(puzzleInput));
        System.out.println("The product of three entries that sum to 2020 is "
                + getProductOfThreeEntries(puzzleInput));
    }
}
