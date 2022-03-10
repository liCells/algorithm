/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * 力扣 543 二叉树的直径
 * binary tree
 * 这道题其实是求左右子树的深度, 然后相加即可
 */
public class 二叉树的直径 {

    static int sum = 0;

    public static void main(String[] args) {
        System.out.println(diameterOfBinaryTree(buildTree()));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        maxDepth(root);
        return sum;
    }

    public static Integer maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        sum = Math.max(sum, left + right);
        return 1 + Math.max(left, right);
    }

    public static TreeNode buildTree() {
        TreeNode left1_left2 = new TreeNode(4);
        TreeNode left1_right2 = new TreeNode(5);
        TreeNode left1 = new TreeNode(2, left1_left2, left1_right2);
        TreeNode right1 = new TreeNode(3);
        return new TreeNode(1, left1, right1);
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
