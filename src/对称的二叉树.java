/**
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * 力扣 剑指Offer 28 对称的二叉树
 *
 * 验证left.right和right.left且left.left和right.right是否都相等
 * 为空直接为true
 */
public class 对称的二叉树 {
    public static void main(String[] args) {
        System.out.println(isSymmetric(buildTree()));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return equals(root.left, root.right);
    }

    public static boolean equals(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left != null && right != null && left.val == right.val) {
            return equals(left.left, right.right) && equals(left.right, right.left);
        }
        return false;
    }

    public static TreeNode buildTree() {
        TreeNode left1_left2 = new TreeNode(1);
        TreeNode left1_right2 = new TreeNode(3);
        TreeNode right1_left2 = new TreeNode(3);
        TreeNode right1_right2 = new TreeNode(1);
        TreeNode left1 = new TreeNode(2, left1_left2, left1_right2);
        TreeNode right1 = new TreeNode(2, right1_left2, right1_right2);
        return new TreeNode(4, left1, right1);
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
