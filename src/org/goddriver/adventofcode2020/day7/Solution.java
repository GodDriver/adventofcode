package org.goddriver.adventofcode2020.day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    static Map<String, Map<String, Integer>> getMapOfBags(String input) {
        Scanner scanner = new Scanner(input);
        Map<String, Map<String, Integer>> bags = new HashMap<>();
        while (scanner.hasNextLine()) {
            String[] bag = scanner.nextLine()
                    .replaceAll(" bags", "")
                    .replaceAll(" bag", "")
                    .replaceAll("\\.", "")
                    .replaceAll(" no other", "")
                    .replaceAll(" contain", ",")
                    .split(", ");
            Map<String, Integer> bagContents = new HashMap<>();
            for (int i = 1; i < bag.length; i++) {
                bagContents.put(bag[i].substring(bag[i].indexOf(" ") + 1),
                        Integer.parseInt(bag[i].substring(0, bag[i].indexOf(" "))));
            }
            bags.put(bag[0], bagContents);
        }
        scanner.close();
        return bags;
    }

    private static boolean isCurrentBagContainShinyGoldBag(Map<String, Map<String, Integer>> bags,
                                                           String bag) {
        if (bags.get(bag) == null || bags.get(bag).isEmpty()) {
            return false;
        }
        else if (bags.get(bag).containsKey("shiny gold")) {
            return true;
        }
        else {
            boolean isContain = false;
            for (String innerBag : bags.get(bag).keySet()) {
                isContain = isCurrentBagContainShinyGoldBag(bags, innerBag);
                if (isContain)
                    break;
            }
            return isContain;
        }
    }

    static int getCountBagColors(String input) {
        Map<String, Map<String, Integer>> bags = getMapOfBags(input);
        int count = 0;
        for (Map.Entry<String, Map<String, Integer>> entry : bags.entrySet()) {
            if (isCurrentBagContainShinyGoldBag(bags, entry.getKey()))
                count++;
        }
        return count;
    }

    static int getCountBagsInsideBag(Map<String, Map<String, Integer>> bags,
                                     String bag) {
        if (bags.get(bag) == null || bags.get(bag).isEmpty()) {
            return 0;
        }
        else {
            int count = 0;
            for (Map.Entry<String, Integer> entry : bags.get(bag).entrySet()) {
                count += entry.getValue() * (1 + getCountBagsInsideBag(bags, entry.getKey()));
            }
            return count;
        }
    }

    public static void main(String[] args) throws IOException {
        String filename = "src/org/goddriver/adventofcode2020/day7/input";
        String puzzleInput = Files.readString(Path.of(filename));
        //Part One
        System.out.println(getCountBagColors(puzzleInput) + " bag colors contain at least one shiny gold bag");
        //Part Two
        System.out.println(getCountBagsInsideBag(getMapOfBags(puzzleInput), "shiny gold")
                + " individual bags inside single shiny gold bag");
    }
}
