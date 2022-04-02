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

    public static int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 2) {
            return (nums[0] + nums[1]) == target ? new int[] {0, 1} : null;
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        // 双指针查找
        for (int i = 0, j = nums.length - 1; i < nums.length / 2 + 1 && j > nums.length / 2 - 1; i++, j--) {
            if (map.containsKey(nums[i])) {
                return new int[] {i, map.get(nums[i])};
            }
            // 查一次就直接放入，否则刚好同时拿到两个一样的值会导致计算出错
            // [3, 3, 3] => 6
            // 这种情况如果放到下面put会导致第二个指针没有判断到第一个值
            map.put(target - nums[i], i);
            if (map.containsKey(nums[j])) {
                return new int[] {j, map.get(nums[j])};
            }
            map.put(target - nums[j], j);
        }
        return null;
    }

}
