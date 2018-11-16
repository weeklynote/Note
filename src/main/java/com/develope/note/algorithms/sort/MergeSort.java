package com.develope.note.algorithms.sort;

import static com.develope.note.algorithms.sort.Sort.isSorted;
import static com.develope.note.algorithms.sort.Sort.show;

/**
 * 归并排序
 * 将两个 有序的数组 归并成一个更大的有序数组。
 * 特点：
 * 1.对于任意长度为N的数组排序所需时间和NlogN成正比
 * 缺点：
 * 1.需要额外的空间和N成正比。
 *
 *
 */
public class MergeSort {

    private static void  merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++){
            if (i > mid){
                a[k] = aux[j++];
            }else if (j > hi){
                a[k] = aux[i++];
            }else if (Sort.less(aux[j], aux[i])){
                a[k] = aux[j++];
            }else {
                a[k] = aux[i++];
            }
        }
    }

    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if (hi <= lo){
            return;
        }
        int mid = (lo + hi) / 2;
        sort(a, aux, lo, mid);
        sort(a , aux,mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void main(String[] args) {
        Integer[] a = {11, 12, 13, 10, 9, 7, 6, 4, 40, 78};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
