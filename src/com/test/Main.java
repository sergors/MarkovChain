package com.test;

public class Main {

    private static double[][] matrix = MatrixService.probMatrix;
    private static int accuracy = 5;

    public static void main(String[] args) {
        MatrixService matrixService = new MatrixService();
        MatrixService.showMatrix("original Matrix", matrix, accuracy);
        double[][] sqrMatrix = matrixService.multiplyMatrix(matrix, matrix, 4);
        MatrixService.showMatrix("result matrix", sqrMatrix, accuracy);
    }
}
