package org.goddriver.adventofcode2020.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    private static ArrayList<String[]> getList(String input) {
        ArrayList<String[]> list = new ArrayList<>();
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine().replace(":", "")
                                       .replaceAll("[ -]",",")
                                       .split(","));
        }
        scanner.close();
        return list;
    }

    static int getCountValidPasswords(String input) {
        ArrayList<String[]> list = getList(input);
        return list.stream()
                   .filter(p ->
                           p[3].chars().filter(ch ->
                                   ch == p[2].charAt(0)).count() >= Integer.parseInt(p[0]))
                   .filter(p ->
                           p[3].chars().filter(ch ->
                                   ch == p[2].charAt(0)).count() <= Integer.parseInt(p[1]))
                   .toArray().length;
    }

    static int getCountValidPasswordsNewPolicies(String input) {
        ArrayList<String[]> list = getList(input);
        return list.stream()
                   .filter(p ->
                           (p[3].charAt(Integer.parseInt(p[0]) - 1) == p[2].charAt(0))
                                   ^ p[3].charAt(Integer.parseInt(p[1]) - 1) == p[2].charAt(0))
                   .toArray().length;
    }

    public static void main(String[] args) throws IOException {
        String filename = "src/org/goddriver/adventofcode2020/day2/input";
        String puzzleInput = Files.readString(Path.of(filename));
        System.out.println(getCountValidPasswords(puzzleInput)
                + " passwords are valid");
        System.out.println(getCountValidPasswordsNewPolicies(puzzleInput)
                + " passwords are valid according to the new interpretation of the policies");
    }
}
