// Part 1 and 2 Complete!
// https://adventofcode.com/2022/day/2
// This parses two chars from a line in a text file and calculates a score based on the chars.

package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2 {
    public static void main(String[] args) {
        System.out.println("---------------");
        part1();
        System.out.println();
        part2();
        System.out.println("---------------");
    }
    
    private static void part1() {
        // prints the score of each round from given opponent moves and my moves
        System.out.println("Part 1");
        try {
            File input = new File("day2\\input.txt");
            Scanner myReader = new Scanner(input);
            int score = 0; // score for this round
            int totalScore = 0; // sum of all rounds' score

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] moves = data.split(" ");
                char oppMove = moves[0].charAt(0); // the opponent's move; A for Rock, B for Paper, or C for Scissors
                char myMove = moves[1].charAt(0); // my move; X for Rock, Y for Paper, or Z for Scissors

                score = calcScore(oppMove, myMove);
                totalScore += score;
                // System.out.println("Opponent's move: " + oppMove);
                // System.out.println("My move: " + myMove);
                // System.out.println("Score for this round is " + score);

            }
            System.out.println("Total score is " + totalScore);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    private static void part2() {
        // print the score from the input of opponent moves and intended result of each round
        System.out.println("Part 2");
        try {
            File input = new File("day2\\input.txt");
            Scanner myReader = new Scanner(input);
            int score = 0;
            int totalScore = 0;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] moves = data.split(" ");
                char oppMove = moves[0].charAt(0); // the opponent's move; A for Rock, B for Paper, or C for Scissors
                char result = moves[1].charAt(0); // X for lose, Y for tie, Z for win

                char myMove = calcMyMove(oppMove, result);
                score = calcScore(oppMove, myMove);
                totalScore += score;
                // System.out.println("Opponent's move: " + oppMove);
                // System.out.println("My move: " + myMove);
                // System.out.println("Score for this round is " + score);
                // System.out.println();

            }
            System.out.println("Total score is " + totalScore);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    private static int calcScore(char oppMove, char myMove) {
        int score = 0;
        if (myMove == 'X') { // rock
            score += 1; // as per prompt, 1 point for throwing rock

            if (oppMove == 'A') { // rock vs rock, you tie
                score += 3;
            } else if (oppMove == 'C') { // scissors vs rock, you win
                score += 6;
            }
        } else if (myMove == 'Y') { // paper
            score += 2; // as per prompt, 2 points for throwing paper

            if (oppMove == 'A') { // rock vs paper, you win
                score += 6;
            } else if (oppMove == 'B') { // paper vs paper, you tie
                score += 3;
            }
        } else if (myMove == 'Z') { // scissors
            score += 3; // as per prompt, 3 points for throwing scissors

            if (oppMove == 'B') { // paper vs scissors, you win
                score += 6;
            } else if (oppMove == 'C') { // scissors vs scissors, you tie
                score += 3;
            }
        }

        return score;
    }

    private static char calcMyMove(char oppMove, char result) {
        if (result == 'Y') { // tie
            // plays the same move
            if (oppMove == 'A') {
                return 'X';
            } else if (oppMove == 'B') {
                return 'Y';
            } else if (oppMove == 'C') {
                return 'Z';
            }
        } 
        else if (result == 'X') { // lose
            if (oppMove == 'A') {
                return 'Z'; // to lose to rock, play scissors
            } else if (oppMove == 'B') {
                return 'X'; // to lose to paper, play rock
            } else if (oppMove == 'C') {
                return 'Y'; // to lose to scissors, play paper
            }
        }
        else if (result == 'Z') { // win
            if (oppMove == 'A') {
                return 'Y'; // to win against rock, play paper
            } else if (oppMove == 'B') {
                return 'Z'; // to win against paper, play scissors
            } else if (oppMove == 'C') {
                return 'X'; // to win against scissors, play rock
            }
        }
        
        return ' '; // a placeholder, because the if statement above will trigger a separate return.
    }
}
