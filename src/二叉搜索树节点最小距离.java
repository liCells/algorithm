import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 * 力扣 783 二叉搜索树节点最小距离
 *
 * 中序遍历
 */
public class 二叉搜索树节点最小距离 {
    public static void main(String[] args) {
        System.out.println(minDiffInBST(buildTree()));
    }

    static List<Integer> list = new ArrayList<>();

    public static int minDiffInBST(TreeNode root) {
        if (root == null) return 0;
        order(root);
        int min = Integer.MAX_VALUE;
        // 下标遍历，不使用LinkedList
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(list.get(i) - list.get(i - 1), min);
        }
        return min;
    }

    public static void order(TreeNode root) {
        if (root == null) return;
        order(root.left);
        list.add(root.val);
        order(root.right);
    }

    public static TreeNode buildTree() {
        TreeNode right1_right2 = new TreeNode(52);
        TreeNode left1_left2 = new TreeNode(49, null, right1_right2);
        TreeNode left1_right2 = new TreeNode(89);
        TreeNode left1 = new TreeNode(69, left1_left2, left1_right2);
        return new TreeNode(90, left1, null);
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
