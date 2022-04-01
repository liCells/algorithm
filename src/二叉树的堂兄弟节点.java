import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/cousins-in-binary-tree/
 * 力扣 993 二叉树的堂兄弟节点
 *
 * 两节点深度相同，且父节点不为同一个，则为堂兄弟节点
 * 节点值均不相同，范围在1-100
 */
public class 二叉树的堂兄弟节点 {
    public static void main(String[] args) {
        System.out.println(isCousins(buildTree(), 2, 3));
    }
    
    public static boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 计数
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) continue;
                if (node.val == x || node.val == y) {
                    count++;
                }
                if (node.left != null && node.right != null) {
                    // 判断是不是在同一个父节点下
                    if ((node.left.val == x && node.right.val == y) || (node.right.val == x && node.left.val == y)) {
                        return false;
                    }
                    queue.offer(node.left);
                    queue.offer(node.right);
                    continue;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 一旦计数发生变化，则本次循环可以确认结果
            if (count == 2) {
                return true;
            }
            if (count == 1) {
                return false;
            }
        }
        return false;
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
