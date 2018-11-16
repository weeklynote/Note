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

    public static int uniform(int n){
        if (n <= 0){
            throw new IllegalArgumentException("argument must be positive:" + n);
        }
        return random.nextInt(n);
    }

    public static long uniform(long n){
        if (n <= 0){
            throw new IllegalArgumentException("argument must be positive:" + n);
        }
        long r = random.nextLong();
        long m = n - 1;
        if ((n & m) == 0L){
            return r & m;
        }
        long u = r >>> 1;
        while (u + m - (r = u % n) < 0L){
            u = random.nextLong() >>> 1;
        }
        return r;
    }

    /**
     * 打乱数组的排列顺序
     * @param a
     */
    public static void shuffle(Comparable[] a){
        int len = a.length;
        for (int i = 0; i < len; i++){
            int r = i + uniform(len - i);
            Comparable temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

}
