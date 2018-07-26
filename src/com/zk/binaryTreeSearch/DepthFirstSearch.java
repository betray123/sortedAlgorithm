package com.zk.binaryTreeSearch;

import java.util.Stack;

/**
 * 深度优先算法：
 * 其过程简要来说是对每一个可能的分支路径深入到不能再深入为止，而且每个节点只能访问一次。
 * 对于上面的例子来说深度优先遍历的结果就是：A,B,D,E,I,C,F,G,H.(假设先走子节点的的左侧)。
 *
 * 深度优先遍历各个节点，需要使用到栈（Stack）这种数据结构。stack的特点是是先进后出。整个遍历过程如下：
 *
 * 先往栈中压入右节点，再压左节点，这样出栈就是先左节点后右节点了。
 * 首先将A节点压入栈中，stack（A）;
 *
 * 将A节点弹出，同时将A的子节点C，B压入栈中，此时B在栈的顶部，stack(B,C)；
 *
 * 将B节点弹出，同时将B的子节点E，D压入栈中，此时D在栈的顶部，stack（D,E,C）；
 *
 * 将D节点弹出，没有子节点压入,此时E在栈的顶部，stack（E，C）；
 *
 * 将E节点弹出，同时将E的子节点I压入，stack（I,C）；
 *
 * ...依次往下，最终遍历完成。
 *
 * 以下是该算法的非递归实现方式：
 */
public class DepthFirstSearch {

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
     //非递归的方式测试深度优先遍历
//     deepFirstSearch(binaryTree.root);
     //递归的方式测试深度优先遍历
     deepFirst(binaryTree.root);

    }

    /**
     * 递归的方式测试深度优先遍历
     * @param root
     */
    private static void deepFirst(BinaryTree.TreeNode root) {
        if (root != null){
            System.out.println(root.value + "   ");
            deepFirst(root.left);
            deepFirst(root.right);

        }
    }

    /**
     * 非递归的方式测试深度优先遍历
     * @param root
     */
    private static void deepFirstSearch(BinaryTree.TreeNode root) {
        if (root == null){
            System.out.println("empty tree!");
            return;
        }
        Stack<BinaryTree.TreeNode> stack = new Stack<>();
        stack.push(root);
        while (stack.isEmpty() == false){
            BinaryTree.TreeNode treeNode = stack.pop();
            System.out.println(treeNode.value + "    ");
            if (treeNode.right != null){
                stack.push(treeNode.right);
            }
            if (treeNode.left != null){
                stack.push(treeNode.left);
            }
        }
        System.out.println("\n");
    }
}
