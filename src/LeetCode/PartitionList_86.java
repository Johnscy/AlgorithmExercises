package LeetCode;


/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
public class PartitionList_86 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode partition(ListNode head, int x) {
            if (head == null || head.next == null)
                return head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode prevLessThanX = dummy, cur = head, pre = head;
            while (cur != null){
                if (cur.val < x){
                    if (pre.val >= x)
                        pre.next = cur.next;
                    if (cur != head)
                        cur.next = prevLessThanX.next;
                    prevLessThanX.next = cur;
                    prevLessThanX = cur;
                }
                if (pre != head)
                    pre = pre.next;
                cur = pre.next;
            }
            return dummy.next;
        }
    }
}
