import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 力扣 160 相交链表
 *
 * 返回相交的起始节点;
 * 不存在相交节点, 返回null;
 * 链式结构中不存在环;
 * 链表必须保持原结构;
 *
 * 通过迭代将数据都放到set中, 再处理第二个时, 如果有包含的则证明是相交的
 */
public class 相交链表 {
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        ListNode headB = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        headA.next = node3;
        headB.next = node4;
        ListNode node5 = new ListNode(5);
        node3.next = node5;
        node4.next = node5;
        System.out.println(getIntersectionNode(headA, headB).val);
    }

    /**
     * m == headA的长度 n == headB的长度
     * O(m+n)
     * O(m)
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode var1 = headA, var2 = headB;
        Set<ListNode> set = new HashSet<>();
        while (var1 != null) {
            set.add(var1);
            var1 = var1.next;
        }
        while (var2 != null) {
            if (set.contains(var2)) {
                return var2;
            }
            var2 = var2.next;
        }
        return null;
    }

    /**
     * m == headA的长度 n == headB的长度
     * O(m+n)
     * O(1)
     */
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode var1 = headA, var2 = headB;
        while (var1 != var2) {
            var1 = var1 == null ? headB : headA.next;
            var2 = var2 == null ? headA : headB.next;
        }
        return var1;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}