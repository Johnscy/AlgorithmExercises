package LeetCode;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class RemoveLinkedListElements_203 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //Recursion
    class Solution_Recursion {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null)
                return head;
            head.next = removeElements(head.next,val);
            return head.val == val ? head.next : head;
        }
    }

    //Iteration
    class Solution_Iteration {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null)
                return head;
            ListNode dummy = new ListNode(-1), pre = dummy;
            dummy.next = head;
            while (head != null){
                if (head.val != val){
                    pre = pre.next;
                }else{
                    pre.next = head.next;
                }
                head = head.next;
            }
            return dummy.next;
        }
    }
}
