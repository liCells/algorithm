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

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
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
