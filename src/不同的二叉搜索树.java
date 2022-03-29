import java.math.BigDecimal;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * 力扣 96 不同的二叉搜索树
 * TODO 动态规划
 */
public class 不同的二叉搜索树 {

    public static void main(String[] args) {
        System.out.println(numTrees(19));
    }

    public static int numTrees(int n) {
        if (n == 1) return 1;
        // 多1
        if (n == 2) return 2;
        // 多3
        if (n == 3) return 5;
        // 多9
        if (n == 4) return 14;
        // 多28
        if (n == 5) return 42;
        BigDecimal[] arr = new BigDecimal[n + 1];
        arr[0] = new BigDecimal(1);
        arr[1] = new BigDecimal(1);
        arr[2] = new BigDecimal(2);
        arr[3] = new BigDecimal(5);
        for (int i = 3; i <= n; i++) {
            BigDecimal v = new BigDecimal((2F * (2F * (i - 1F) + 1F))).divide(new BigDecimal((i - 1F) + 2F)).multiply(arr[i - 1]);
            arr[i] = v;
        }
        return arr[n].intValue();
    }
}