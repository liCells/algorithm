import java.util.*;

/**
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 * 力扣 501 二叉搜索树中的众数
 */
public class 二叉搜索树中的众数 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMode(buildTree())));
    }

    static Map<Integer, Integer> map = new HashMap<>();

    public static int[] findMode(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return new int[] {root.val};
        map.put(root.val, 1);
        VLR(root.left);
        VLR(root.right);
        Collection<Integer> values = map.values();
        int max = 0;
        for (Integer value : values) {
            max = Math.max(value, max);
        }
        final int temp = max;
        return map.entrySet().stream().filter(item -> item.getValue() == temp).mapToInt(Map.Entry::getKey).toArray();
    }

    public static void VLR(TreeNode root) {
        if (root == null) return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        VLR(root.left);
        VLR(root.right);
    }

    public static TreeNode buildTree() {
        TreeNode left1_left2 = new TreeNode(2);
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
