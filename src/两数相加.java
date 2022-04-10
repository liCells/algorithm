import java.math.BigInteger;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 力扣 2 两数相加
 * <p>
 * 两个非空的链表
 * 头为零的一定是零
 * 逆序存储
 */
public class 两数相加 {
    public static void main(String[] args) {
        // 1 00000000000000000000000000000 1
        System.out.println(addTwoNumbers(
                new ListNode(1,
                        new ListNode(0,
                                new ListNode(0,
                                        new ListNode(0,
                                                new ListNode(0,
                                                        new ListNode(0,
                                                                new ListNode(0,
                                                                        new ListNode(0,
                                                                                new ListNode(0,
                                                                                        new ListNode(0,
                                                                                                new ListNode(0,
                                                                                                        new ListNode(0,
                                                                                                                new ListNode(0,
                                                                                                                        new ListNode(0,
                                                                                                                                new ListNode(0,
                                                                                                                                        new ListNode(0,
                                                                                                                                                new ListNode(0,
                                                                                                                                                        new ListNode(0,
                                                                                                                                                                new ListNode(0,
                                                                                                                                                                        new ListNode(0,
                                                                                                                                                                                new ListNode(0,
                                                                                                                                                                                        new ListNode(0,
                                                                                                                                                                                                new ListNode(0,
                                                                                                                                                                                                        new ListNode(0,
                                                                                                                                                                                                                new ListNode(0,
                                                                                                                                                                                                                        new ListNode(0,
                                                                                                                                                                                                                                new ListNode(0,
                                                                                                                                                                                                                                        new ListNode(0,
                                                                                                                                                                                                                                                new ListNode(0,
                                                                                                                                                                                                                                                        new ListNode(0, new ListNode(1)))))))))))))))))))))))))))))
                        )
                ),
                new ListNode(4,
                        new ListNode(6, new ListNode(5))
                )
        ));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger sum = listNodeToInt(l1).add(listNodeToInt(l2));
        ListNode node = new ListNode();
        ListNode cur = node;
        char[] array = String.valueOf(sum).toCharArray();
        for (int i = array.length - 1; i >= 0; i--) {
            cur.val = Character.getNumericValue(array[i]);
            if (i != 0) {
                cur.next = new ListNode();
                cur = cur.next;
            }
        }
        return node;
    }

    public static BigInteger listNodeToInt(ListNode listNode) {
        // 单位
        int unit = 0;
        BigInteger sum = new BigInteger("0");
        while (listNode != null) {
            BigInteger val = new BigInteger("1");
            for (int i = 0; i < unit; i++) {
                val = val.multiply(new BigInteger("10"));
            }
            sum = sum.add(val.multiply(new BigInteger(String.valueOf(listNode.val))));
            unit++;
            listNode = listNode.next;
        }
        return sum;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
