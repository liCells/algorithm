import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle/
 * 力扣 118 杨辉三角
 */
public class 杨辉三角 {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    static List<List<Integer>> list = new ArrayList<>();

    static Integer num;

    public static List<List<Integer>> generate(int numRows) {
        num = numRows;
        // 初始化第一层
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        list.add(arr);
        // 确认为1层时直接返回
        if (numRows == 1) return list;
        build(arr, new ArrayList<>(), 2);
        return list;
    }

    public static void build(List<Integer> pro, List<Integer> cur, int length) {
        // 固定值
        cur.add(1);
        for (int i = 1; i < length - 1; i++) {
            // 计算该位置对应值
            cur.add(pro.get(i) + pro.get(i - 1));
        }
        cur.add(1);
        list.add(cur);
        // 等于层数时停止
        if (length != num) {
            build(cur, new ArrayList<>(), ++length);
        }
    }
}
