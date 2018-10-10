package LeetCode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Note:
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class SwapNodesInPairs_24 {
    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //递归Recursion
    class Solution_Recursion {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode node = head.next;
            head.next = swapPairs(head.next.next);
            node.next = head;
            return node;
        }
    }

    //循环Iteration
    class Solution_Iteration_1 {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode cur = dummy;
            while (cur.next != null && cur.next.next != null){
                ListNode first = cur.next;
                ListNode second = cur.next.next;
                first.next = second.next;
                cur.next = second;
                cur.next.next = first;
                cur = cur.next.next;
            }
            return dummy.next;
        }
    }

    //循环Iteration without dummy
    class Solution_Iteration_2 {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode newHead = head.next;
            ListNode first = head, second = first.next, pre = null;
            while (first != null && second != null){
                first.next = second.next;
                second.next = first;
                if (pre != null)
                    pre.next = second;
                if (first.next == null)
                    break;
                second = first.next.next;
                pre = first;
                first = first.next;
            }
            return newHead;
        }
    }
}
