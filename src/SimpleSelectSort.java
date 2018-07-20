/**
 * 选择排序：1.直接选择排序  2.堆排序
 * 直接选择排序：
 * 在要排序的一组数中，选出最小（或者最大）的一个数与第1个位置的数交换；然后在剩下的数当中再找最小（或者最大）的与第2个位置的数交换，
 * 依次类推，直到第n-1个元素（倒数第二个数）和第n个元素（最后一个数）比较为止。
 * 关键：有一个中间变量一直保存着最小的元素的下标。
 */
public class SimpleSelectSort {

    public static void main(String[] args) {
        int[] a = {26,81,12,54,92,76,20,37,19,48};
        SimpleSelectSort simpleSelectSort = new SimpleSelectSort();
        System.out.println("---排序前---");
        simpleSelectSort.print(a);//排序前
        simpleSelectSort.sort(a);//进行排序
        System.out.println("---排序后---");
        simpleSelectSort.print(a);//排序后
    }

    private void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int k = i;//k存放最小值下标。每次循环最小值下标+1
            for (int j = i+1; j < a.length; j++) {//找到最小值下标
                if (a[k] > a[j]){
                    k = j;
                }
            }
            swap(a,k,i);
        }
    }

    public  void swap(int[] data, int i, int j) {
        if (i == j) {
            return;
        }
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }

    private void print(int[] a) {
        for (int i = 0; i < a.length-1; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
