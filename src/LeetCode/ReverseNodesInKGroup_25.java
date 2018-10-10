package LeetCode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseNodesInKGroup_25 {
    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //Recursion
    class Solution_Recursion {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null || k <= 1)
                return head;
            ListNode cur = head;
            int count = 0;
            while (cur != null && count != k){
                cur = cur.next;
                count++;
            }
            if (count == k){    //cur指向第k+1个结点
                cur = reverseKGroup(cur,k);
                while (count-- > 0){
                    ListNode next = head.next;
                    head.next = cur;
                    cur = head;
                    head = next;
                }
                head = cur;
            }
            return head;
        }
    }

    //Iteration
    class Solution_Iteration {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null || k <= 1)
                return head;
            ListNode dummy = new ListNode(-1), start = dummy;
            dummy.next = head;
            while (true){
                ListNode p = start, tail = p, cur;
                start = p.next;
                for (int i = 0; i < k && tail != null; i++) tail = tail.next;
                if (tail == null)   break;
                for (int i = 0; i < k - 1; i++) {
                    cur = p.next;
                    p.next = cur.next;
                    cur.next = tail.next;
                    tail.next = cur;
                }
            }
            return dummy.next;
        }
    }
}
