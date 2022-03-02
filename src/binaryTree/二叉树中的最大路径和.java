package binaryTree;

/**
 * Definition for a binary tree node.
 */
class 二叉树中的最大路径和 {
    public static void main(String[] args) {

    }

    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;

        return 1;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}