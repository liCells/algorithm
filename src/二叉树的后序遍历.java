import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * 力扣 145 二叉树的后序遍历
 * binary tree
 */
public class 二叉树的后序遍历 {
    public static void main(String[] args) {
        System.out.println(postorderTraversal(buildTree()));
    }

    static List<Integer> list = new ArrayList<>();

    public static List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return list;
        postorder(root);
        return list;
    }

    public static void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        list.add(root.val);
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
