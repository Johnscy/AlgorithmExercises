package Target_To_Offer;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * 思路： 如果存在共同节点的话，那么从该节点，两个链表之后的元素都是相同的。
 * 设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
 * 当访问 A 链表的指针访问到链表尾部时，令它从链表 B 的头部重新开始访问链表 B；
 * 同样地，当访问 B 链表的指针访问到链表尾部时，令它从链表 A 的头部重新开始访问链表 A。
 * 这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
 */
public class FindFirstCommonNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            ListNode p1 = pHead1, p2 = pHead2;
            while (p1 != p2){
                p1= p1 == null ? pHead2 : p1.next;
                p2 = p2 == null ? pHead1 : p2.next;
            }
            return p1;
        }
    }
}
