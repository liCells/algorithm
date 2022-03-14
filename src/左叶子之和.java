/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 * 力扣 404 左叶子之和
 */
public class 左叶子之和 {
    public static void main(String[] args) {
        System.out.println(sumOfLeftLeaves(buildTree()));
    }

    static int sum = 0;

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        VLR(root);
        return sum;
    }

    public static void VLR(TreeNode treeNode) {
        if (treeNode == null) return;
        if (treeNode.left != null && treeNode.left.left == null && treeNode.left.right == null) {
            sum += treeNode.left.val;
        }
        VLR(treeNode.left);
        VLR(treeNode.right);
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
