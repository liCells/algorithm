import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * 力扣 88 合并两个有序数组
 */
public class 合并两个有序数组 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 0};
        merge(arr, 3, new int[]{-1}, 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 计算两个数组总长, 并将对应的length值减一
        int i = m-- + --n;

        while (n >= 0) {
            // 从最后一位循环, 判断两个有序数组中最后一位大小
            nums1[i--] =
                    m >= 0 && nums1[m] > nums2[n]
                            ? nums1[m--]
                            : nums2[n--];
        }
    }

}
