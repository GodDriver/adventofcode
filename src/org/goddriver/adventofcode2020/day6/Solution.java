package org.goddriver.adventofcode2020.day6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    static int getGroupCounts(String groupAnswers) {
        return groupAnswers.replaceAll("\n", "").chars().distinct().toArray().length;
    }

    static int getEveryOneCounts(String groupAnswers,
                                 int countPerson) {
        groupAnswers = groupAnswers.replaceAll("\n", "");
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < groupAnswers.length(); i++) {
            if (charCountMap.containsKey(groupAnswers.charAt(i))) {
                charCountMap.put(groupAnswers.charAt(i), charCountMap.get(groupAnswers.charAt(i)) + 1);
            }
            else {
                charCountMap.put(groupAnswers.charAt(i), 1);
            }
        }
        return charCountMap.values().stream()
                                    .filter(v -> v == countPerson)
                                    .toArray().length;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "src/org/goddriver/adventofcode2020/day6/input";
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)));
        StringBuilder oneGroup = new StringBuilder();
        int sum = 0, sum2 = 0;
        int countPerson = 0;
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            if (!string.equals("")) {
                oneGroup.append(string);
                countPerson++;
            }
            else {
                sum += getGroupCounts(oneGroup.toString());
                sum2 += getEveryOneCounts(oneGroup.toString(), countPerson);
                oneGroup = new StringBuilder();
                countPerson = 0;
            }
            if (!scanner.hasNextLine()) {
                sum += getGroupCounts(oneGroup.toString());
                sum2 += getEveryOneCounts(oneGroup.toString(), countPerson);
            }
        }
        scanner.close();
        System.out.println("The sum of those counts is " + sum);
        System.out.println("The sum of those counts in part two is " + sum2);
    }
}
