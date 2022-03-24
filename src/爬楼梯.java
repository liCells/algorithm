/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 力扣 70 爬楼梯
 *
 * 一次可以爬1或者2层
 * 1 <= n <= 45
 *
 * 动态规划
 */
public class 爬楼梯 {
    public static void main(String[] args) {
        System.out.println(climbStairs2(5));
    }

    public static int climbStairs2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int var1 = 1, var2 = 2;
        for (int i = 2; i < n; i++) {
            int temp = var1 + var2;
            var1 = var2;
            var2 = temp;
        }
        return var2;
    }

    public static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n - 1];
    }
}
