/**
 * https://leetcode-cn.com/problems/jC7MId/
 * 力扣 剑指Offer II 051 节点之和最大的路径
 */
public class 节点之和最大的路径 {
    public static void main(String[] args) {
        System.out.println(maxPathSum(buildTree()));
    }

    static int max = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        return max;
    }

    public static int maxSum(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, maxSum(root.left));
        int right = Math.max(0, maxSum(root.right));
        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

    public static TreeNode buildTree() {
        return new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(4, null, new TreeNode(5)));
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
