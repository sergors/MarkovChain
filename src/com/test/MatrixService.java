package com.test;

public class MatrixService {

    static double[][] probMatrix = {
            {0.21, 0.17, 0.01, 0.28, 0.33},
            {0, 0.46, 0, 0.54, 0},
            {0.42, 0.3, 0.03, 0.16, 0.09},
            {0, 0.39, 0, 0.33, 0.28},
            {0.36, 0, 0, 0.18, 0.46}
    };


    public double[][] multiplyMatrix(double[][] matrix,
                                     double[][] originalMatrix,
                                     int pow) {
        if (pow < 1) {
            System.out.println("Invalid power value!");
            return null;
        } else if (pow == 1) {
            return matrix;
        } else {
            return multiplyMatrix(squareMatrix(matrix, originalMatrix), originalMatrix, --pow);
        }
    }

    private double[][] squareMatrix(double[][] matrix,
                                    double[][] originalMatrix) {
        int len = matrix.length;
        double rowBuf = 0;
        double[][] result = new double[len][];
        for (int i = 0; i < len; i++) {
            result[i] = new double[len];
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    rowBuf += matrix[i][k] * originalMatrix[k][j];
                }
                result[i][j] = rowBuf;
                rowBuf = 0;
            }
        }
        return result;
    }

    public static void showMatrix(String description,
                                  double[][] matrix,
                                  int accuracy) {
        if (matrix == null) {
            System.out.println("Error! Matrix is null!");
            return;
        }

        System.out.println(description);
        for (double[] rows : matrix) {
            for (double element : rows) {
                System.out.format("%1." + accuracy + "f ", element);
            }
            System.out.println();
        }
    }
}
