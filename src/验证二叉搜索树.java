/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 力扣 98 验证二叉搜索树
 * binary tree
 * 需要知道二叉搜索树的定义, 不是说上一层的root和左右比即可, 而是root右侧的全部都要大于root
 */
public class 验证二叉搜索树 {
    public static void main(String[] args) {
        System.out.println(isValidBST(buildTree()));
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBST(root, null, null);
    }

    public static boolean isValidBST(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null) return true;
        if (left != null && root.val >= left.val) return false;
        if (right != null && root.val <= right.val) return false;
        return isValidBST(root.left, root, right) && isValidBST(root.right, left, root);
    }

    public static TreeNode buildTree() {
        TreeNode left1 = new TreeNode(4);
        return new TreeNode(5, left1, new TreeNode(6, new TreeNode(3), new TreeNode(7)));
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
