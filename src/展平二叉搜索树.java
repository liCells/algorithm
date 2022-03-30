import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/NYBBNL/
 * 力扣 剑指 Offer II 052 展平二叉搜索树
 */
public class 展平二叉搜索树 {
    public static void main(String[] args) {
        TreeNode node = increasingBST(buildTree());
        System.out.println(node);
    }

    static Queue<TreeNode> queue = new LinkedList<>();

    public static TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        order(root);
        root = queue.poll();
        TreeNode cur = root;
        while (!queue.isEmpty()) {
            cur.right = queue.poll();
            cur = cur.right;
            cur.left = null;
        }
        return root;
    }

    public static void order(TreeNode root) {
        if (root == null) return;
        order(root.left);
        queue.offer(root);
        order(root.right);
    }

    public static TreeNode buildTree() {
        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(7);
        return new TreeNode(5, left1, right1);
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
