package com.zk.day03;

/**
 * Created by zk on 18/8/9.
 */
public class DirectInsertSort03 {
    public static void main(String[] args) {
        int[] a = {26,81,12,54,92,76,20,37,19,48};
        DirectInsertSort03 directInsertSort = new DirectInsertSort03();
        System.out.println("---排序前---");
        directInsertSort.print(a);//排序前
        directInsertSort.sort(a);//进行排序
        System.out.println("---排序后---");
        directInsertSort.print(a);//排序后
    }

    private void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j;
            int x = a[i];
            for (j = i; j > 0 && x < a[j-1]; j--) {
                a[j] = a[j-1];
            }
            a[j] = x;
        }
    }

    private void print(int[] a) {
        for (int i = 0; i < a.length-1; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
