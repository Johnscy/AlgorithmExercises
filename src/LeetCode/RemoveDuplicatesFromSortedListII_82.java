package LeetCode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Example 1:
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 *
 * Example 2:
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class RemoveDuplicatesFromSortedListII_82 {

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
            if (head.val == node.val){
                while (node != null && head.val == node.val)
                    node = node.next;
                return deleteDuplicates(node);
            }else{
                head.next = deleteDuplicates(node);
                return head;
            }
        }
    }

    //Iteration
    class Solution_Iteration {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode cur = head , pre = dummy;
            while (cur != null && cur.next != null){
                ListNode node = cur.next;
                while (node != null && cur.val == node.val)
                    node = node.next;
                if (cur.next != node)
                    pre.next = node;
                else
                    pre = cur;
                cur = node;
            }
            return dummy.next;
        }
    }
}
