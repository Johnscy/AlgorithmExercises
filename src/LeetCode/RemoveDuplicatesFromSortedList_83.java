package LeetCode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 * Input: 1->1->2
 * Output: 1->2
 *
 * Example 2:
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class RemoveDuplicatesFromSortedList_83 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //Recursion
    class Solution_Recursion {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode node = head.next;
            if (head.val == node.val) {
                while (node != null && head.val == node.val)
                    node = node.next;
            }
                head.next = deleteDuplicates(node);
                return head;
        }
    }

    //Iteration
    class Solution_Iteration {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode cur = head;
            while (cur != null && cur.next != null){
                ListNode node = cur.next;
                while (node != null && cur.val == node.val)
                    node = node.next;
                cur.next = node;
                cur = node;
            }
            return head;
        }
    }
}
