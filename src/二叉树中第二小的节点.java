/**
 * https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
 * 力扣 671 二叉树中第二小的节点
 *
 * 子节点数量只能为2或者0
 * root.val = min(root.left.val, root.right.val)
 */
public class 二叉树中第二小的节点 {

    public static void main(String[] args) {
        System.out.println(findSecondMinimumValue(buildTree()));
    }

    static int min = -1;

    public static int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        findMinVal(root, root.val);
        return min;
    }

    public static void findMinVal(TreeNode root, int cur) {
        if (root == null) return;
        // 解决全部数据均一致的问题
        if (root.val != cur) {
            // 等于-1则直接赋值
            if (min == -1) {
                min = root.val;
            } else {
                // 找到小的值进行赋值
                min = Math.min(min, root.val);
            }
        }
        findMinVal(root.left, cur);
        findMinVal(root.right, cur);
    }

    public static TreeNode buildTree() {
        TreeNode left1_left2 = new TreeNode(2);
        TreeNode left1_right2 = new TreeNode(3);
        TreeNode left1 = new TreeNode(2, left1_left2, left1_right2);
        TreeNode right1 = new TreeNode(1);
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
