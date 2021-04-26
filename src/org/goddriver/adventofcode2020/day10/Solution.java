package org.goddriver.adventofcode2020.day10;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

    static ArrayList<Integer> getList(String input) {
        Scanner scanner = new Scanner(input);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        while (scanner.hasNextLine()) {
            list.add(Integer.parseInt(scanner.nextLine()));
        }
        list.add(Collections.max(list) + 3);
        Collections.sort(list);
        scanner.close();
        return list;
    }

    static int countPairsWithDiffK(ArrayList<Integer> list,
                                   int k) {
        return (int) IntStream.range(0, list.size() - 1).filter(i -> list.get(i + 1) - list.get(i) == k).count();
    }

    static BigInteger getTotalNumberOfArrangements(ArrayList<Integer> list) {
        LinkedList<Integer> counts1 = new LinkedList<>();
        int count1 = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) - list.get(i) == 1) {
                count1++;
            } else {
                switch (count1) {
                    case 1 -> counts1.add(1);
                    case 2 -> counts1.add(2);
                    case 3 -> counts1.add(4);
                    case 4 -> counts1.add(7);
                    case 5 -> counts1.add(13);
                    case 6 -> counts1.add(22);
                }
                count1 = 0;
            }
        }
        BigInteger value = BigInteger.ONE;
        for (int count : counts1) {
            value = value.multiply(BigInteger.valueOf(count));
        }
        return value;
    }

    public static void main(String[] args) throws IOException {
        String filename = "src/org/goddriver/adventofcode2020/day10/input";
        String puzzleInput = Files.readString(Path.of(filename));
        ArrayList<Integer> adapters = getList(puzzleInput);
        //Part One
        System.out.println("The number of 1-jolt differences multiplied by the number of 3-jolt differences is "
                + countPairsWithDiffK(adapters, 1) * countPairsWithDiffK(adapters, 3));
        //Part Two
        System.out.println("The total number of distinct ways is "
                + getTotalNumberOfArrangements(adapters));
    }
}
