/**
 * https://leetcode-cn.com/problems/same-tree/
 * 力扣 100 相同的树
 * binary tree
 */
public class 相同的树 {
    public static void main(String[] args) {
        System.out.println(isSameTree(buildTree(), buildTree2()));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSame(p, q);
    }

    public static boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }

    public static TreeNode buildTree() {
        TreeNode right1_left2 = new TreeNode(15);
        TreeNode right1_right2 = new TreeNode(7, new TreeNode(1), null);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(20, right1_left2, right1_right2);
        return new TreeNode(3, left1, right1);
    }

    public static TreeNode buildTree2() {
        TreeNode right1_left2 = new TreeNode(15);
        TreeNode right1_right2 = new TreeNode(7, new TreeNode(1), null);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(20, right1_left2, right1_right2);
        return new TreeNode(3, left1, right1);
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
