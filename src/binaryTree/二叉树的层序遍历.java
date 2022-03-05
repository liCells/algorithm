package binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 力扣 102 二叉树的层序遍历
 * 注意如何判断层级
 */
public class 二叉树的层序遍历 {
    public static void main(String[] args) {
        System.out.println(levelOrder(buildTree()));
    }

    static List<List<Integer>> levelOrderList = new ArrayList<>();

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        levelOrderList.add(new ArrayList<>(List.of(root.val)));
        level(root, 1);
        return levelOrderList;
    }

    public static void level(TreeNode treeNode, int level) {
        if (treeNode == null) return;
        List<Integer> levelList = new ArrayList<>();
        if (levelOrderList.size() > level && levelOrderList.get(level) != null) {
            levelList = levelOrderList.get(level);
        }
        if (treeNode.left != null) {
            levelList.add(treeNode.left.val);
        }
        if (treeNode.right != null) {
            levelList.add(treeNode.right.val);
        }
        if (levelOrderList.size() > level && levelOrderList.get(level) != null) {
            levelOrderList.set(level, levelList);
        } else if (!levelList.isEmpty()) {
            levelOrderList.add(levelList);
        }
        level(treeNode.left, level + 1);
        level(treeNode.right, level + 1);
    }

    public static TreeNode buildTree() {
        TreeNode right1_left2 = new TreeNode(15);
        TreeNode right1_right2 = new TreeNode(7, new TreeNode(1), null);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(20, right1_left2, right1_right2);
        return new TreeNode(3, left1, right1);
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
