package binaryTree;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * 力扣 110 平衡二叉树
 * 后序遍历, 注意最后的1+, 这里会倒着向上记录层级, 直到最后层级相差大于1就停止
 */
public class 平衡二叉树 {
    public static void main(String[] args) {
        System.out.println(isBalanced(buildTree()));
    }

    static boolean isBalanced = true;

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return isBalanced;
        LDR(root);
        return isBalanced;
    }

    public static int LDR(TreeNode treeNode) {
        if (treeNode == null) return 0;
        int left = LDR(treeNode.left);
        int right = LDR(treeNode.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
            return 0;
        }
        return 1 + Math.max(left, right);
    }

    public static TreeNode buildTree() {
        TreeNode left1_left2 = new TreeNode(3, new TreeNode(4), null);
        TreeNode left1 = new TreeNode(2, left1_left2, null);
        TreeNode right1 = new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4)));
        return new TreeNode(1, left1, right1);
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
