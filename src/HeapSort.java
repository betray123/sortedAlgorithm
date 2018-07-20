import java.util.Stack;

/**
 * 选择排序：1.直接选择排序  2.堆排序
 * 堆排序：
 * 实现堆排序需解决两个问题：1. 如何将n 个待排序的数建成堆；2. 输出堆顶元素后，怎样调整剩余n-1 个元素，使其成为一个新堆。
 *
 * 首先讨论第二个问题：输出堆顶元素后，对剩余n-1元素重新建成堆的调整过程。
 * 调整小顶堆的方法：
 * 1）设有m 个元素的堆，输出堆顶元素后，剩下m-1 个元素。将堆底元素送入堆顶（（最后一个元素与堆顶进行交换），堆被破坏，其原因仅是根结点不满足堆的性质。
 * 2）将根结点与左、右子树中较小元素的进行交换。
 * 3）若与左子树交换：如果左子树堆被破坏，即左子树的根结点不满足堆的性质，则重复方法 （2）.
 * 4）若与右子树交换，如果右子树堆被破坏，即右子树的根结点不满足堆的性质。则重复方法 （2）.
 * 5）继续对不满足堆性质的子树进行上述交换操作，直到叶子结点，堆被建成。
 *
 * 再讨论对n 个元素初始建堆的过程。
 * 建堆方法：对初始序列建堆的过程，就是一个反复进行筛选的过程。
 * 1）n 个结点的完全二叉树，则最后一个结点是第个结点的子树。
 * 2）筛选从第个结点为根的子树开始，该子树成为堆。
 * 3）之后向前依次对各结点为根的子树进行筛选，使之成为堆，直到根结点。
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] a = {26,81,12,54,92,76,20,37,19,48};
        HeapSort heapSort = new HeapSort();
        System.out.println("---排序前---");
        heapSort.print(a);//排序前
        System.out.println();

        for(int i=0;i<a.length;i++){
            heapSort.createLittleHeap(a,a.length-1-i);//创建堆,创建的是小顶堆。每次循环完，二叉树的根节点都是最小值，所以与此时的未排好部分最后一个值交换位置
            heapSort.swap(a, 0, a.length - 1 - i);//与最后一个值交换位置，最小值找到了位置
            heapSort.print(a);
            System.out.println();
        }

        Stack stack = new Stack();
        for (int i = 0; i < a.length; i++) {
            stack.push(a[i]);
        }
        System.out.println("---排序后---");
        for (int i = 0; i < a.length; i++) {
            System.out.print(Integer.valueOf(stack.pop().toString()) + " ");//排序后
        }
    }

    private void swap(int[] data, int i, int j) {
        if (i == j) {
            return;
        }
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }

    private void createLittleHeap(int[] data, int last) {
        for (int i = (last- 1) / 2; i >= 0; i--) {  //找到最后一个叶子节点的双亲节点
            // 保存当前正在判断的节点
            int parent = i;
            // 若当前节点的左子节点存在，即子节点存在
            while (2 * parent + 1 <= last) {
                // biggerIndex总是记录较大节点的值,先赋值为当前判断节点的左子节点
                int bigger = 2 * parent + 1;//bigger指向左子节点
                if (bigger < last) { //说明存在右子节点

                    if (data[bigger] > data[bigger+ 1]) { //左子节点>右子节点时

                        bigger=bigger+1;
                    }
                }
                if (data[parent] > data[bigger]) {  //若双亲节点值大于子节点中最大的
                    // 若当前节点值比子节点最大值小，则交换2者得值，交换后将biggerIndex值赋值给k
                    swap(data, parent, bigger);
                    parent = bigger;
                } else {
                    break;
                }
            }
        }

    }

    private void print(int[] a) {
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
