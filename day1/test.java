// where I test out how file creation, input, and output works
package day1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class test {
    public static void main(String[] args) {

        System.out.println("-----------------");
        String fileName = "notepadTest";
        createFile(fileName);
        writeToFile(fileName);


        System.out.println("-----------------");

    }
    // createFile and writeToFile taken from https://www.w3schools.com/java/java_files_create.asp
    private static void createFile(String fileName) {
        try {
            File myObj = new File("day1\\" + fileName + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }

    private static void writeToFile(String fileName) {
        try {
            FileWriter myWriter = new FileWriter("day1\\" + fileName + ".txt");
            myWriter.write("what happens if i rewrite?");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } 
        catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }
}
