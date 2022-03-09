package binaryTree;

/**
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 * 力扣 99 恢复二叉搜索树
 * 注意第一个错位的节点只能赋值一次, 不然会被后序第二个错位的前置给覆盖掉
 */
public class 恢复二叉搜索树 {
    public static void main(String[] args) {
        TreeNode treeNode = buildTree();
        recoverTree(treeNode);
        System.out.println(treeNode);
    }

    static TreeNode first, second;
    static TreeNode pre;

    public static void recoverTree(TreeNode root) {
        if (root == null) return;
        LDR(root);
        int box = first.val;
        first.val = second.val;
        second.val = box;
    }

    public static void LDR(TreeNode root) {
        if (root == null) return;
        LDR(root.left);
        if (pre != null && root.val <= pre.val) {
            if (first == null) {
                first = pre;
            }
            second = root;
        }
        pre = root;
        LDR(root.right);
    }

    public static TreeNode buildTree() {
        TreeNode left1 = new TreeNode(3);
        return new TreeNode(2, left1, new TreeNode(1));
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
