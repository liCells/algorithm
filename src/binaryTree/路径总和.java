package binaryTree;

/**
 * https://leetcode-cn.com/problems/path-sum/
 * 力扣 112 路径总和
 */
public class 路径总和 {
    public static void main(String[] args) {
        System.out.print(hasPathSum(buildTree(), 4));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return LDR(root, targetSum, 0);
    }

    public static boolean LDR(TreeNode treeNode, int targetSum, int sum) {
        if (treeNode == null) return false;
        sum += treeNode.val;
        if (treeNode.left == null && treeNode.right == null && targetSum == sum) {
            return true;
        }
        return LDR(treeNode.left, targetSum, sum) || LDR(treeNode.right, targetSum, sum);
    }

    public static TreeNode buildTree() {
        TreeNode left1 = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        return new TreeNode(1, left1, new TreeNode(3));
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
