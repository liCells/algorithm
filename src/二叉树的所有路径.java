import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * 力扣 257 二叉树的所有路径
 * binary tree
 */
public class 二叉树的所有路径 {
    public static void main(String[] args) {
        System.out.println(binaryTreePaths(buildTree()));
    }

    static List<String> list = new ArrayList<>();

    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return list;
        if (root.left == null && root.right == null) {
            list.add(String.valueOf(root.val));
            return list;
        }
        path(root.left, String.valueOf(root.val));
        path(root.right, String.valueOf(root.val));
        return list;
    }

    public static void path(TreeNode root, String path) {
        if (root == null) return;
        path += "->" + root.val;
        if (root.left == null && root.right == null) {
            list.add(path);
        }
        path(root.left, path);
        path(root.right, path);
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
