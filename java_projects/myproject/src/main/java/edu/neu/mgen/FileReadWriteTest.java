package edu.neu.mgen;

import java.io.*;
import java.util.Scanner;

public class FileReadWriteTest {
    public static void main(String[] args) {
        // Define the file name
        String fileName = "my_test_file.txt";
        Scanner scanner = new Scanner(System.in);

        // Step 1: Read the file and print its content
        try {
            System.out.println("Reading content from the file:");
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);   
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        // Step 2: Ask the user for new input
        System.out.println("\nEnter the new phrase to write to the file:");
        String newPhrase = scanner.nextLine();

        // Step 3: Write the new content to the file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true)); 
            writer.write(newPhrase);
            writer.newLine(); // Add a new line after the new phrase
            writer.close();
            System.out.println("New phrase saved to the file.");
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }

        // Step 4: Open the file in Notepad
        try {
            System.out.println("Opening the file in the default text editor...");
            ProcessBuilder pb = new ProcessBuilder("open", fileName); // macOS 使用 "open" 命令
            pb.start();
        } catch (IOException e) {
            System.out.println("Error opening file: " + e.getMessage());
        }

        scanner.close();
    }
}
