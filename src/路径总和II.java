import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 * 力扣 113 路径总和II
 *
 * 注意题目所描述的数据范围（未描述值会为正数）
 */
public class 路径总和II {
    public static void main(String[] args) {
        System.out.println(pathSum(buildTree(), -5));
    }

    static List<List<Integer>> list = new ArrayList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        order(root, new ArrayList<>(), targetSum);
        return list;
    }

    public static void order(TreeNode root, List<Integer> arr, int targetSum) {
        if (root == null) return;
        // 获取到这个位置集合元素的总和是否等于targetSum，如果等于则将arr加入全局List
        arr.add(root.val);
        targetSum -= root.val;
        if (0 == targetSum && root.left == null && root.right == null) {
            list.add(arr);
            return;
        }
        order(root.left, new ArrayList<>(arr), targetSum);
        order(root.right, new ArrayList<>(arr), targetSum);
    }

    public static TreeNode buildTree() {
        TreeNode right1 = new TreeNode(-3);
        return new TreeNode(-2, null, right1);
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
