package com.develope.note.algorithms.sort;

public class Sort {

    /**
     * 对元素进行比较
     * v < w、v = w、v > w分别对应v.compareTo(w)中的负整数、零、正整数(通常是-1、0、1)
     * @param a
     * @param b
     * @return
     */
    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    /**
     * 对元素进行交换位置
     * @param a
     * @param i
     * @param j
     */
    public static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++){
            if (less(a[i], a[i - 1])){
                return false;
            }
        }
        return true;
    }
}
