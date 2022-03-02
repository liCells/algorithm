package binaryTree;

public class 二叉树的四种遍历 {

    /**
     * 前序
     * 根结点 -> 左子树 -> 右子树
     */
    public static void DLR(TreeNode treeNode) {
        if (treeNode == null) return;
        System.out.print(treeNode.val);
        DLR(treeNode.left);
        DLR(treeNode.right);
    }

    /**
     * 中序
     * 左子树 -> 根结点 -> 右子树
     */
    public static void LDR(TreeNode treeNode) {
        if (treeNode == null) return;
        LDR(treeNode.left);
        System.out.print(treeNode.val);
        LDR(treeNode.right);
    }

    /**
     * 后序
     * 左子树 -> 右子树 -> 根结点
     */
    public static void LRD(TreeNode treeNode) {
        if (treeNode == null) return;
        LRD(treeNode.left);
        LRD(treeNode.right);
        System.out.print(treeNode.val);
    }

    /**
     * 层次
     * 按照层次遍历, 每一层从左到右
     */
    public static void levelOrder(TreeNode treeNode) {
        if (treeNode == null) return;
        System.out.print(treeNode.val);
        level(treeNode);
    }

    public static void level(TreeNode treeNode) {
        if (treeNode == null) return;
        if (treeNode.left != null) {
            System.out.print(treeNode.left.val);
        }
        if (treeNode.right != null) {
            System.out.print(treeNode.right.val);
        }
        level(treeNode.left);
        level(treeNode.right);
    }

    public static void main(String[] args) {
        // DLR(buildTree());
        // LDR(buildTree());
        // LRD(buildTree());
        levelOrder(buildTree());
    }

    public static TreeNode buildTree() {
        TreeNode left1_left2 = new TreeNode(4);
        TreeNode left1_right2 = new TreeNode(5);
        TreeNode right1_left2 = new TreeNode(6);
        TreeNode right1_right2 = new TreeNode(7);
        TreeNode left1 = new TreeNode(2, left1_left2, left1_right2);
        TreeNode right1 = new TreeNode(3, right1_left2, right1_right2);
        return new TreeNode(1, left1, right1);
    }

    static class TreeNode {
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

