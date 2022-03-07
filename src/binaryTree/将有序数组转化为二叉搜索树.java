package binaryTree;

import java.text.ParseException;

/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * 力扣 108 将有序数组转化为二叉搜索树
 */
public class 将有序数组转化为二叉搜索树 {
    public static void main(String[] args) throws ParseException {
        System.out.println(sortedArrayToBST(new int[] {-10, -3, 0, 5, 9}));
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        return build(nums, 0, nums.length - 1);
    }

    public static TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = (left + right) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left =  build(nums, left, middle - 1);
        root.right =  build(nums, middle + 1, right);
        return root;
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
