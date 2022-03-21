/**
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 * 力扣 572 另一棵树的子树
 *
 * 判断是否有树为空, 遍历root, 直到遇到和subRoot.val相同的值, 同步遍历两个树
 * 使用什么遍历? 前序
 * 如何返回对应的标志? 循环到subRoot.val为空, 验证root是否也同样无子节点
 *
 * 参考题100, 相同的树
 */
public class 另一棵树的子树 {
    public static void main(String[] args) {
        System.out.println(isSubtree(buildTree(), new TreeNode(1)));
    }

    static boolean symbol = false;

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return false;
        if (root.val == subRoot.val) {
            symbol = isSameTree(root, subRoot);
            if (symbol) return true;
        }
        boolean left = isSubtree(root.left, subRoot);
        if (left) return true;
        boolean right = isSubtree(root.right, subRoot);
        if (right) return true;
        return symbol;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static TreeNode buildTree() {
        TreeNode left1 = new TreeNode(1);
        return new TreeNode(1, left1, null);
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
