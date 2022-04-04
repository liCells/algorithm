/**
 * https://leetcode-cn.com/problems/increasing-order-search-tree/
 * 力扣 897 递增顺序搜索树
 */
public class 递增顺序搜索树 {
    public static void main(String[] args) {
        System.out.println(increasingBST(buildTree1()));
    }

    public static TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        // 向子树的左侧遍历获取到最右侧的子树，并把当前节点放到子树的right
        // 再向左子树遍历，循环处理，直到最左侧后，再按照每一个right进行回溯
        TreeNode cur = root, pre, record = new TreeNode(), special = record;
        while (cur != null) {
            if (cur.left != null) {
                pre = cur.left;
                TreeNode mostRight = pre;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    pre.left = null;
                }
            }
            special.right = cur;
            special = cur;
            cur = cur.right;
        }
        // 剪去多余左侧叶子
        TreeNode node = record.right;
        while (node != null) {
            node.left = null;
            node = node.right;
        }
        return record.right;
    }

    /*
        5
      3   6
     2 4   8
    1     7 9
     */
    public static TreeNode buildTree() {
        return new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2, new TreeNode(1), null),
                        new TreeNode(4)
                ),
                new TreeNode(6,
                        null,
                        new TreeNode(8,
                                new TreeNode(7),
                                new TreeNode(9)
                        )
                )
        );
    }

    public static TreeNode buildTree1() {
        return new TreeNode(2,
                new TreeNode(1),
                new TreeNode(4,
                        new TreeNode(3),
                        null
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
