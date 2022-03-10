import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 力扣 144 二叉树的前序遍历
 * binary tree
 */
public class 二叉树的前序遍历 {
    public static void main(String[] args) {
        System.out.println(preorderTraversal(buildTree()));
    }

    static List<Integer> preorderList = new ArrayList<>();

    public static List<Integer> preorderTraversal(TreeNode root) {
        preorderTraverse(root);
        return preorderList;
    }

    public static void preorderTraverse(TreeNode root) {
        if (root == null) return;
        preorderList.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
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
