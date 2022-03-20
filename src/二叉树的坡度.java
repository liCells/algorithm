/**
 * https://leetcode-cn.com/problems/binary-tree-tilt/
 * 力扣 563 二叉树的坡度
 * 本质就是后序遍历
 * 每一次刚好返回子树的总和, sum则是所有的右叶子减左叶子的和
 */
public class 二叉树的坡度 {
    public static void main(String[] args) {
        System.out.println(findTilt(buildTree()));
    }

    static int sum = 0;

    public static int findTilt(TreeNode root) {
        tilt(root);
        return sum;
    }

    public static int tilt(TreeNode root) {
        if (root == null) return 0;
        int left = tilt(root.left);
        int right = tilt(root.right);
        sum += Math.abs(right - left);
        return left + right + root.val;
    }

    public static TreeNode buildTree() {
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
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
