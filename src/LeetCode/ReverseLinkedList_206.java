package LeetCode;

/**
 * Reverse a singly linked list.
 *
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList_206 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //Recursion
    class Solution_Recursion {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode node = head.next;
            head.next = null;
            ListNode newHead = reverseList(node);
            node.next = head;
            return newHead;
        }
    }

    //Iteration
    class Solution_Iteration {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode dummy = new ListNode(-1);
            while (head != null){
                ListNode node = head.next;
                head.next = dummy.next;
                dummy.next = head;
                head = node;
            }
            return dummy.next;
        }
    }
}
