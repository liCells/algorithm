/**
 * https://leetcode-cn.com/problems/fibonacci-number/
 * 力扣 509 斐波那契数
 */
public class 斐波那契数 {
    public static void main(String[] args) {
        System.out.println(fib(5));
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
}
