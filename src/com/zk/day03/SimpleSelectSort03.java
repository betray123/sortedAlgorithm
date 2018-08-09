package com.zk.day03;

public class SimpleSelectSort03 {
    public static void main(String[] args) {
        int[] a = {26,81,12,54,92,76,20,37,19,48};
        SimpleSelectSort03 simpleSelectSort = new SimpleSelectSort03();
        System.out.println("---排序前---");
        simpleSelectSort.print(a);//排序前
        simpleSelectSort.sort(a);//进行排序
        System.out.println();
        System.out.println("---排序后---");
        simpleSelectSort.print(a);//排序后
    }

    private void sort(int[] a) {
        for (int i = 0; i <a.length; i++) {
            int k = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[k]){
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
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
