package com.test;

import java.util.Random;

public class Experiment {

    private static Random rand = new Random();

    public static int makeNewStep(double[] vector) {
        double randValue = (double) rand.nextInt(100) / 100;
        for (int i = 0; i < vector.length; i++) {
            randValue -= vector[i];
            if (randValue < 0) {
                return i;
            }
        }
        throw new IllegalArgumentException("Error! Rand value not between vector values");
    }
}
