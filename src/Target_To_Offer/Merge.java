package Target_To_Offer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Merge {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public class Solution {
        public ListNode Merge(ListNode list1,ListNode list2) {
            ListNode list = new ListNode(-1);
            ListNode cur = list;
            while (list1 != null && list2 != null){
                if (list1.val <= list2.val){
                    cur.next = list1;
                    list1 = list1.next;
                } else {
                    cur.next = list2;
                    list2 = list2.next;
                }
                cur = cur.next;
            }
            if (list1 != null)
                cur.next = list1;
            if (list2 != null)
                cur.next = list2;
            return list.next;
        }
    }
}
