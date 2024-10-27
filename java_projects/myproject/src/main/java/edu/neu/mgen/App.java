package edu.neu.mgen;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {   
        // System.out.println( "It is my first Java program" );
        // This is a single-line comment in Java.
        // Declare and initialize variables
        int intVar1 = 10;
        int intVar2 = 20;

        long longVar1 = 100L;
        long longVar2 = 200L;

        double doubleVar1 = 10.5;
        double doubleVar2 = 20.5;

        boolean boolVar1 = true;
        boolean boolVar2 = false;

        char charVar1 = 'A';
        char charVar2 = 'B';

        // Convert initialized variables of type "int" to "long"
        long convertedLong1 = intVar1; // Implicit conversion
        long convertedLong2 = intVar2; // Implicit conversion
        System.out.println("Converted intVar1 (" + intVar1 + ") to long: " + convertedLong1 + " (Type: " + ((Object)convertedLong1).getClass().getSimpleName() + ")");
        System.out.println("Converted intVar2 (" + intVar2 + ") to long: " + convertedLong2 + " (Type: " + ((Object)convertedLong2).getClass().getSimpleName() + ")");


        // Convert initialized variables of type "long" to "int"
        int convertedInt1 = (int) longVar1; // Explicit conversion
        int convertedInt2 = (int) longVar2; // Explicit conversion
        System.out.println("Converted longVar1 (" + longVar1 + ") to int: " + convertedInt1 + " (Type: " + ((Object)convertedInt1).getClass().getSimpleName() + ")");
        System.out.println("Converted longVar2 (" + longVar2 + ") to int: " + convertedInt2 + " (Type: " + ((Object)convertedInt2).getClass().getSimpleName() + ")");

        // Enter values for variables from the terminal
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter an integer value: ");
        int userInt = scanner.nextInt();

        System.out.print("Enter a long value: ");
        long userLong = scanner.nextLong();

        System.out.print("Enter a double value: ");
        double userDouble = scanner.nextDouble();

        System.out.print("Enter a boolean value (true/false): ");
        boolean userBoolean = scanner.nextBoolean();

        System.out.print("Enter a character value: ");
        char userChar = scanner.next().charAt(0);

        // Perform arithmetic operations
        System.out.println("\n--- Arithmetic Operations ---");
        System.out.println("Addition of int variables: " + (intVar1 + intVar2));
        System.out.println("Subtraction of double variables: " + (doubleVar1 - doubleVar2));
        System.out.println("Multiplication of converted long and double: " + (convertedLong1 * doubleVar1));
        System.out.println("Division of int and double: " + (intVar1 / doubleVar1));

        // Perform logical operations
        System.out.println("\n--- Logical Operations ---");
        System.out.println("Logical AND of boolean variables: " + (boolVar1 && boolVar2));
        System.out.println("Logical OR of boolean variables: " + (boolVar1 || boolVar2));
        System.out.println("Negation of user boolean: " + (!userBoolean));

        // Display user inputs
        System.out.println("\n--- User Inputs ---");
        System.out.println("User Entered Integer: " + userInt + " (Type: " + ((Object)userInt).getClass().getSimpleName() + ")");
        System.out.println("User Entered Long: " + userLong + " (Type: " + ((Object)userLong).getClass().getSimpleName() + ")");
        System.out.println("User Entered Double: " + userDouble + " (Type: " + ((Object)userDouble).getClass().getSimpleName() + ")");
        System.out.println("User Entered Boolean: " + userBoolean + " (Type: " + ((Object)userBoolean).getClass().getSimpleName() + ")");
        System.out.println("User Entered Character: " + userChar + " (Type: " + ((Object)userChar).getClass().getSimpleName() + ")");

        // Close the scanner
        scanner.close();
    }
}
/*
 This is a multi-line comment in Java.
 It can span multiple lines.
 Use this for longer explanations or block comments.
*/
