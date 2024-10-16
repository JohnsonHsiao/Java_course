package edu.neu.mgen;

import java.util.ArrayList;

public class HW5 {
    public static void main(String[] args) {
        // 1)
        System.out.println("String Operations:");
        String str = "Oakland";

        // find the length of the string
        int length = str.length();
        System.out.println ("Length of the string(" + str + "):" + length);

        // find a character with index 2 in the string.
        char charAtIndex2 = str.charAt(2);
        System.out.println("Character at index 2 of " + str + ": " + charAtIndex2); // Output: k

        // extract a substring “land” from str
        String substring = str.substring(3, 7); // "land"
        System.out.println("Substring 'land': " + substring);

        // convert all letters in str to capital letters “OAKLAND”.
        String upperCaseStr = str.toUpperCase(); // "OAKLAND"
        System.out.println("String in uppercase of " + str + ": " + upperCaseStr);

        System.out.println(); // New line for qesutuion 2

        // 2) int[] abc = {1, 3, 5, 2, 5}
        System.out.println("Array Operations:");
        int[] abc = {1, 3, 5, 2, 5};

        // find the length of the array
        int arrayLength = abc.length;
        System.out.println("Length of the array: " + arrayLength);

        // find the last member of the array.
        int lastMember = abc[abc.length - 1]; // abc.length = 5, last index = 4
        System.out.println("Last member of the array: " + lastMember); // Output: 5

        System.out.println(); // New line for qesutuion 3

        // 3) 
        System.out.println("ArrayList Operations:");
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Austin");
        cities.add("Houston");
        cities.add("Oakland");
        cities.add("Paris");
        cities.add("San Francisco");
        cities.add("Seattle");

        // Removing "Paris" from the ArrayList
        cities.remove("Paris");

        // Printing the ArrayList after removal
        System.out.println("ArrayList after removing 'Paris': " + cities);
    }
}
