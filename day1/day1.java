// This calculates the sum of each block of numbers from a text file and finds the top 3 highest sums.
// Part 1 & 2 Completed!
// https://adventofcode.com/2022/day/1
// I used this for reference: https://www.w3schools.com/java/java_files_read.asp

package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class day1 {
    public static void main(String[] args) {
        System.out.println("-------------");
        part1();
        part2();
        System.out.println("-------------");
    }

    private static void part1() {
        // sums up each group of numbers separated by blank lines, then finds the max
        try {
            File input = new File("day1\\input.txt"); // you can change input.txt to sampleInput.txt to use the sample input for testing
            Scanner myReader = new Scanner(input);
            int maxCalories = 0; // the highest number of calories of all elves
            int elfCalories = 0; // the current number of calories that the elf has

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                if (data.equals("")) { // line is empty
                    // System.out.println("EMPTY LINE");
                    if (elfCalories > maxCalories) {
                        maxCalories = elfCalories;
                    }
                    elfCalories = 0; // reset for next elf
                } else {
                    // System.out.println(data);

                    elfCalories += Integer.parseInt(data); // converts data into int and adds to elfCalories

                }
            }
            System.out.println("The highest calories an elf is carring is " + maxCalories + " calories.");
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error has occured.");
            e.printStackTrace();
        }
    }

    private static void part2() {
        // sums up each group of numbers separated by blank lines, then finds the top 3 max
        try {
            File input = new File("day1\\input.txt");
            Scanner myReader = new Scanner(input);
            int first = 0; // the highest number of calories of all elves
            int second = 0; // second highest
            int third = 0; // third highest
            int elfCalories = 0; // the current number of calories that the elf has

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                if (data.equals("")) { // line is empty
                    if (elfCalories > first) {
                        // moves the calories down
                        third = second;
                        second = first;
                        first = elfCalories;
                    } else if (elfCalories > second) {
                        // moves the calories down
                        third = second;
                        second = elfCalories;
                    } else if (elfCalories > third) {
                        third = elfCalories;
                    }
                    elfCalories = 0; // reset for next elf
                } else {

                    elfCalories += Integer.parseInt(data); // converts data into int and adds to elfCalories

                }

            }
            // this is copied from the while loop, so that it runs one more time after the 
            // last line of the input is processed.
            if (elfCalories > first) {
                // moves the calories down
                third = second;
                second = first;
                first = elfCalories;
            } else if (elfCalories > second) {
                // moves the calories down
                third = second;
                second = elfCalories;
            } else if (elfCalories > third) {
                third = elfCalories;
            }
            elfCalories = 0; // reset for next elf
            System.out.println("The top 3 highest number of calories an elf is carrying is " + first + ", " + second + ", and " + third + " calories.");
            System.out.println("The sum of all 3 highest number of calories is " + (first + second + third) + ".");
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error has occured.");
            e.printStackTrace();
        }
    }
}
