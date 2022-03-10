/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 力扣 104 二叉树的最大深度
 * binary tree
 */
public class 二叉树的最大深度 {

    public static void main(String[] args) {
        System.out.println(maxDepth(buildTree()));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return maxDepth(root, 0);
    }

    public static Integer maxDepth(TreeNode root, Integer depth) {
        if (root == null) return depth;
        depth += 1;
        Integer left = maxDepth(root.left, depth);
        Integer right = maxDepth(root.right, depth);
        return Math.max(left, right);
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
