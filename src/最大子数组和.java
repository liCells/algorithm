/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 力扣 53 最大子数组和
 */
public class 最大子数组和 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {3, 4, -7, 1, 2, 3, 4}));
    }

    public static int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int curMaxSum = 0;
        for (int num : nums) {
            curMaxSum = Math.max(num, curMaxSum + num);
            sum = Math.max(curMaxSum, sum);
        }
        return sum;
    }

//    public static int maxSubArray(int[] nums) {
//        int sum = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            int curSum = 0;
//            for (int j = i; j < nums.length; j++) {
//                curSum += nums[j];
//                if (curSum > sum) {
//                    sum = curSum;
//                }
//            }
//        }
//        return sum;
//    }
}
