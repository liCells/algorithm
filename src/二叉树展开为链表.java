import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * 力扣 114 二叉树展开为链表
 */
public class 二叉树展开为链表 {

    public static void main(String[] args) {
        TreeNode treeNode = buildTree();
        flatten2(treeNode);
        System.out.println(treeNode);
    }

    public static void flatten2(TreeNode root) {
        if (root == null) return;
        TreeNode cur = root;
        while (cur != null) {
            // 确认有没有左子树
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode mostRight = next;
                // 找到左子树的最右侧
                while (mostRight.right != null) {
                    mostRight = mostRight.right;
                }
                // 将上一级的右子树放到其左侧的最右侧
                mostRight.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }

    // ---------------------------------------------------
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
