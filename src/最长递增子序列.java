import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 力扣 300 最长递增子序列
 */
public class 最长递增子序列 {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{0, 3, 1, 2, 0, 3, 2, 4}));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        // 全部赋值为1，避免没找到更小值时重新赋值
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            // 找到这个数之前的最长子序列长度
            int biggestInFront = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    biggestInFront = Math.max(dp[j] + 1, biggestInFront);
                }
            }
            dp[i] = biggestInFront;
            // 比对该位置是否是最长的
            max = Math.max(biggestInFront, max);
        }
        return max;
    }
}
