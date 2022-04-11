import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * 力扣 322 零钱兑换
 */
public class 零钱兑换 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{186, 419, 83, 408}, 6249));
    }

    static int[] nums;

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        nums = new int[amount + 1];
        // 注意设置特殊值时不要与默认返回值一致
        Arrays.fill(nums, -2);

        return dp(coins, amount);
    }

    private static int dp(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (nums[amount] != -2) return nums[amount];
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int num = dp(coins, amount - coin);
            if (num == -1) continue;
            res = Math.min(num + 1, res);
        }
        int val = res == Integer.MAX_VALUE ? -1 : res;
        nums[amount] = val;
        return val;
    }
}
