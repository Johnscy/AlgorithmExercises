package Target_To_Offer;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class EntryNodeOfLoop {
     public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    //快慢指针法
    public class Solution {
        public ListNode EntryNodeOfLoop(ListNode pHead) {
            if (pHead == null || pHead.next == null)
                return null;
            ListNode fast, slow;
            fast = slow = pHead;
            while (fast.next != null && slow != null){
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow){
                    fast = pHead;
                    while (fast != slow){
                        fast = fast.next;
                        slow = slow.next;
                    }
                    return fast;
                }
            }
            return null;
        }
    }
}
