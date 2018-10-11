package LeetCode;

import java.util.Stack;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 *
 * Example:
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbersII_445 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //Stack
    class Solution_Stack {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            Stack<Integer> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            ListNode dummy = new ListNode(-1);
            while (l1 != null){
                stack1.push(l1.val);
                l1 = l1.next;
            }
            while (l2 != null){
                stack2.push(l2.val);
                l2 = l2.next;
            }
            int carry = 0;
            while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
                if (!stack1.isEmpty()){
                    carry += stack1.pop();
                }
                if (!stack2.isEmpty()){
                    carry += stack2.pop();
                }
                ListNode node = new ListNode(carry % 10);
                carry /= 10;
                node.next = dummy.next;
                dummy.next = node;
            }
            return dummy.next;
        }
    }

    //Recursion 计算出两条链表长度，将当前位相加存于cur结点中，按末位对齐递归各位相加存于next结点中，
    // 判断next.val是否大于9，大于9说明对cur结点有进位，cur.val += 1，next.val %= 10。最后判断首位有无进位。
    class Solution_Recursion {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            int len1 = getLength(l1), len2 = getLength(l2);
            ListNode head = new ListNode(1); //妙啊，首位有进位，则此为结果首位；若无进位，取head.next作为结果头结点。
            head.next = len1 >= len2 ? add(l1,l2,len1 - len2) : add(l2,l1,len2 - len1);
            if (head.next.val > 9){     //判断首位有无进位
                head.next.val %= 10;
                return head;
            }
            return head.next;
        }

        private int getLength(ListNode l){
            int count = 0;
            while (l != null){
                count++;
                l = l.next;
            }
            return count;
        }

        private ListNode add(ListNode p, ListNode q, int len){ //输入就是p 长度 >= q
            if (p == null)  return null;
            ListNode cur = new ListNode(p.val + (len == 0 ? q.val : 0));
            ListNode next = len == 0 ? add(p.next,q.next,0) : add(p.next,q,len - 1);
            if (next != null && next.val > 9){
                cur.val += 1;
                next.val -= 10;
            }
            cur.next = next;
            return cur;
        }
    }

    //Iteration 计算出两条链表长度，按末位对齐各位相加(先不管进位，也就是说有结点的值大于9)
    //结点采用前插法，得到逆序的结果链表res。再从头扫一遍res，处理大于9的结点值。
    class Solution_Iteration2 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            int len1 = getLength(l1), len2 = getLength(l2);
            ListNode res = null;
            while (len1 > 0 && len2 > 0){
                int bitSum = 0;
                if (len1 >= len2){
                    bitSum += l1.val;
                    l1 = l1.next;
                    len1--;
                }
                if (len1 < len2){
                    bitSum += l2.val;
                    l2 = l2.next;
                    len2--;
                }
                res = addToFront(res,bitSum);   //结果链表res，按位相加的结果，但是某些结点的值大于9
            }
            ListNode cur = res; //重新扫一遍结果链表res，处理进位问题
            res = null;int carry = 0;
            while (cur != null){
                cur.val += carry;
                carry = cur.val / 10;
                res = addToFront(res,cur.val % 10);
                cur = cur.next;
            }
            return res;
        }

        private int getLength(ListNode l){
            int count = 0;
            while (l != null){
                count++;
                l = l.next;
            }
            return count;
        }

        private ListNode addToFront(ListNode head, int val){
            ListNode node = new ListNode(val);
            node.next = head;
            return node;
        }
    }
}
