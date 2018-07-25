package com.zk.day01;

/**
 * Created by zk on 18/7/25.
 */
public class SimpleSelectSort1 {
    public static void main(String[] args) {
        int[] a = {26,81,12,54,92,76,20,37,19,48};
        SimpleSelectSort1 simpleSelectSort = new SimpleSelectSort1();
        System.out.println("---排序前---");
        simpleSelectSort.print(a);//排序前
        simpleSelectSort.sort(a);//进行排序
        System.out.println();
        System.out.println("---排序后---");
        simpleSelectSort.print(a);//排序后
    }

    private void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int tmp = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[tmp] > a[j]){
                    tmp = j;
                }
            }
            swap(a,i,tmp);
        }
    }

    private void swap(int[] a, int i, int tmp) {
        int k = 0;
        k = a[i];
        a[i] = a[tmp];
        a[tmp] = k;
    }

    private void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
