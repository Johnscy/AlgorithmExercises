package LeetCode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 * Input: 1->2
 * Output: false
 *
 * Example 2:
 * Input: 1->2->2->1
 * Output: true
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList_234 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //Reverse        O(n) time and O(1) space
    class Solution_Reverse {
        public boolean isPalindrome(ListNode head) {
            if (head == null)   return true;
            if (head.next == null)  return true;
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }
            if (fast != null)     //链表奇数个结点。
                slow = slow.next;
            slow = reverseList(slow);
            fast = head;
            while (slow != null){
                if (fast.val != slow.val)
                    return false;
                fast = fast.next;
                slow = slow.next;
            }
            return true;
        }

        private ListNode reverseList(ListNode node){
            ListNode pre = null;
            while (node != null){
                ListNode next = node.next;
                node.next = pre;
                pre = node;
                node = next;
            }
            return pre;
        }
    }

    //Recursion      not O(1) space
    class Solution_Recursion {
        ListNode h = null;
        public boolean isPalindrome(ListNode head) {
            if (head == null)   return true;
            if (h == null)  h = head;
            boolean checkResult = true;
            if (head.next != null)
                checkResult &= isPalindrome(head.next);
            checkResult &= (head.val == h.val);
            h = h.next;
            return checkResult;
        }
    }
}
