package org.goddriver.adventofcode2020.day5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    static int getRow(String seat) {
        return Integer.parseInt(
                seat
                        .substring(0, 7)
                        .replaceAll("F", "0")
                        .replaceAll("B", "1"),
                2);
    }

    static int getColumn(String seat) {
        return Integer.parseInt(
                seat
                        .substring(7, 10)
                        .replaceAll("L", "0")
                        .replaceAll("R", "1"),
                2);
    }

    static int getSeatID(String seat) {
        return getRow(seat) * 8 + getColumn(seat);
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "src/org/goddriver/adventofcode2020/day5/input";
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)));
        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            list.add(getSeatID(scanner.nextLine()));
        }
        //Part One
        System.out.println("The highest seat ID on a boarding pass is " + Collections.max(list));
        //Part Two
        Collections.sort(list);
        ArrayList<Integer> listFull = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listFull.add(list.get(0) + i);
        }
        listFull.removeAll(list);
        System.out.println("The ID of my seat is " + listFull.get(0));
    }
}
