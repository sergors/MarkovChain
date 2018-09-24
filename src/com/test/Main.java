package com.test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static double[][] matrix = MatrixService.probMatrix;


    public static void main(String[] args) {
        MatrixService matrixService = new MatrixService();
        MatrixService.showMatrix("original Matrix", matrix, 2);

        double[] result = new double[5];
        Scanner scanner = new Scanner(System.in);
        do {
            for (double in : result) {
                in = 0;
            }
            System.out.println("Введите количество итераций эксперимента:");
            int experiments = scanner.nextInt();
            System.out.println("Введите количество шагов в эксперименте:");
            int steps = scanner.nextInt();

            System.out.println("Введите номер начальной точки[0 - 4]");
            int indexStart = scanner.nextInt();

            for (int i = 0; i < experiments; i++) {
                int index = indexStart;
                for (int j = 0; j < steps; j++) {
                    index = Experiment.makeNewStep(matrix[index]);
                }
                result[index]++;
            }
            for (int i = 0; i < result.length; i++) {
                result[i] /= experiments;
            }
            System.out.println("\nРезультат эксперимента:");
            Arrays.stream(result).forEach(f -> System.out.format("%1.4f ", f));

            double[][] mathMatrix = matrixService.multiplyMatrix(matrix, matrix, steps);
            System.out.println("\nРезультат вычислений:");
            Arrays.stream(mathMatrix[indexStart]).forEach(f -> System.out.format("%1.4f ", f));
            System.out.println("\nХотите продолжить? (y|n)");
        } while ("y".equals(scanner.next()));
    }
}
