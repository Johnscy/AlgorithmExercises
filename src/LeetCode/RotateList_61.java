package LeetCode;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 */
public class RotateList_61 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null || k == 0)
                return head;
            int len = 1;
            ListNode tail = head;
            while (tail.next != null){
                tail = tail.next;
                len++;
            }
            tail.next = head;   //连成环
            for (int i = 0; i < len - k % len; i++) {
                tail = tail.next;
            }
            head = tail.next;
            tail.next = null;
            return head;
        }
    }
}
