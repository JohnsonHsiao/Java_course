package edu.neu.mgen;

public class HW8 {

    public static void main(String[] args) {
        // First array
        String[] array1 = {"Anne", "John", "Alex", "Jessica"};
        System.out.println("Original array:");
        printArray(array1);
        
        String[] result1 = transformArray(array1);
        System.out.println("\nResultant array:");
        printArray(result1);

        // Second array
        String[] array2 = {"Sun", "Mercury", "Venis", "Earth", "Mars", "Jupiter"};
        System.out.println("\nOriginal array:");
        printArray(array2);
        
        String[] result2 = transformArray(array2);
        System.out.println("\nResultant array:");
        printArray(result2);
    }

    // Method to transform the input array
    public static String[] transformArray(String[] input) {
        String[] result = new String[input.length];

        for (int i = 0; i < input.length; i++) {
            // Reverse the string
            String reversed = new StringBuilder(input[i]).reverse().toString();
            // Capitalize the first letter and make other letters lower case
            result[i] = Character.toUpperCase(reversed.charAt(0)) + reversed.substring(1).toLowerCase();
        }
        
        return result;
    }

    // Method to print the array
    public static void printArray(String[] array) {
        for (String str : array) {
            System.out.println("\"" + str + "\",");
        }
        System.out.println("End of the array");
    }
}

