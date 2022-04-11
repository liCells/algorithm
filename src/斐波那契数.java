/**
 * https://leetcode-cn.com/problems/fibonacci-number/
 * 力扣 509 斐波那契数
 */
public class 斐波那契数 {
    public static void main(String[] args) {
        System.out.println(fib(7));
        System.out.println(fib1(7));
    }

    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n - 1];
    }

    // 更优解，空间复杂度O(1)
    public static int fib1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int var1 = 1, var2 = 2;
        int box = 0;
        for (int i = 3; i < n; i++) {
            box = var1 + var2;
            var1 = var2;
            var2 = box;
        }
        return box;
    }
}
