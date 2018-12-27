package LeetCode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)
 * in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 *
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycleII_142 {

    //Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //找出环的入口
    //Two pointers       fast & slow
    //当fast == slow时，将其中一个指向head，另一个原地不动，然后一起推进，当相遇时，结点即为环的入口。
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null)
                return null;
            ListNode fast = head,slow = head;
            while (fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow)
                    break;
            }
            if (fast == slow) {
                fast = head;
                while (fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }else
                return null;
        }
    }
}
