import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 * 力扣 530 二叉搜索树的最小绝对差
 */
public class 二叉搜索树的最小绝对差 {
    public static void main(String[] args) {
        System.out.println(getMinimumDifference(buildTree()));
    }

    static int min = Integer.MAX_VALUE;

    static List<Integer> list = new ArrayList<>();

    public static int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        getMinimum(root);
        if (list.size() == 2) {
            return list.get(1) - list.get(0);
        }
        for (int i = 1; i < list.size(); i++) {
            Integer aft = list.get(i);
            Integer pur = list.get(i - 1);
            int val = aft - pur;
            if (val > 0) {
                min = Math.min(val, min);
            }
        }
        return min;
    }

    public static void getMinimum(TreeNode root) {
        if (root == null) return;
        getMinimum(root.left);
        list.add(root.val);
        getMinimum(root.right);
    }

    public static TreeNode buildTree() {
        return new TreeNode(543, new TreeNode(384, null, new TreeNode(445)), new TreeNode(652, null, new TreeNode(699)));
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
