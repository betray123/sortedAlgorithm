package com.zk.binaryTreeSearch;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 广度优先算法：（也叫层序遍历）
 * 其过程检验来说是对每一层节点依次访问，访问完一层进入下一层，而且每个节点只能访问一次。
 * 对于上面的例子来说，广度优先遍历的 结果是：A,B,C,D,E,F,G,H,I(假设每层节点从左到右访问)。
 *
 * 先往队列中插入左节点，再插右节点，这样出队就是先左节点后右节点了。
 * 　　广度优先遍历树，需要用到队列（Queue）来存储节点对象,队列的特点就是先进先出。例如，上面这颗树的访问如下：
 *
 * 　　首先将A节点插入队列中，队列中有元素（A）;
 *
 * 　　将A节点弹出，同时将A节点的左、右节点依次插入队列，B在队首，C在队尾，（B，C），此时得到A节点；
 *
 * 　　继续弹出队首元素，即弹出B，并将B的左、右节点插入队列，C在队首，E在队尾（C,D，E），此时得到B节点；
 *
 * 　　继续弹出，即弹出C，并将C节点的左、中、右节点依次插入队列，（D,E,F,G,H），此时得到C节点；
 *
 * 　　将D弹出，此时D没有子节点，队列中元素为（E,F,G,H），得到D节点；
 *
 * 　　。。。以此类推。。
 *
 * 代码：这里以二叉树为例，遍历所有节点的值
 */
public class BreadthFirstSearch {

    /**
     *                  13
     *                 /  \
     *               65    5
     *              /  \    \
     *             97  25   37
     *            /    /\   /
     *           22   4 28 32
     **/
    public static void main(String[] args) {

        int[] arr={0,13,65,5,97,25,0,37,22,0,4,28,0,0,32,0};
        BinaryTree binaryTree = new BinaryTree(arr);
        //通过队列的方式遍历二叉树
        breadthFirstSearch(binaryTree.root);

    }

    /**
     * 通过队列的方式遍历二叉树
     * @param root
     */
    private static void breadthFirstSearch(BinaryTree.TreeNode root) {
        if (root == null){
            System.out.println("empty tree!!!");
            return;
        }
        ArrayDeque<BinaryTree.TreeNode> queue=new ArrayDeque<BinaryTree.TreeNode>();
        queue.add(root);
        while (queue.isEmpty() == false){
            BinaryTree.TreeNode treeNode = queue.remove();
            System.out.println(treeNode.value + "   ");
            if (treeNode.left != null){
                queue.add(treeNode.left);
            }
            if (treeNode.right != null){
                queue.add(treeNode.right);
            }
        }
        System.out.println("\n");
    }
}
