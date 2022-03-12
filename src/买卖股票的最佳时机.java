/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 力扣 121 买卖股票的最佳时机
 * array 动态规划
 */
public class 买卖股票的最佳时机 {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 1) return 0;
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

}
