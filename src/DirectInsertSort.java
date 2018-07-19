/**
 * Created by zk on 18/7/19.
 */

/**
 * 插入排序:1.直接插入排序.  2.希尔排序
 * 直接插入排序:
 * 将一个记录插入到已排序好的有序表中，从而得到一个新，记录数增1的有序表。
 * 即：先将序列的第1个记录看成是一个有序的子序列，然后从第2个记录逐个进行插入，直至整个序列有序为止。
 * 场景:整理扑克牌的时候,怎样将牌排好序
 * 时间复杂度：O（n^2）
 */
public class DirectInsertSort {

    public static void main(String[] args) {
        int[] a = {26,81,12,54,92,76,20,37,19,48};
        DirectInsertSort directInsertSort = new DirectInsertSort();
        System.out.println("---排序前---");
        directInsertSort.print(a);//排序前
        directInsertSort.sort(a);//进行排序
        System.out.println("---排序后---");
        directInsertSort.print(a);//排序后
    }

    public void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {//从头部第一个当做已经排好序的，把后面的一个一个的插到已经排好的列表中去。
            int j;
            int x = a[i];//x为待插入元素
            for (j = i; j > 0 && x < a[j-1]; j--) {//通过循环，逐个后移一位找到要插入的位置。
                a[j] = a[j-1];
            }
            a[j] = x;//插入元素
        }
    }

    public void print(int[] a){
        for (int i = 0; i < a.length-1; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
