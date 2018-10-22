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

    //在一个链表里进行操作
    class Solution {
        public ListNode partition(ListNode head, int x) {
            if (head == null || head.next == null)
                return head;
            ListNode dummy = new ListNode(Integer.MIN_VALUE);
            dummy.next = head;
            ListNode prevLessThanX = dummy, pre = dummy;
            while (head != null){
                if (head.val < x){
                    if (pre.val >= x) {
                        pre.next = head.next;
                        if (dummy.next != head)
                            head.next = prevLessThanX.next;
                        prevLessThanX.next = head;
                    }else {
                        pre = pre.next;
                    }
                    prevLessThanX = head;
                }else {
                    pre = pre.next;
                }
                head = pre.next;
            }
            return dummy.next;
        }
    }

    //按大小分到两个链表，然后连接起来
    class Solution_Merge2List {
        public ListNode partition(ListNode head, int x) {
            if (head == null || head.next == null)
                return head;
            ListNode dummy1 = new ListNode(-1), dummy2 = new ListNode(-1);
            ListNode cur1 = dummy1, cur2 = dummy2;
            while (head != null) {
                if (head.val < x) {
                    cur1.next = head;
                    cur1 = head;
                    head = head.next;
                    cur1.next = null;
                }else {
                    cur2.next = head;
                    cur2 = head;
                    head = head.next;
                    cur2.next = null;
                }
            }
            cur2.next = null;
            cur1.next = dummy2.next;
            return dummy1.next;
        }
    }
}
