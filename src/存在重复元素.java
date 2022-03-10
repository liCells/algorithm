import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/contains-duplicate/
 * 力扣 217 存在重复元素
 * hash array
 */
public class 存在重复元素 {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[] {1, 2, 3, 4}));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
