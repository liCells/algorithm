import java.util.*;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * 力扣 350 两个数组的交集
 * array
 */
public class 两个数组的交集 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1, 2}, new int[]{1, 2})));
    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            list.add(i);
        }
        List<Integer> arr = new ArrayList<>();
        for (int j : nums1) {
            if (list.contains(j)) {
                arr.add(j);
                list.remove(Integer.valueOf(j));
            }
        }
        return arr.stream().mapToInt(i -> i).toArray();
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int k : nums1) {
            Integer count = map.get(k);
            map.put(k, count == null ? 1 : ++count);
        }
        List<Integer> arr = new ArrayList<>();
        for (int j : nums2) {
            if (map.containsKey(j)) {
                arr.add(j);
                Integer integer = map.get(j);
                if (--integer == 0) {
                    map.remove(j);
                } else {
                    map.put(j, integer);
                }
            }
        }
        return arr.stream().mapToInt(i -> i).toArray();
    }

}
