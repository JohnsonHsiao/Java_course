package edu.neu.mgen;

import java.util.Scanner;

public class HW11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        System.out.println("Welcome to the Safe Input Program!");

        while (!validInput) {
            System.out.print("Please enter a number: ");
            try {
                int number = scanner.nextInt(); // May throw an InputMismatchException
                System.out.println("You entered: " + number);
                validInput = true; // Exit the loop if input is valid
            } catch (Exception e) {
                System.out.println("Error: Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input from the scanner
            }
        }

        System.out.println("Thank you for using the program!");
        scanner.close();
    }
}

