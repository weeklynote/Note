package com.develope.note.algorithms.sort;

import static com.develope.note.algorithms.sort.Sort.*;

/**
 *插入排序
 * 当前索引左边的所有元素都是有序的，但是他们的最终位置还不确定，为了给最小的元素腾出空间，它们可能会被移动。当索引到达数组的右端时，数组排序完成。
 *
 */
public class InsertionSort {

    /**
     * 升序排列
     * @param a
     */
    public static void sort(Comparable[] a){
        int len = a.length;
        for (int i = 1; i < len; i++){
            // 使i左边的数据始终有序
            for (int j = i; j > 0; j--){
                if (less(a[j], a[j - 1])){
                    exch(a, j, j - 1);
                }else {
                    // 说明第j个元素比i左边的最大元素还大，不需要做排序
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {11, 12, 13, 10, 9, 7, 6, 4, 40, 78};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
