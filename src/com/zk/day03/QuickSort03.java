package com.zk.day03;

/**
 * Created by zk on 18/8/9.
 */
public class QuickSort03 {
    public static void main(String[] args) {
        int[] a = {26,81,12,54,92,76,20,37,19,48};
        QuickSort03 quickSort = new QuickSort03();
        System.out.println("---排序前---");
        quickSort.print(a);//排序前
        System.out.println();
        quickSort.sort(a,0,a.length-1);//进行排序
        System.out.println("---排序后---");
        quickSort.print(a);//排序后
    }

    private void sort(int[] a, int low, int high) {
        if (low<high){
            int middle = getMiddle(a,low,high);
            sort(a,0,middle-1);
            sort(a,middle+1,high);
        }
    }

    private int getMiddle(int[] a, int low, int high) {
        int key = a[low];
        while (low<high){
            while (low<high && a[high] > key){
                high--;
            }
            a[low] = a[high];
            while (low < high && key > a[low]){
                low++;
            }
            a[high] = a[low];
        }
        a[low] = key;
        return low;
    }

    private void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
