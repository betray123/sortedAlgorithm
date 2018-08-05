package com.zk.day02;

/**
 * Created by zk on 18/8/5.
 */
public class SimpleSelectSort2 {
    public static void main(String[] args) {
        int[] a = {26,81,12,54,92,76,20,37,19,48};
        SimpleSelectSort2 simpleSelectSort = new SimpleSelectSort2();
        System.out.println("---排序前---");
        simpleSelectSort.print(a);//排序前
        simpleSelectSort.sort(a);//进行排序
        System.out.println("---排序后---");
        simpleSelectSort.print(a);//排序后
    }

    private void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int k = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[k] > a[j]){
                    k = j;
                }
            }
            int tmp = 0;
            tmp = a[i];
            a[i] = a[k];
            a[k] = tmp;
        }
    }

    private void print(int[] a) {
        for (int i = 0; i < a.length-1; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
