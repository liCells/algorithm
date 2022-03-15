/**
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 * 力扣 617 合并二叉树
 */
public class 合并二叉树 {
    public static void main(String[] args) {
        TreeNode treeNode = mergeTrees(buildTree(), buildTree());
        System.out.println(treeNode);
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    public static TreeNode buildTree() {
        return new TreeNode(
                1,
                new TreeNode(
                        2,
                        null,
                        new TreeNode(3)
                ),
                new TreeNode(
                        4,
                        null,
                        new TreeNode(5)
                )
        );
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
