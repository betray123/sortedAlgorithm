/**
 * Created by zk on 18/7/22.
 */

/**
 * 交换排序:1.冒牌排序  2.快速排序
 * 2.快速排序
 * 基本思想：
 1）选择一个基准元素,通常选择第一个元素或者最后一个元素.
 2）通过一趟排序讲待排序的记录分割成独立的两部分，其中一部分记录的元素值均比基准元素值小。另一部分记录的 元素值比基准值大.
 3）此时基准元素在其排好序后的正确位置.
 4）然后分别对这两部分记录用同样的方法继续进行排序，直到整个序列有序.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {26,81,12,54,92,76,20,37,19,48};
        QuickSort quickSort = new QuickSort();
        System.out.println("---排序前---");
        quickSort.print(a);//排序前
        System.out.println();
        quickSort.sort(a,0,a.length-1);//进行排序
        System.out.println("---排序后---");
        quickSort.print(a);//排序后
    }

    public void sort(int[] a,int low, int high) {
        if(low<high){ //如果不加这个判断递归会无法退出导致堆栈溢出异常
            int middle=getMiddle(a,low,high);
            sort(a,0,middle-1);          //递归对低子表递归排序
            sort(a,middle + 1,high);        //递归对高子表递归排序
        }
    }
    public int getMiddle(int[] a, int low, int high) {

        int key = a[low];//基准元素，排序中会空出来一个位置
        while (low < high) {
            while (low < high && a[high] >= key) {//从high开始找比基准小的，与low换位置
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= key) {//从low开始找比基准大,放到之前high空出来的位置上
                low++;
            }
            a[high] = a[low];
        }
        a[low] = key;//此时low=high 是基准元素的位置，也是空出来的那个位置
        return low;
    }



    private void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
