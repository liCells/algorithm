/**
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 * 力扣 109 有序数组转化为二叉搜索树
 * binary tree
 * 注意理解中序遍历的顺序
 */
public class 有序链表转化为二叉搜索树 {
    public static void main(String[] args) {
        TreeNode treeNode = sortedArrayToBST(new ListNode(1, new ListNode(2, new ListNode(3))));
        System.out.println(treeNode);
    }

    public static TreeNode sortedArrayToBST(ListNode head) {
        if (head == null) return null;
        int len = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            len++;
        }
        root = head;
        return build(0, len - 1);
    }

    static ListNode root = null;

    public static TreeNode build(int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode treeNode = new TreeNode();
        int middle = (left + right) / 2;
        treeNode.left = build(left, middle - 1);
        treeNode.val = root.val;
        root = root.next;
        treeNode.right = build(middle + 1, right);
        return treeNode;
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

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
