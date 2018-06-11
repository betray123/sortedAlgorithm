/**
 * 归并排序练习(关键是递归调用执行)
 */

public class MergeSort {
    public static void main(String[] args) {

        int[] a = {4,5,3,9,7,1,6,2,8};
        //调用归并方法，传递未排序的数组
        mergeSort(a);
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + ", ");
        }
    }


    //归并方法思想
    public static void mergeSort(int[] a){

        if (a.length > 1){
            //第一半数组
            int[] firstHalf = new int[a.length/2];
            //拷贝a数组中的数据到firstHalf中
            System.arraycopy(a,0,firstHalf,0,a.length/2);
            //递归调用本方法
            mergeSort(firstHalf);

            //第二半数组
            int secondHalfLength = a.length - a.length/2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(a,a.length/2,secondHalf,0,secondHalfLength);
            mergeSort(secondHalf);

            //merge firstHalf with secondHalf
            int[] temp = merge(firstHalf,secondHalf);
            //拷贝temp数组中的数据到a数组
            System.arraycopy(temp,0,a,0,temp.length);

        }
    }

    private static int[] merge(int[] firstHalf, int[] secondHalf) {
        int[] temp =new int[firstHalf.length + secondHalf.length];
        int current1 = 0;//current index in firstHalf
        int current2 = 0;//current index in secondHalf
        int current3 = 0;//current index in temp

        //判断当前数组1和数组2中的数据大小，赋值给temp后自增
        while (current1 < firstHalf.length && current2 < secondHalf.length){
            if (firstHalf[current1] < secondHalf[current2]){
                temp[current3++] = firstHalf[current1++];
            }else {
                temp[current3++] = secondHalf[current2++];
            }
        }

        //如果2数组比1数组先比较完，在temp后追加1数组中之后的值
        while (current1 < firstHalf.length){
            temp[current3++] = firstHalf[current1++];
        }

        //如果1数组比2数组先比较完，在temp后追加2数组中之后的值
        while (current2 < secondHalf.length){
            temp[current3++] = secondHalf[current2++];
        }

        return temp;
    }

}
