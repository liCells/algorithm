import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * 力扣 114 二叉树展开为链表
 */
public class 二叉树展开为链表 {

    public static void main(String[] args) {
        TreeNode treeNode = buildTree();
        flatten(treeNode);
        System.out.println(treeNode);
    }

    static LinkedList<TreeNode> list = new LinkedList<>();

    public static void flatten(TreeNode root) {
        if (root == null) return;
        beforeOrder(root.left);
        beforeOrder(root.right);
        TreeNode temp = root;
        // 清空root
        root.left = null;
        root.right = null;
        // 构建链式结构
        for (TreeNode node : list) {
            root.right = node;
            root = root.right;
        }
        // 还原指针
        root = temp;
    }

    public static void beforeOrder(TreeNode root) {
        if (root == null) return;
        list.add(root);
        beforeOrder(root.left);
        beforeOrder(root.right);
        // 清空子树
        root.left = null;
        root.right = null;
    }

    public static TreeNode buildTree() {
        TreeNode left1_left2 = new TreeNode(4);
        TreeNode left1_right2 = new TreeNode(5);
        TreeNode left1 = new TreeNode(2, left1_left2, left1_right2);
        TreeNode right1 = new TreeNode(3);
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
