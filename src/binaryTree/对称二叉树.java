package binaryTree;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 力扣 101 对称二叉树
 */
public class 对称二叉树 {
    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        return isSame(root.left, root.right);
    }

    public static boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSame(p.left, q.right) && isSame(p.right, q.left);
    }

    public static TreeNode buildTree() {
        TreeNode right1_left2 = new TreeNode(15);
        TreeNode right1_right2 = new TreeNode(7, new TreeNode(1), null);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(20, right1_left2, right1_right2);
        return new TreeNode(3, left1, right1);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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
