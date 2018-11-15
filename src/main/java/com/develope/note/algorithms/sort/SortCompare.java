package com.develope.note.algorithms.sort;


import com.develope.note.util.StdRandom;
import com.develope.note.util.Stopwatch;
import com.sun.scenario.effect.Merge;

public class SortCompare {

    public static double time(String alg, Double[]a){
        Stopwatch stopWatch = new Stopwatch();
        if ("Insertion".equals(alg)){
            InsertionSort.sort(a);
        }else if ("Selection".equals(alg)){
            SelectionSort.sort(a);
        }else if ("Shell".equals(alg)){
            ShellSort.sort(a);
        }else if ("Merge".equals(alg)){
            MergeSort.sort(a);
        }
        return stopWatch.elapsedTime();
    }

    /**
     *
     * @param alg 排序方法名
     * @param len 测试数组长度
     * @param times  测试次数
     * @return
     */
    public static double timeRandomInput(String alg, int len, int times){
        double total = 0.0;
        Double[] a = new Double[len];
        for (int i = 0; i < times; i++){
            for (int j = 0; j < len; j++){
                a[j] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String insertion = "Insertion";
        String selection = "Selection";
        String shell = "Shell";
        String merge = "Merge";
        int len = 1000;
        int times = 1000;
        double t1 = timeRandomInput(insertion, len, times);
        double t2 = timeRandomInput(selection, len, times);
        double t3 = timeRandomInput(shell, len, times);
        double t4 = timeRandomInput(merge, len, times);
        System.out.printf("插入排序算法测试%d个数据%d次耗时%s秒", len, times, t1);
        System.out.println();
        System.out.printf("选择排序算法测试%d个数据%d次耗时%s秒", len, times, t2);
        System.out.println();
        System.out.printf("希尔排序算法测试%d个数据%d次耗时%s秒", len, times, t3);
        System.out.println();
        System.out.printf("归并排序算法测试%d个数据%d次耗时%s秒", len, times, t4);
    }
}
