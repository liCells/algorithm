import java.util.*;

public class 二叉树的四种遍历 {

    /**
     * 前序
     * 根结点 -> 左子树 -> 右子树
     */
    public static void VLR(TreeNode treeNode) {
        if (treeNode == null) return;
        System.out.print(treeNode.val);
        VLR(treeNode.left);
        VLR(treeNode.right);
    }

    /**
     * 前序 非递归
     * 根结点 -> 左子树 -> 右子树
     */
    public static void VLRNonRecursive(TreeNode treeNode) {
        if (treeNode == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.empty()) {
            while (treeNode != null) {
                System.out.print(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            treeNode = stack.pop();
            treeNode = treeNode.right;
        }
    }

    /**
     * 中序
     * 左子树 -> 根结点 -> 右子树
     */
    public static void LDR(TreeNode treeNode) {
        if (treeNode == null) return;
        LDR(treeNode.left);
        System.out.print(treeNode.val);
        LDR(treeNode.right);
    }

    /**
     * 中序 非递归
     * 左子树 -> 根结点 -> 右子树
     */
    public static void LDRNonRecursive(TreeNode treeNode) {
        if (treeNode == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.empty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            treeNode = stack.pop();
            System.out.print(treeNode.val);
            treeNode = treeNode.right;
        }
    }

    /**
     * 后序
     * 左子树 -> 右子树 -> 根结点
     */
    public static void LRD(TreeNode treeNode) {
        if (treeNode == null) return;
        LRD(treeNode.left);
        LRD(treeNode.right);
        System.out.print(treeNode.val);
    }

    /**
     * 后序 非递归
     * 左子树 -> 右子树 -> 根结点
     */
    public static void LRDNonRecursive(TreeNode treeNode) {
        if (treeNode == null) return;
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();
        while (treeNode != null || !stack.empty()) {
            while (treeNode != null) {
                list.addFirst(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.right;
            }
            treeNode = stack.pop();
            treeNode = treeNode.left;
        }
        System.out.print(list);
    }

    /**
     * 层次
     * 按照层次遍历, 每一层从左到右
     */
    public static void levelOrder(TreeNode treeNode) {
        if (treeNode == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * Morris 中序遍历
     */
    public static void morrisInOrderTraversal(TreeNode root) {
        TreeNode cur = root, mostRight;
        // 当前节点为空时, 说明访问完成
        while (cur != null) {
            // 左子树不存在时, 访问&设置右节点
            if (cur.left == null) {
                System.out.println(cur.val);
                cur = cur.right;
            } else {
                mostRight = cur.left;
                // 左子树存在, 寻找前驱节点. 注意寻找前驱节点时, 会不断深入右子树, 判断是否是已访问过的节点
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    // 前驱节点未访问过, 存放后继节点
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    // 前驱节点已访问过, 恢复树结构
                    System.out.println(cur.val);
                    // 确定访问过左子树后, 访问当前节点
                    mostRight.right = null;
                    cur = cur.right;
                }
            }
        }
    }

    public static void main(String[] args) {
//        VLR(buildTree());
//        VLRNonRecursive(buildTree());
//        LDR(buildTree());
//        LDRNonRecursive(buildTree());
        LRD(buildTree());
        LRDNonRecursive(buildTree());
//        levelOrder(buildTree());
//        morrisInOrderTraversal(buildTree());
    }

    /**
     * 1
     * 2   3
     * 4 5 6 7
     */
    public static TreeNode buildTree() {
        TreeNode left1_left2 = new TreeNode(4);
        TreeNode left1_right2 = new TreeNode(5);
        TreeNode right1_left2 = new TreeNode(6);
        TreeNode right1_right2 = new TreeNode(7);
        TreeNode left1 = new TreeNode(2, left1_left2, left1_right2);
        TreeNode right1 = new TreeNode(3, right1_left2, right1_right2);
        return new TreeNode(1, left1, right1);
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

