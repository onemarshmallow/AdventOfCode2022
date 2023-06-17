// This breaks apart a line in a text file into two pairs of ints which are used to mark the boundaries
// of imaginary "assignments" of sections. These bounds are checked for whether the assignments 
// completely contain each other (part 1) or whether the assignments overlap (part 2).
// Part 1 and 2 Complete!
// https://adventofcode.com/2022/day/4

package day4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day4 {
    public static void main(String[] args) {
        System.out.println("-------------");
        part1();
        System.out.println();
        part2();
        System.out.println("-------------");
    }

    private static void part1() {
        // counts completely contained pairs
        System.out.println("Part 1");
        try {
            File input = new File("day4\\input.txt");
            Scanner myReader = new Scanner(input);
            int containedPairsCount = 0;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                // special note about split: https://stackoverflow.com/questions/3481828/how-do-i-split-a-string-in-java
                String[] pair = data.split(","); // example: ["2-4", "6-8"]
                String[] section1 = pair[0].split("-"); // example: ["2", "4"]
                String[] section2 = pair[1].split("-"); // example: ["6", "8"]
                int[] sect1 = new int[2];
                int[] sect2 = new int[2];
                for (int i = 0; i < section1.length; i++) {
                    // turns string[] into int[]
                    sect1[i] = Integer.valueOf(section1[i]);
                    sect2[i] = Integer.valueOf(section2[i]);
                }

                containedPairsCount += countContained(sect1[0], sect1[1], sect2[0], sect2[1]);
                // System.out.println("section1: " + section1[0] + ", " + section1[1]);
                // System.out.println("section2: " + section2[0] + ", " + section2[1]);
                // System.out.println("sect1: " + sect1[0] + ", " + sect1[1]);
                // System.out.println("sect2: " + sect2[0] + ", " + sect2[1]);
                // System.out.println();
            }

            System.out.println("There are " + containedPairsCount + " fully contained assignment pairs.");
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error has occured.");
            e.printStackTrace();
        }
    }

    private static void part2() {
        // counts overlapping assignment pairs
        System.out.println("Part 2");
        try {
            File input = new File("day4\\input.txt");
            Scanner myReader = new Scanner(input);
            int overlappingPairsCount = 0;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                // special note about split: https://stackoverflow.com/questions/3481828/how-do-i-split-a-string-in-java
                // splits line based on the comma 
                String[] pair = data.split(","); // example: ["2-4", "6-8"]
                // removes hyphen and separates the two numbers
                String[] section1 = pair[0].split("-"); // example: ["2", "4"]
                String[] section2 = pair[1].split("-"); // example: ["6", "8"]
                // these two below vars are used to store the String[] section1 and section2 as int[]
                int[] sect1 = new int[2];
                int[] sect2 = new int[2];
                for (int i = 0; i < section1.length; i++) {
                    // turns string[] into int[]
                    sect1[i] = Integer.valueOf(section1[i]);
                    sect2[i] = Integer.valueOf(section2[i]);
                }

                overlappingPairsCount += countOverlapping(sect1[0], sect1[1], sect2[0], sect2[1]);
                // System.out.println("section1: " + section1[0] + ", " + section1[1]);
                // System.out.println("section2: " + section2[0] + ", " + section2[1]);
                // System.out.println("sect1: " + sect1[0] + ", " + sect1[1]);
                // System.out.println("sect2: " + sect2[0] + ", " + sect2[1]);
                // System.out.println();
            }

            System.out.println("There are " + overlappingPairsCount + " overlapping assignment pairs.");
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error has occured.");
            e.printStackTrace();
        }
    }

    private static int countContained(int sect1_lowerBound, int sect1_upperBound, int sect2_lowerBound,
            int sect2_upperBound) {
        int counter = 0;
        // checks if sect1 is within the bounds of sect2
        if (sect1_upperBound - sect2_upperBound <= 0 && sect1_lowerBound - sect2_lowerBound >= 0) {
            counter++;
        }
        // checks if sect2 is within the bounds of sect1
        else if (sect2_upperBound - sect1_upperBound <= 0 && sect2_lowerBound - sect1_lowerBound >= 0) {
            counter++;
        }
        return counter;
    }

    private static int countOverlapping(int sect1_lb, int sect1_ub, int sect2_lb, int sect2_ub) {
        // note for future: this function would work better with returning a boolean instead of int.
        // lb stands for lower bound; ub stands for upper bound

        int counter = 0;
        if ((sect1_ub - sect2_lb >= 0) && (sect2_ub - sect1_lb >= 0)) {
            counter++;
        }
        return counter;
    }

}
