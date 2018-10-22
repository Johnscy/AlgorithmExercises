package LeetCode;

/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycle_141 {

    //Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //Two Pointers
    public class Solution_TwoPointers {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null)
                return false;
            ListNode fast = head, slow = head;
            while (fast.next != null && fast.next.next != null){
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow)
                    return true;
            }
            return false;
        }
    }

    //Recursion
    public class Solution_Recursion {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null)
                return false;
            if (head.next == head)
                return true;
            ListNode nextNode = head.next;
            head.next = head;
            return hasCycle(nextNode);
        }
    }
}
