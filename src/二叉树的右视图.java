import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * 力扣 199 二叉树的右视图
 * binary tree
 */
public class 二叉树的右视图 {
    public static void main(String[] args) {
        System.out.println(rightSideView(buildTree()));
    }

    static List<Integer> list = new ArrayList<>();

    static List<Integer> levelList = new ArrayList<>();

    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) return list;
        rightSide(root, 0);
        return list;
    }

    public static void rightSide(TreeNode treeNode, int level) {
        if (treeNode == null) return;
        if (!levelList.contains(level)) {
            list.add(treeNode.val);
        }
        levelList.add(level);
        rightSide(treeNode.right, level + 1);
        rightSide(treeNode.left, level + 1);
    }

    public static TreeNode buildTree() {
        return new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
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
