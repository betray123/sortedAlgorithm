package com.zk.day03;

public class BubbleSort03 {
    public static void main(String[] args) {
        int[] a = {26,81,12,54,92,76,20,37,19,48};
        BubbleSort03 bubbleSort = new BubbleSort03();
        System.out.println("---排序前---");
        bubbleSort.print(a);//排序前
        System.out.println();
        bubbleSort.sort(a);//进行排序
        System.out.println("---排序后---");
        bubbleSort.print(a);//排序后
    }

    private void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length-i-1; j++){
                if (a[j] > a[j+1]){
                    int tmp = 0;
                    tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
    }

    private void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
