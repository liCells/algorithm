/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 力扣 235 二叉搜索树的最近公共祖先
 * 利用二叉搜索树的特性
 * 如果两个都小于root, 那么说明在左侧
 * 如果两个都大于root, 那么说明在右侧
 * 其他则说明root就是最近公共祖先
 */
public class 二叉搜索树的最近公共祖先 {
    public static void main(String[] args) {
        System.out.println(lowestCommonAncestor(buildTree(), new TreeNode(1), new TreeNode(4)).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p.val == root.val) {
            return p;
        }
        if (q.val == root.val) {
            return q;
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    public static TreeNode buildTree() {
        return new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6));
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
