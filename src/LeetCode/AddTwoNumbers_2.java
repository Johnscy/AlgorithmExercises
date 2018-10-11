package LeetCode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers_2 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //Iteration
    class Solution_Iteration {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            ListNode dummy = new ListNode(-1),iteration = dummy;
            int carry = 0;
            while (l1 != null || l2 != null || carry != 0){
                if (l1 != null){
                    carry += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null){
                    carry += l2.val;
                    l2 = l2.next;
                }
                ListNode bit = new ListNode(carry % 10);
                iteration.next = bit;
                iteration = bit;
                carry /= 10;
            }
            return dummy.next;
        }
    }

    //Recursion
    class Solution_Recursion {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            return addTwoNumbersRecursive(l1,l2,0);
        }

        private ListNode addTwoNumbersRecursive(ListNode p1, ListNode p2, int carry){
            if (p1 == null && p2 == null){
                if (carry == 0)
                    return null;
                else
                    return new ListNode(carry);
            }
            if (p1 != null){
                carry += p1.val;
                p1 = p1.next;
            }
            if (p2 != null){
                carry += p2.val;
                p2 = p2.next;
            }
            ListNode nextNode = addTwoNumbersRecursive(p1,p2,carry / 10);
            ListNode curNode = new ListNode(carry % 10);
            curNode.next = nextNode;
            return curNode;
        }
    }
}
