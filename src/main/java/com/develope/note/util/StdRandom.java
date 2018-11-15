package com.develope.note.util;

import java.util.Random;

public class StdRandom {

    private static Random random;
    private static long seed;

    static {
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    private StdRandom(){}

    public static double uniform(){
        return random.nextDouble();
    }
}
