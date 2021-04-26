package org.goddriver.adventofcode2020.day8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Solution {

    private static ArrayList<String> getListOfInstructions(String instructions) {
        Scanner scanner = new Scanner(instructions);
        ArrayList<String> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        scanner.close();
        return list;
    }

    private static Map<Boolean, Integer> getNextInstruction(ArrayList<String> list,
                                                            ArrayList<Integer> indexes,
                                                            int acc,
                                                            int index) {
        if (indexes.contains(index))
            return Collections.singletonMap(false, acc);
        if (index > list.size())
            return Collections.singletonMap(true, Integer.MIN_VALUE);
        if (index == list.size())
            return Collections.singletonMap(true, acc);
        else {
            indexes.add(index);
            if (list.get(index).startsWith("nop")) {
                index++;
            } else if (list.get(index).startsWith("acc")) {
                acc += Integer.parseInt(list.get(index++).substring(4));
            } else {
                index += Integer.parseInt(list.get(index).substring(4));
            }
            return getNextInstruction(list, indexes, acc, index);
        }
    }

    static int getValue(String instructions) {
        return getNextInstruction(getListOfInstructions(instructions), new ArrayList<>(), 0, 0).get(false);
    }

    static int getValueAfterTerminate(String instructions) {
        int acc = Integer.MIN_VALUE;
        for (int i = 0; i < instructions.split("\n").length; i++) {
            ArrayList<String> listOfInstructions = getListOfInstructions(instructions);
            if (listOfInstructions.get(i).startsWith("nop")) {
                listOfInstructions.add(i, "jmp" + listOfInstructions.get(i).substring(3));
                listOfInstructions.remove(i + 1);
            }
            else if (listOfInstructions.get(i).startsWith("jmp")) {
                listOfInstructions.add(i, "nop" + listOfInstructions.get(i).substring(3));
                listOfInstructions.remove(i + 1);
            }
            if (getNextInstruction(listOfInstructions, new ArrayList<>(), 0, 0).containsKey(true) &&
                    getNextInstruction(listOfInstructions, new ArrayList<>(), 0, 0).get(true) > acc)
                acc = getNextInstruction(listOfInstructions, new ArrayList<>(), 0, 0).get(true);
        }
        return acc;
    }

    public static void main(String[] args) throws IOException {
        String filename = "src/org/goddriver/adventofcode2020/day8/input";
        String puzzleInput = Files.readString(Path.of(filename));
        // Part One
        System.out.println("Value in the accumulator is " + getValue(puzzleInput));
        //Part Two
        System.out.println("The value of the accumulator after the program terminates is "
                + getValueAfterTerminate(puzzleInput));
    }
}
