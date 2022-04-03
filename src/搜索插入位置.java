/**
 * https://leetcode-cn.com/problems/search-insert-position/
 * 力扣 35 搜索插入位置
 * <p>
 * nums为有序不重复数组
 * 时间复杂度 O(log n) -> 二分查找
 */
public class 搜索插入位置 {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5}, 6));
    }

    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
