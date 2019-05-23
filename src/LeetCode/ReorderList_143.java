package LeetCode;
import java.util.*;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 *
 * Example 2:
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class ReorderList_143 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //Two Pointers
    //思路：先用快慢双指针找到中点（注意用fast != null && fast.next != null来判定），然后把后面一截翻转，
    // 再将两段依次你一个我一个的重新排列链接。
    class Solution_TwoPointers {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null || head.next.next == null)
                return;
            //双指针找到中点
            ListNode fast = head, slow = head, prev = null;
            while (fast != null && fast.next != null){
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            prev.next = null;   //！！！！！要把前后两条链的连接断开
            //逆序后一段
            ListNode dummy = new ListNode(-1);
            while (slow != null){
                ListNode next = slow.next;
                slow.next = dummy.next;
                dummy.next = slow;
                slow = next;
            }
            //合并两段
            ListNode l1 = head, l2 = dummy.next, n1 = null, n2 = null;
            while (l1 != null){
                n1 = l1.next;
                n2 = l2.next;
                l1.next = l2;
                if (n1 == null) break;
                l2.next = n1;
                l1 = n1;
                l2 = n2;
            }
        }
    }

    //HashMap
    class Solution_HashMap {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null || head.next.next == null)
                return;
            Map<Integer,ListNode> map = new HashMap<>();
            ListNode cur = head;
            for (int i = 0;cur != null;i++,cur = cur.next){
                map.put(i,cur);
            }
            ListNode dummy = new ListNode(-1), prev = dummy, first = null, last = null;
            for (int i = 0,j = map.size() - 1;i <= j;i++,j--){
                first = map.get(i);
                prev.next = first;
                if (i == j){    //如果结点为奇数个，最后会出现i == j的情况
                    first.next = null;
                    return;
                }
                last = map.get(j);
                first.next = last;
                prev = last;
            }
            head = prev.next;
            prev.next = null;
        }
    }

    //Recursion
    class Solution_Recursion {
        ListNode head;
        boolean done;
        public void reorderList(ListNode head) {
            if (head == null || head.next == null || head.next.next == null)
                return;
            this.head = head;
            done = false;
            makeItDone(head);
        }
        public void makeItDone(ListNode node){
            if (node.next == null)  return;
            makeItDone(node.next);
            if (done)   return;
            ListNode next = head.next;
            head.next = node.next;
            head.next.next = next;
            if (head == node || next == node){
                next.next = null;
                done = true;
            }
            head = next;
        }
    }

    //Stack
    class Solution_Stack {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null || head.next.next == null)
                return;
            Stack<ListNode> stack = new Stack<>();
            ListNode cur = head;
            while (cur != null){
                stack.push(cur);
                cur = cur.next;
            }
            int size = stack.size();
            cur = head;
            while (stack.size() > Math.ceil((double)size / 2)){
                ListNode next = stack.pop();
                next.next = null;
                ListNode nextNext = cur.next;
                cur.next = next;
                next.next = nextNext;
                cur = nextNext;
            }
            if (cur != null) //把原链表的后面断了
                cur.next = null;
        }
    }
}
