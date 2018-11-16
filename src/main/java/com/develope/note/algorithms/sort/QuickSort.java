package com.develope.note.algorithms.sort;

import com.develope.note.util.StdRandom;

import static com.develope.note.algorithms.sort.Sort.*;

/**
 * 快速排序
 * 分治的排序算法。它将一个数组分成两个子数组，将两部分独立地排序，左边数组不大于一个定值，右边数组不小于一个定值。
 * 快速排序和归并排序是互补的，
 *
 * 切分后使得数组满足三个条件：
 * 1.对于某个j(切分的位置)，a[j]已经排定
 * 2.a[lo]到a[j-1]中的所有元素都不大于a[j]
 * 3.a[j+1]到a[hi]中的所有元素都不小于a[j]
 */
public class QuickSort {

    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static int partition(Comparable[] a, int lo, int hi){
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true){
            while (less(a[++i], v)){
                if (i == hi){
                    break;
                }
            }
            while (less(v, a[--j])){
                if (j == lo){
                    break;
                }
            }
            if (i >= j){
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static void sort(Comparable[] a, int lo, int hi){
        if (hi <= lo){
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static void main(String[] args) {
        Integer[] a = {11, 12, 13, 10, 9, 7, 6, 4, 40, 78};
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
