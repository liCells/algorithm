import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 力扣 26 删除有序数组中的重复项
 * <p>
 * nums为有序数组
 * 仅使用O(1)1额外空间
 * <p>
 * 双指针
 */
public class 删除有序数组中的重复项 {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        while (j < nums.length) {
            // 如果相等，向后移动j，不相等就移动
            if (nums[i] != nums[j]) {
                i++;
                if (i != j) {
                    nums[i] = nums[j];
                }
            }
            j++;
        }
        return ++i;
    }
}
