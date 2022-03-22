/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * 力扣 剑指Offer 27 二叉树的镜像
 *
 * 对调left和right即可
 */
public class 二叉树的镜像 {
    public static void main(String[] args) {
        TreeNode node = mirrorTree(buildTree());
        System.out.println(node);
    }

    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        mirrorTree(root.left);
        mirrorTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    public static TreeNode buildTree() {
        TreeNode left1_left2 = new TreeNode(1);
        TreeNode left1_right2 = new TreeNode(3);
        TreeNode right1_left2 = new TreeNode(5);
        TreeNode right1_right2 = new TreeNode(7);
        TreeNode left1 = new TreeNode(2, left1_left2, left1_right2);
        TreeNode right1 = new TreeNode(6, right1_left2, right1_right2);
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
