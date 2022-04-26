import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 * 力扣 703 数据中的第K大元素
 *
 * 8 5 4 2 ^ 3
 * 8 5 4 3 2 - 4
 * 8 5 5 4 3 2 - 5
 * 10 8 5 5 4 3 2 - 5
 * 10 9 8 5 5 4 3 2 - 8
 * 10 9 8 5 5 4 4 3 2 - 8
 */
public class 数据流中的第K大元素 {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(11));
        System.out.println(kthLargest.add(2));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }

    static class KthLargest {
        List<Integer> list = new ArrayList<>();

        Integer kVal = null;

        Integer k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            if (nums.length == 0) return;
            for (int num : nums) {
                list.add(num);
            }
            Collections.sort(list);
            Collections.reverse(list);
            kVal = list.get(k - 1);
        }

        public int add(int val) {
            if (kVal == null) {
                kVal = val;
                list.add(val);
                return kVal;
            }
            // 如果小于原先的值，那么直接返回之前的
            if (val <= kVal) return kVal;
            // 如果k == 1，那么直接返回val
            if (k == 1) {
                list.set(0, val);
                return kVal = val;
            }
            // 如果大于原先的值，那么获取
            for (int i = 0; i < k; i++) {
                Integer integer = list.get(i);
                if (integer < val) {
                    list.set(i, val);
                    val = integer;
                }
            }
            return kVal = list.get(k - 1);
        }
    }
}
