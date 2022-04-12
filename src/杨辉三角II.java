import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle-ii/
 * 力扣 119 杨辉三角II
 */
public class 杨辉三角II {
    public static void main(String[] args) {
        System.out.println(getRow(3));
    }

    static Integer num;

    public static List<Integer> getRow(int rowIndex) {
        num = rowIndex + 1;
        // 初始化第一层
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        // 确认为1层时直接返回
        if (rowIndex == 0) return arr;
        return build(arr, new ArrayList<>(), 1);
    }

    public static List<Integer> build(List<Integer> pro, List<Integer> cur, int length) {
        // 固定值
        cur.add(1);
        for (int i = 1; i < length - 1; i++) {
            // 计算该位置对应值
            cur.add(pro.get(i) + pro.get(i - 1));
        }
        cur.add(1);
        // 等于层数时停止
        if (length != num) {
            return build(cur, new ArrayList<>(), ++length);
        }
        return cur;
    }
}
