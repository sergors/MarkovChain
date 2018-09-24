package com.test;

import java.util.Arrays;

public class Main {

    private static double[][] matrix = MatrixService.probMatrix;
    private static int accuracy = 5;

    public static void main(String[] args) {
        /*MatrixService matrixService = new MatrixService();
        MatrixService.showMatrix("original Matrix", matrix, accuracy);
        double[][] sqrMatrix = matrixService.multiplyMatrix(matrix, matrix, 4);
        MatrixService.showMatrix("result matrix", sqrMatrix, accuracy);*/

        double[] results = new double[]{0, 0, 0, 0, 0};
        double[] vector = new double[]{0.08, 0.12, 0.62, 0, 0.18};

        for (int i = 0; i < 100_000_000; i++) {
            int value = Experiment.makeNewStep(vector);
            results[value]++;
        }
        double[] array = Arrays.stream(results).map(result -> result / 100_000_000).toArray();
        Arrays.stream(array).forEach(System.out::println);
    }
}
