package com.zk.binaryTreeSearch;

/**
 * 构建一颗二叉树
 */
public class BinaryTree {

    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value){
            this.value = value;
        }
    }

    TreeNode root;

    public BinaryTree(int[] array){
        root = makeBinaryTreeByArray(array,1);

    }

    private TreeNode makeBinaryTreeByArray(int[] array, int index) {
        if (index<array.length){
            int value = array[index];
            if (value != 0){
                TreeNode t = new TreeNode(value);
                t.left = makeBinaryTreeByArray(array,index*2);
                t.right = makeBinaryTreeByArray(array,index*2 +1);
                return t;
            }
        }
        return null;
    }
}
