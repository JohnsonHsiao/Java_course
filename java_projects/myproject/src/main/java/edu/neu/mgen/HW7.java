package edu.neu.mgen;


public class HW7 {
    public static void main(String[] args) {
        // Initialize matrices A and B
        int[][] A = {{2, 3, 4}, {3, 4, 5}};
        int[][] B = {{1, 2}, {3, 4}, {5, 6}};

        // Calculate the dimensions of the matrices
        int rowsA = A.length;
        int colsA = A[0].length; // number of columns in A
        int rowsB = B.length;
        int colsB = B[0].length; // number of columns in B

        // Check if multiplication is possible (colsA should equal rowsB)
        if (colsA != rowsB) {
            System.out.println("Matrices cannot be multiplied.");
            return;
        }

        // Initialize the result matrix with appropriate dimensions
        int[][] result = new int[rowsA][colsB];

        // Multiply the matrices using nested loops
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        // Output the result matrix
        System.out.println("The product of matrices A and B is:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println(); // New line for the next row
        }
    }
}

