package LeetCode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 *
 * Example 2:
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class SortList_148 {
    //Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //归并排序
    public class Solution {
        public ListNode sortList(ListNode head) {
            if(head == null || head.next == null)
                return head;
            ListNode mid = getMid(head);
            ListNode right = mid.next;
            mid.next = null;
            return mergeSort(sortList(head),sortList(right));
        }

        private ListNode getMid(ListNode node){
            if(node == null || node.next == null)
                return node;
            ListNode fast = node, slow = node;
            while(fast.next != null && fast.next.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        private ListNode mergeSort(ListNode l, ListNode r){
            ListNode head = new ListNode(0);
            ListNode left = l, right = r, cur = head;
            while(left != null && right != null){
                if(left.val <= right.val){
                    cur.next = left;
                    left = left.next;
                }else{
                    cur.next = right;
                    right = right.next;
                }
                cur = cur.next;
            }
            cur.next = left == null ? right : left;
            return head.next;
        }
    }
}
