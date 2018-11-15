package com.develope.note.algorithms.sort;

import static com.develope.note.algorithms.sort.Sort.*;

/**
 * 希尔排序
 * 将数组中任意间隔为h的元素变为有序，这样的数组被称为h有序数组。在排序时，如果h很大，我们就能将元素移动到很远的地方，为实现更小的h有序创造方便。
 *
 * 递增序列：下面的h对应的序列叫做递增序列(1, 4, 13, 40, 121, 364, 1093,....)。如何选择递增序列？
 */
public class ShellSort {

    public static void sort(Comparable[] a){
        int len = a.length;
        int h = 1;
        while (h < len / 3){
            h = h * 3 + 1;
        }
        while (h >= 1){
            // 将数组变为h有序
            for (int i = h; i < len; i++){
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h){
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Integer[] a = {11, 12, 13, 10, 9, 7, 6, 4, 40, 78};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
