import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 * 力扣 938 二叉搜索树的范围和
 */
public class 二叉搜索树的范围和 {
    public static void main(String[] args) {
        System.out.println(rangeSumBST2(buildTree(), 7, 15));
    }

    public static int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val >= low && root.val <= high) {
                sum += root.val;
                if (root.val == high) {
                    return sum;
                }
            }
            root = root.right;
        }
        return sum;
    }

    static int sum = 0;

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        sum(root, low, high);
        return sum;
    }

    public static void sum(TreeNode root, int low, int high) {
        if (root == null) return;
        sum(root.left, low, high);
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        sum(root.right, low, high);
    }

    public static TreeNode buildTree() {
        TreeNode left1_left2 = new TreeNode(3);
        TreeNode left1_right2 = new TreeNode(7);
        TreeNode right1_right2 = new TreeNode(18);
        TreeNode left1 = new TreeNode(5, left1_left2, left1_right2);
        TreeNode right1 = new TreeNode(15, null, right1_right2);
        return new TreeNode(10, left1, right1);
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
