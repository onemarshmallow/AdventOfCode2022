// first parse the two values from input
// then check if i win and calculate score
package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2 {
    public static void main(String[] args) {
        System.out.println("---------------");
        part1();
        System.out.println("---------------");
    }
    
    private static void part1() {
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
}
