/**
 * https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 * 力扣 606 根据二叉树创建字符串
 */
public class 根据二叉树创建字符串 {
    public static void main(String[] args) {
        System.out.println(tree2str(buildTree()));
    }

    public static String tree2str(TreeNode root) {
        if (root == null) return "()";
        StringBuilder str = new StringBuilder();
        buildStr(root, str);
        return str.substring(1, str.length() - 1);
    }

    public static void buildStr(TreeNode root, StringBuilder str) {
        str.append("(" + root.val);
        if (root.left != null) {
            buildStr(root.left, str);
        }
        if (root.right != null) {
            if (root.left == null) {
                str.append("()");
            }
            buildStr(root.right, str);
        }
        str.append(")");
    }

    public static TreeNode buildTree() {
        return new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(4, null, new TreeNode(5)));
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
