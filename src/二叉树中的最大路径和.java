/**
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * 力扣 124 二叉树中的最大路径和
 * binary tree
 * 本质上就是一个后序遍历
 */
class 二叉树中的最大路径和 {
    public static void main(String[] args) {
        System.out.println(maxPathSum(buildTree()));
    }

    static int maxPathSum = Integer.MIN_VALUE;

    public static int getMaxPathSum(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, getMaxPathSum(root.left));
        int right = Math.max(0, getMaxPathSum(root.right));
        // 后序遍历代码位置
        maxPathSum = Math.max(maxPathSum, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

    public static int maxPathSum(TreeNode root) {
        getMaxPathSum(root);
        return maxPathSum;
    }

    public static TreeNode buildTree() {
        TreeNode right1_left2 = new TreeNode(15);
        TreeNode right1_right2 = new TreeNode(7);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(20, right1_left2, right1_right2);
        return new TreeNode(-10, left1, right1);
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