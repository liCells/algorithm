import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/leaf-similar-trees/
 * 力扣 872 叶子相似的树
 */
public class 叶子相似的树 {
    public static void main(String[] args) {
        System.out.println(leafSimilar(buildTree(), buildTree1()));
    }

    static Queue<Integer> list = new LinkedList<>();

    static boolean symbol = true;

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        order(root1);
        order2(root2);
        // 注意第二个二叉树可能短于第一个，所以如果不为空直接返回false
        if (list.isEmpty()) {
            return symbol;
        }
        return false;
    }

    public static void order(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.offer(root.val);
        }
        order(root.left);
        order(root.right);
    }

    public static void order2(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            // 注意第一个二叉树可能短于第二个
            if (list.isEmpty() || list.poll() != root.val) {
                symbol = false;
                return;
            }
        }
        order2(root.left);
        order2(root.right);
    }

    public static TreeNode buildTree() {
        TreeNode left1_left2 = new TreeNode(6);
        TreeNode left1_right2 = new TreeNode(2, new TreeNode(7), new TreeNode(4));
        TreeNode right1_left2 = new TreeNode(9);
        TreeNode right1_right2 = new TreeNode(8);
        TreeNode left1 = new TreeNode(5, left1_left2, left1_right2);
        TreeNode right1 = new TreeNode(1, right1_left2, right1_right2);
        return new TreeNode(3, left1, right1);
    }

    public static TreeNode buildTree1() {
        TreeNode left1_left2 = new TreeNode(6);
        TreeNode left1_right2 = new TreeNode(7);
        TreeNode right1_left2 = new TreeNode(4);
        TreeNode right1_right2 = new TreeNode(2, new TreeNode(9), new TreeNode(8));
        TreeNode left1 = new TreeNode(5, left1_left2, left1_right2);
        TreeNode right1 = new TreeNode(1, right1_left2, right1_right2);
        return new TreeNode(3, left1, right1);
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

/*
   3
 5   1
6 7 4  2
      9  11
        8  10

     3
  5     1
6   2   9 8
   7 4
 */