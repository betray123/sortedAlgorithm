/**
 * Created by zk on 18/7/22.
 */

/**
 * 交换排序:1.冒牌排序  2.快速排序
 * 1.冒泡排序:
 * 在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。
 * 即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {26,81,12,54,92,76,20,37,19,48};
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println("---排序前---");
        bubbleSort.print(a);//排序前
        System.out.println();
        bubbleSort.sort(a);//进行排序
        System.out.println("---排序后---");
        bubbleSort.print(a);//排序后
    }

    private void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < a.length-i-1; j++) {
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
