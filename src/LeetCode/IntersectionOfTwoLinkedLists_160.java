package LeetCode;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * Example 1:
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 */
public class IntersectionOfTwoLinkedLists_160 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //a+b+c = c+b+a
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null)
                return null;
            ListNode curA = headA, curB = headB;
            while (!(curA == null && curB == null)){
                if (curA == null)
                    curA = headB;
                if (curB == null)
                    curB = headA;
                if(curA == curB)
                    return curA;
                curA = curA.next;
                curB = curB.next;
            }
            return null;
        }
    }
}
