package LeetCode;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class ReverseLinkedListII_92 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //Iteration      one pass
    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (head == null || head.next == null || n <= m)
                return head;
            ListNode dummy = new ListNode(-1),pre = dummy;
            dummy.next = head;
            for (int i = 0; i < m - 1; i++) {
                pre = pre.next;
            }
            ListNode start = pre.next, next = start.next;
            for (int i = 0; i < n - m; i++) {
                start.next = next.next;
                next.next = pre.next;
                pre.next = next;
                next = start.next;
            }
            return dummy.next;
        }

    }
}
