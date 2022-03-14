/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 力扣 226 翻转二叉树
 * binary tree 后序遍历
 */
public class 翻转二叉树 {
    public static void main(String[] args) {
        System.out.println(invertTree(buildTree()));
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        invert(root);
        return root;
    }

    public static void invert(TreeNode root) {
        if (root == null) return;
        invert(root.left);
        invert(root.right);
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
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
