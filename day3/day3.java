// This finds common characters in two strings,
// then utilizes the ASCII representation of chars to calculate a number.
// Part 1 and 2 Complete!
// https://adventofcode.com/2022/day/3

package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day3 {
    public static void main(String[] args) {
        System.out.println("--------------");
        part1();
        System.out.println();
        part2();
        System.out.println("--------------");
    }

    private static void part1() {
        System.out.println("Part 1");
        try {
            File input = new File("day3\\input.txt");
            Scanner myReader = new Scanner(input);
            int priority, sumPriority = 0;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                // splits str in half for each compartment
                String comp1 = data.substring(0, data.length() / 2);
                String comp2 = data.substring(data.length() / 2);

                char commonChar = findCommonChar(comp1, comp2);
                priority = convertCharToPriority(commonChar);
                sumPriority += priority;

                // System.out.println("comp 1: " + comp1);
                // System.out.println("comp 2: " + comp2);
                // System.out.println("common char is " + commonChar);
                // System.out.println("priority is " + priority);
            }

            System.out.println("Total priority is " + sumPriority);
        } catch (FileNotFoundException e) {
            System.out.println("An error has occured.");
            e.printStackTrace();
        }

    }

    private static void part2() {
        System.out.println("Part 2");
        try {
            File input = new File("day3\\input.txt");
            Scanner myReader = new Scanner(input);
            int priority, sumPriority = 0;

            while (myReader.hasNextLine()) {
                // gets the rucksack (rksk) contents of a group of 3 elves
                String rksk1 = myReader.nextLine();
                String rksk2 = myReader.nextLine();
                String rksk3 = myReader.nextLine();

                // gets the common char in all 3 strings
                String comm_chars1 = findCommonChars(rksk1, rksk2);
                String comm_chars2 = findCommonChars(rksk1, rksk3);
                char commonChar = findCommonChar(comm_chars1, comm_chars2); 
                
                priority = convertCharToPriority(commonChar);
                sumPriority += priority;

                // System.out.println("comm_chars1 = " + comm_chars1);
                // System.out.println("comm_chars2 = " + comm_chars2);
                // System.out.println("common char is " + commonChar);
                // System.out.println("priority is " + priority);
            }

            System.out.println("Total priority is " + sumPriority);
        } catch (FileNotFoundException e) {
            System.out.println("An error has occured.");
            e.printStackTrace();
        }
    }
    
    private static String findCommonChars(String str1, String str2) {
        // returns all common chars as a String
        String commonChars = "";
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (str2.indexOf(ch) > -1) {
                commonChars += ch;
            }
        }
        return commonChars;
    }

    private static char findCommonChar(String str1, String str2) {
        // returns the first common char 
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (str2.indexOf(ch) > -1) {
                return ch;
            }
        }
        return 0; // placeholder
    }


    private static int convertCharToPriority(char ch) {
        if (Character.isLowerCase(ch)) {
            return ch - 'a' + 1; // returns lowercase letters a-z as 1-26
        } else {
            return ch - 'A' + 27; // returns uppercase letters A-Z as 27-52
        }
    }
}
