import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/univalued-binary-tree/
 * 力扣 965 单值二叉树
 *
 * 所有节点值均为同一个值的二叉树为单值二叉树
 */
public class 单值二叉树 {
    public static void main(String[] args) {
        System.out.println(isUnivalTree(buildTree()));
    }

    public static boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        // 设置对应的单值
        int symbol = root.val;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // 不等于则直接返回false
            if (symbol != node.val) {
                return false;
            }
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return true;
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
