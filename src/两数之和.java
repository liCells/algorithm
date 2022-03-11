import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * 力扣 1 两数之和
 */
public class 两数之和 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3}, 3)));
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {i, map.get(nums[i])};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }

}
