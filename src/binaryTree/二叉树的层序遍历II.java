package binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * 力扣 107 二叉树的层序遍历II
 */
public class 二叉树的层序遍历II {
    public static void main(String[] args) {
        System.out.println(levelOrderBottom(buildTree()));
    }

    static List<List<Integer>> levelOrderList = new ArrayList<>();

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        levelOrderList.add(new ArrayList<>(List.of(root.val)));
        level(root, 1);
        Collections.reverse(levelOrderList);
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
        TreeNode right1_left2 = new TreeNode(3);
        TreeNode right1_right2 = new TreeNode(-1, new TreeNode(1), new TreeNode(2));
        TreeNode left1_left2 = new TreeNode(1);
        TreeNode left1 = new TreeNode(2, left1_left2, null);
        TreeNode right1 = new TreeNode(4, right1_left2, right1_right2);
        return new TreeNode(0, left1, right1);
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
