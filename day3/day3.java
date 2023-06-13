package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day3 {
    public static void main(String[] args) {
        System.out.println("--------------");
        part1();
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
    
    private static char findCommonChar(String str1, String str2) {
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
