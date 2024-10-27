package edu.neu.mgen;
import java.util.Scanner;

public class HW6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter any word: ");

        // Record the start time
        long startTime = System.currentTimeMillis();

        // Read the input word
        String word = scanner.nextLine();

        // Check if the word is empty
        if (word.isEmpty()) {
            System.out.println("You did not enter any word");
            scanner.close();
            return;
        }

        // Record the end time
        long endTime = System.currentTimeMillis();

        // Calculate the length of the word and reaction time
        int length = word.length();
        double reactionTime = (endTime - startTime) / 1000.0; // Convert to seconds

        // Classify the word length
        String classification;
        if (length <= 5) {
            classification = "short";
        } else if (length <= 10) {
            classification = "medium";
        } else {
            classification = "long";
        }

        // Output the results
        System.out.println("Your word is " + word);
        System.out.println("It is a " + classification + " word");
        System.out.println("The length of the word is " + length);
        System.out.printf("Your reaction time is %.2f seconds%n", reactionTime);

        // Close the scanner
        scanner.close();
    }
}
