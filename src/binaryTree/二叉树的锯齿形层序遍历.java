package binaryTree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * 力扣 103 二叉树的锯齿形层序遍历
 */
public class 二叉树的锯齿形层序遍历 {
    public static void main(String[] args) {
        System.out.println(zigzagLevelOrder(buildTree()));
    }

    static List<List<Integer>> levelOrderList = new ArrayList<>();

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean symbol = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (symbol) {
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            symbol = !symbol;
            levelOrderList.add(list);
        }
        return levelOrderList;
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
