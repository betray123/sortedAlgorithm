/**
 * Created by zk on 18/7/19.
 */

/**
 * 插入排序:1.直接插入排序.  2.希尔排序
 * 希尔排序:
 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
 * 这里"增量"的选取非常关键,这是个数学问题,目前为止还没有找到一种比较好的增量序列.
 * 注意:增量序列的最后一个增量值必须为1才行.
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] a = {26,81,12,54,92,76,20,37,19,48};
        ShellSort shellSort = new ShellSort();
        System.out.println("---排序前---");
        shellSort.print(a);//排序前
        shellSort.sort(a);//进行排序
        System.out.println("---排序后---");
        shellSort.print(a);//排序后
    }

    private void sort(int[] a) {
        int dk = a.length/2;
        while( dk >= 1  ){
            shellSort(a, dk);
            dk = dk/2;
        }

    }

    private void shellSort(int[] a, int dk) {//类似插入排序，只是插入排序增量是1，这里增量是dk,把1换成dk就可以了
        for(int i=dk;i<a.length;i++){
            if(a[i]<a[i-dk]){
                int j;
                int x=a[i];//x为待插入元素
                a[i]=a[i-dk];
                for(j=i-dk;  j>=0 && x<a[j];j=j-dk){//通过循环，逐个后移一位找到要插入的位置。
                    a[j+dk]=a[j];
                }
                a[j+dk]=x;//插入
            }

        }

    }


    private void print(int[] a) {
        for (int i = 0; i < a.length-1; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
