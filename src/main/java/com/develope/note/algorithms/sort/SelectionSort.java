package com.develope.note.algorithms.sort;

import static com.develope.note.algorithms.sort.Sort.*;

/**
 * 选择排序（大约需要N*N/2次比较）
 * 找到数组元素中最小的元素，其次将它和数组的第一个元素交换位置；然后在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置；如此往复。
 *
 * 特点：
 * 1.运行时间与输入无关。找出最小元素而扫描一遍数据并不能为下一遍扫描提供什么有用的信息，我们会惊讶的发现一个已经有序或是主键全部相等的数组和一个随机排列的数组所用的时间竟然一样长。
 * 2.数据移动是最少的。每次交换都会改变两个元素的值，因此选择排序用了N次交换(交换次数和数组的大小是线性关系)
 */
public class SelectionSort {


    /**
     * 升序排列
     * @param a
     */
    public static void sort(Comparable[] a){
        int len = a.length;
        for (int i = 0; i < len; i++){
            int min = i;
            for (int j = i + 1; j < len; j++){
                if (less(a[j], a[min])){
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        Integer[] a = {11, 12, 13, 10, 9, 7, 6, 4, 40, 78};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
