package com.zk.day01;

/**
 * Created by zk on 18/7/25.
 */
public class QuickSort1 {
    public static void main(String[] args) {
        int[] a = {26,81,12,54,92,76,20,37,19,48};
        QuickSort1 quickSort = new QuickSort1();
        System.out.println("---排序前---");
        quickSort.print(a);//排序前
        System.out.println();
        quickSort.sort(a,0,a.length-1);//进行排序
        System.out.println("---排序后---");
        quickSort.print(a);//排序后
    }

    private void sort(int[] a, int low, int high) {
        if (low < high){
            int middle=getMiddle(a,low,high);
            sort(a,low,middle-1);
            sort(a,middle+1,high);
        }
    }

    private int getMiddle(int[] a, int low, int high) {
        int key = a[low];
        while (low < high){
            while (low < high && a[high] >= key){
                high--;
            }
            a[low] = a[high];
            while (low <high && a[low] <= key){
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
