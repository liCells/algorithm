/**
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 * 力扣 700 二叉搜索树中的搜索
 */
public class 二叉搜索树中的搜索 {
    public static void main(String[] args) {
        TreeNode node = searchBST(buildTree(), 7);
        System.out.println(node);
    }
    
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (val == root.val) return root;
        if (val < root.val) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }

    public static TreeNode buildTree() {
        TreeNode left1_left2 = new TreeNode(1);
        TreeNode left1_right2 = new TreeNode(3);
        TreeNode left1 = new TreeNode(2, left1_left2, left1_right2);
        TreeNode right1 = new TreeNode(7);
        return new TreeNode(4, left1, right1);
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
