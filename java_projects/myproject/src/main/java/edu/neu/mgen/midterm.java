package edu.neu.mgen;

public class midterm {
    int[][] A = {{10, 20, 30}, {40, 50, 60}};

    // using for loop to calculate the sum of the elements in the matrix
    public int sumMatrix(int[][] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                sum += A[i][j];
            }
        }
        return sum;
    }

    //output the sum of the elements in the matrix
    public static void main(String[] args) {
        midterm obj = new midterm();
        int sum = obj.sumMatrix(obj.A);
        System.out.println("The sum of the elements in the matrix is: " + sum);
    }
}
